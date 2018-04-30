package com.yfli.ssh.interceptor;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.yfli.ssh.pojo.Category;
import com.yfli.ssh.service.CategoryService;
 
public class CategoryNamesBelowSearchInterceptor  extends AbstractInterceptor{ 
 
    @Autowired
    CategoryService categoryService;           
     
    @Override 
    public String intercept(ActionInvocation invocation) throws Exception {
           
        ActionContext ctx = invocation.getInvocationContext();
        HttpServletRequest request= (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
        ServletContext servletContext= (ServletContext) ctx.get(StrutsStatics.SERVLET_CONTEXT);
         
        String contextPath = servletContext.getContextPath();
        String uri = request.getRequestURI();
        uri =StringUtils.remove(uri, contextPath);
        if(uri.startsWith("/fore")){
                List<Category> cs = categoryService.list();
                ctx.getSession().put("cs", cs);
        }
        return invocation.invoke();
    
    } 
   
}