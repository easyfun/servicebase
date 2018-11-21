package com.efun.common;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.enums.Result;
import com.efun.framework.common.exception.BaseException;
import com.efun.framework.common.exception.CommonErrorCode;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.common.utils.ValidateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.validation.ValidationException;

@Aspect
@Configuration
public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	@Around(value = "execution(* com.efun.*.rpcimpl.*RpcServiceImpl.*(..))")
	public Object rpcProcess(ProceedingJoinPoint point) throws ValidationException, Throwable {
		String method = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
		Object[] params = point.getArgs();

		try {
			logger.info("[{}]paramDTO:{}", method, JsonUtil.toJSONString(params));
			for (Object obj : params) {
				ValidateUtil.validate(obj);
			}
			Object returnValue = point.proceed(params);
			logger.info("[{}]resultDTO:{}", method, JsonUtil.toJSONString(returnValue));
			return returnValue;
		} catch (Exception e) {
			logger.error("[{}]exception.", method, e);
			Class<?> returnType = getReturnType(point, params);
			BaseResultDTO resultDTO = (BaseResultDTO) returnType.newInstance();
			resultDTO.setResult(Result.fail);
			if (e instanceof ValidationException) {
				resultDTO.setFailCode(CommonErrorCode.paramError.getFailCode());
			} else {
				resultDTO.setFailCode(BaseException.getFailCode(e));
			}
			logger.info("[{}]resultDTO:{}", method, JsonUtil.toJSONString(resultDTO));
			return resultDTO;
		}
	}

//	private Object process(ProceedingJoinPoint point) throws ValidationException, Throwable {
//		String method = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
//		Object[] params = point.getArgs();
//		logger.info("[{}]请求参数:{}", method, JsonUtil.toJSONString(params));
//		Object returnValue = point.proceed(params);
//		logger.info("[{}]返回结果:{}", method, JsonUtil.toJSONString(returnValue));
//		return returnValue;
//	}

	private Class<?> getReturnType(ProceedingJoinPoint point, Object[] params) throws NoSuchMethodException {
		Class<?>[] paramClasses = new Class[params.length];
		for (int i=0; i<params.length; ++i) {
			paramClasses[i] = params[i].getClass();
		}
		Class<?> declaringType = point.getSignature().getDeclaringType();
		String methodName = point.getSignature().getName();
		Class<?> returnType = declaringType.getMethod(methodName, paramClasses).getReturnType();
		return returnType;
	}
}
