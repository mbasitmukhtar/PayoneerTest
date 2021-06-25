
package com.example.payoneertest.models;

public class ListResult
{
    private Identification identification;
    private String integrationType;
    private Interaction interaction;
    private Links links;
    private Networks networks;
    private String operation;
    private String operationType;
    private Payment payment;
    private String resultCode;
    private String resultInfo;
    private ReturnCode returnCode;
    private Status status;
    private Style style;
    private String timestamp;

    public Identification getIdentification()
    {
        return identification;
    }

    public void setIdentification(Identification identification)
    {
        this.identification = identification;
    }

    public String getIntegrationType()
    {
        return integrationType;
    }

    public void setIntegrationType(String integrationType)
    {
        this.integrationType = integrationType;
    }

    public Interaction getInteraction()
    {
        return interaction;
    }

    public void setInteraction(Interaction interaction)
    {
        this.interaction = interaction;
    }

    public Links getLinks()
    {
        return links;
    }

    public void setLinks(Links links)
    {
        this.links = links;
    }

    public Networks getNetworks()
    {
        return networks;
    }

    public void setNetworks(Networks networks)
    {
        this.networks = networks;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public String getOperationType()
    {
        return operationType;
    }

    public void setOperationType(String operationType)
    {
        this.operationType = operationType;
    }

    public Payment getPayment()
    {
        return payment;
    }

    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public String getResultInfo()
    {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo)
    {
        this.resultInfo = resultInfo;
    }

    public ReturnCode getReturnCode()
    {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode)
    {
        this.returnCode = returnCode;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Style getStyle()
    {
        return style;
    }

    public void setStyle(Style style)
    {
        this.style = style;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

}
