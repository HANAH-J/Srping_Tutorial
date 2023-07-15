package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect2 {
	
	@Pointcut("execution(public * spring.calc..*(..))")
	private void factorialMethod() {}
	
	@Around("factorialMethod()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable { // 범용적
		// 핵심 기능을 가진 객체에 대한 모든 정보
		long start = System.nanoTime();

		try {
			// 핵심 기능으로 연결시켜 줄 메서드
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long end = System.nanoTime();
			System.out.println("계산 시간 : " + (end - start));
		}
	}
}