package com.example.payoneertest.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.payoneertest.R;
import com.example.payoneertest.models.ListResult;
import com.example.payoneertest.payments.PayoneerApi;
import com.example.payoneertest.utils.ApiResponse;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    String baseURL;

    ProgressDialog progressDialog;
    TextView tvResult;
    Button btnSelectPaymentMethod;

    Retrofit retrofit;
    PayoneerApi payoneerApi;
    Call<ListResult> listResultCall;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isInternetAvailable())
        {
            initUI();
            initRetrofit();
        } else
        {
            networkNotAvailable();
        }
    }

    private void initUI()
    {
        Log.d(TAG, "initUI: ");
        tvResult = findViewById(R.id.tvResult);
        btnSelectPaymentMethod = findViewById(R.id.btnSelectPaymentMethod);
    }

    private boolean isInternetAvailable()
    {
        Log.d(TAG, "isInternetAvailable: ");
        boolean connected = false;

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();

        if (nInfo != null)
        {
            connected = nInfo.isAvailable() && nInfo.isConnected();
            Log.d(TAG, "checkInternetConnectionStatus: isConnected" + connected);
        }

        return connected;
    }

    private void networkNotAvailable()
    {
        Log.d(TAG, "networkNotAvailable: ");
        tvResult.setText(R.string.No_internet_connection);
    }


    private void initRetrofit()
    {
        Log.d(TAG, "initRetrofit: ");
        baseURL = "https://raw.githubusercontent.com/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        payoneerApi = retrofit.create(PayoneerApi.class);

        initPaymentButton();
    }

    private void initPaymentButton()
    {
        Log.d(TAG, "initPaymentButton: ");
        btnSelectPaymentMethod.setOnClickListener(v ->
        {
            Log.d(TAG, "initPaymentButton: onClick");
            showProgressDialog();
            makeRequestForPaymentList();
        });
    }

    private void showProgressDialog()
    {
        Log.d(TAG, "showProgressDialog: ");
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog_layout);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    private void dismissProgressDialog()
    {
        Log.d(TAG, "dismissProgressDialog: ");
        if (progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }

    private void makeRequestForPaymentList()
    {
        Log.d(TAG, "makeRequestForPaymentList: ");
        listResultCall = payoneerApi.getPaymentMethods();
        listResultCall.enqueue(new Callback<ListResult>()
        {
            @Override
            public void onResponse(@NotNull Call<ListResult> call, @NotNull Response<ListResult> response)
            {
                int code = response.code();
                Log.d(TAG, "onResponse: " + code);

                if (code >= 200 && code < 300)
                {
                    success(response);
                } else if (code == 401)
                {
                    unauthenticated(response);
                } else if (code == 404)
                {
                    notFound(response);
                } else if (code >= 400 && code < 500)
                {
                    clientError(response);
                } else if (code >= 500 && code < 600)
                {
                    serverError(response);
                } else
                {
                    unexpectedError(new Throwable(getString(R.string.unexpected_response) + response));
                }
            }

            @Override
            public void onFailure(@NotNull Call<ListResult> call, @NotNull Throwable t)
            {
                Log.d(TAG, "onFailure: " + t.getMessage());
                if (t instanceof IOException)
                {
                    networkError((IOException) t);
                } else
                {
                    unexpectedError(t);
                }
            }
        });

    }

    private void networkError(IOException t)
    {
        tvResult.setText(R.string.networkError);
        Log.d(TAG, "networkError: " + t.getMessage());
    }

    private void unexpectedError(Throwable t)
    {
        tvResult.setText(R.string.unexpectedError);
        Log.d(TAG, "serverError: " + t.getMessage());
    }

    private void serverError(Response<ListResult> response)
    {
        tvResult.setText(R.string.serverError);
        Log.d(TAG, "serverError: " + response.errorBody());
    }

    private void clientError(Response<ListResult> response)
    {
        tvResult.setText(R.string.clientError);
        Log.d(TAG, "clientError: " + response.errorBody());
    }

    private void notFound(Response<ListResult> response)
    {
        tvResult.setText(R.string.notFound);
        Log.d(TAG, "notFound: " + response.errorBody());
    }

    private void unauthenticated(Response<ListResult> response)
    {
        tvResult.setText(R.string.unauthenticated);
        Log.d(TAG, "unauthenticated: " + response.errorBody());
    }

    private void success(Response<ListResult> response)
    {
        Log.d(TAG, "success: " + response.message());
        if (response.body() != null)
        {
            ApiResponse.getInstance().setListResult(response.body());
            dismissProgressDialog();
            Intent intent = new Intent(MainActivity.this, PaymentMethodsActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed()
    {
        Log.d(TAG, "onBackPressed: ");
        super.onBackPressed();
        dismissProgressDialog();
    }

    @Override
    protected void onDestroy()
    {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
        listResultCall.cancel();
    }
}