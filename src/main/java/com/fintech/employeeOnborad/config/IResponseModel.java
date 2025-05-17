package com.fintech.employeeOnborad.config;


import com.fintech.employeeOnborad.errors.ErrorCompact;

public interface IResponseModel<T>
{
    String getMessage ();
    T getData ();
    String getTimeStamp ();
    ErrorCompact getError ();
}
