package com.example.payoneertest.payments;

import com.example.payoneertest.models.ListResult;

import retrofit2.Call;
import retrofit2.http.GET;

// interface that utilizes Retrofit's @GET annotation
// to automatically handle the making of request

public interface PayoneerApi
{
    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    Call<ListResult> getPaymentMethods();
}
