package com.sh.guog.aspect;

import java.util.Arrays;
import java.util.List;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sh.guog.annotation.AccessAuthorityAuthentication;

@Aspect
@Component
public class AccessAuthorityAuthenticationAspect {

	private Logger logger = LoggerFactory.getLogger(AccessAuthorityAuthenticationAspect.class);

	// Controller层切点
	@Pointcut("@annotation(com.sh.guog.annotation.AccessAuthorityAuthentication)")
	public void controllerAspect() {
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 *
	 * @param joinPoint
	 *            切点
	 * @throws Exception
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 请求的用户角色
		System.out.println(request.getRequestURL());
		String userRole = request.getHeader("userRole");
		String[] accessAuthorities = ((AccessAuthorityAuthentication) ((MethodSignature) joinPoint.getSignature())
				.getMethod().getAnnotation(AccessAuthorityAuthentication.class)).accessAuthority();

		Object[] objs = joinPoint.getArgs();
		StringBuffer sb = null;
		if (objs != null && objs.length > 0) {
			sb = new StringBuffer();
			for (int i = 0, n = objs.length; i < n; i++) {
				sb.append(objs[i]);
			}
		}
		logger.info("current user role is {}; request parameters are {}", userRole, sb);
		if (accessAuthorities != null && accessAuthorities.length > 0) {
			List<String> list = Arrays.asList(accessAuthorities);
			if (list.contains(userRole)) {
				return;
			} else {
				throw new AuthenticationException();
			}

		}
	}

	/**
	 * 接口正常处理完业务请求触发
	 * 
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(returning = "result", pointcut = "controllerAspect()")
	public void after(JoinPoint joinPoint, Object result) {
		logger.info("return result are {}", result);
	}

}
