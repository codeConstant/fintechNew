package com.fintech.employeeOnborad.config;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fintech.employeeOnborad.errors.ErrorCompact;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel<T> implements IResponseModel<T>
{
    private String       message;
    private T            data;
    private ErrorCompact error;
    
    @Override
    public String getMessage ()
    {
        return this.message;
    }
    
    @Override
    public T getData ()
    {
        return this.data;
    }
    
    @Override
    public String getTimeStamp ()
    {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(new Date());
    }
    
    @Override
    public ErrorCompact getError ()
    {
        return this.error;
    }
}
