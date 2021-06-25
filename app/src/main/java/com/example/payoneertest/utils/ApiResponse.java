package com.example.payoneertest.utils;

import com.example.payoneertest.models.ListResult;

// Class that saves the Api response in its instance
// and is used to get response wherever in the app it is needed

public class ApiResponse
{
    private static ApiResponse instance;
    private ListResult listResult;

    public ListResult getListResult()
    {
        return listResult;
    }

    public void setListResult(ListResult listResult)
    {
        this.listResult = listResult;
    }

    public static ApiResponse getInstance()
    {
        if (instance == null)
        {
            instance = new ApiResponse();
        }
        return instance;
    }
}
