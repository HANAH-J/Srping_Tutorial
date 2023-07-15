package spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect1 { // POJO기반 자바 클래스
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable { // 범용적
						 // 핵심 기능을 가진 객체에 대한 모든 정보
		long start = System.nanoTime();
		
		try {
			// 핵심 기능으로 연결시켜 줄 메서드
			Object result = joinPoint.proceed();	
			return result;
		} finally {
			long end = System.nanoTime();
			System.out.println("계산 시간 : " + (end-start));

			Signature sig = joinPoint.getSignature();
			// 1. 핵심 기능을 수행하기 위한 메서드의 이름?
			String methodName = sig.getName(); // 핵심 기능을 실행하기 위한 메서드 이름
			System.out.println("메서드 이름 : " + methodName);
			String methodAllInfo = sig.toLongString();
			System.out.println("메서드 모든 정보 : " + methodAllInfo);
			
			// 2. 핵심 기능의 메서드를 가진 객체
			String className = joinPoint.getTarget().getClass().getSimpleName();
			System.out.println("클래스 이름 : " + className);
			
			// 3. 파라미터 정보(매개데이터)
			String argParameters = Arrays.toString(joinPoint.getArgs());
			System.out.println("파라미터 정보 : " + argParameters);
		}
	}
}