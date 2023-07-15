package spring.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	
	// 캐시 저장소
	private Map<Long, Object> cache = new HashMap<>();
	
	public Object cacheExecute(ProceedingJoinPoint joinPoint) throws Throwable {
		Long num = (Long)joinPoint.getArgs() [0];
		
		if(cache.containsKey(num)) {
			System.out.println("캐시에서 수신 : " + num);
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		cache.put(num, result);
		System.out.println("캐시에 추가 : " + num);
		
		return result;
	}
}