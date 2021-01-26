package com.skiya.sportzplatform.aop;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Intercepts({@Signature(
		  type= Executor.class,
		  method = "update",
		  args = {MappedStatement.class,Object.class})})
public class AuditInterceptor implements Interceptor{
	
	private final Logger log = LoggerFactory.getLogger(AuditInterceptor.class);
	
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		log.debug("Hello from Interceptor..." + invocation.getMethod().getName());
		// implement pre-processing if needed
	    Object returnObject = invocation.proceed();
	    // implement post-processing if needed
	    return returnObject;
		
	}
	
	

}
