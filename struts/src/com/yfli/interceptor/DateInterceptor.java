package com.yfli.interceptor;

import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.yfli.struts.action.ProductAction;
 
public class DateInterceptor extends AbstractInterceptor {
 
    public String intercept(ActionInvocation invocation) throws Exception {
       ProductAction action = (ProductAction)invocation.getAction();
       action.setDate(new Date());
       
       return invocation.invoke();
    }
}
