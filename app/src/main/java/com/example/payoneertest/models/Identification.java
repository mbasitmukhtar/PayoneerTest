
package com.example.payoneertest.models;

public class Identification
{
    private String longId;
    private String shortId;
    private String transactionId;

    public String getLongId()
    {
        return longId;
    }

    public void setLongId(String longId)
    {
        this.longId = longId;
    }

    public String getShortId()
    {
        return shortId;
    }

    public void setShortId(String shortId)
    {
        this.shortId = shortId;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

}
