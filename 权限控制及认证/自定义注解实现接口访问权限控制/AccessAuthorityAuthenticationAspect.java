package com.sh.guog.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sh.guog.annotation.AccessAuthorityAuthentication;

@Aspect
@Component
public class AccessAuthorityAuthenticationAspect {

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
		String accessAuthority = getControllerMethodDescription(joinPoint);
		String[] accessAuthorities = accessAuthority.split(",");
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
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String accessAuthority = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					accessAuthority = method.getAnnotation(AccessAuthorityAuthentication.class).accessAuthority();
					break;
				}
			}
		}
		return accessAuthority;
	}

}
