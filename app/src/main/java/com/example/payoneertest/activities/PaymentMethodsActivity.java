package com.example.payoneertest.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.payoneertest.R;
import com.example.payoneertest.adapters.PaymentListAdapter;
import com.example.payoneertest.models.Applicable;
import com.example.payoneertest.utils.ApiResponse;

import java.util.List;

public class PaymentMethodsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_methods);

        initPaymentMethodsList();
    }

    private void initPaymentMethodsList()
    {
        RecyclerView payment_methods_list = findViewById(R.id.payment_methods_list);
        List<Applicable> applicableList = ApiResponse.getInstance().getListResult().getNetworks().getApplicable();
        PaymentListAdapter paymentListAdapter = new PaymentListAdapter(this, applicableList);
        paymentListAdapter.notifyDataSetChanged();

        payment_methods_list.hasFixedSize();
        payment_methods_list.setLayoutManager(new GridLayoutManager(this, 1));
        payment_methods_list.setAdapter(paymentListAdapter);
    }
}