
package com.example.payoneertest.models;

import java.util.List;

public class Applicable
{
    private String code;
    private String grouping;
    private List<InputElement> inputElements;
    private String label;
    private Links links;
    private String method;
    private String operationType;
    private String recurrence;
    private Boolean redirect;
    private String registration;
    private Boolean selected;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getGrouping()
    {
        return grouping;
    }

    public void setGrouping(String grouping)
    {
        this.grouping = grouping;
    }

    public List<InputElement> getInputElements()
    {
        return inputElements;
    }

    public void setInputElements(List<InputElement> inputElements)
    {
        this.inputElements = inputElements;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public Links getLinks()
    {
        return links;
    }

    public void setLinks(Links links)
    {
        this.links = links;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getOperationType()
    {
        return operationType;
    }

    public void setOperationType(String operationType)
    {
        this.operationType = operationType;
    }

    public String getRecurrence()
    {
        return recurrence;
    }

    public void setRecurrence(String recurrence)
    {
        this.recurrence = recurrence;
    }

    public Boolean getRedirect()
    {
        return redirect;
    }

    public void setRedirect(Boolean redirect)
    {
        this.redirect = redirect;
    }

    public String getRegistration()
    {
        return registration;
    }

    public void setRegistration(String registration)
    {
        this.registration = registration;
    }

    public Boolean getSelected()
    {
        return selected;
    }

    public void setSelected(Boolean selected)
    {
        this.selected = selected;
    }

}
