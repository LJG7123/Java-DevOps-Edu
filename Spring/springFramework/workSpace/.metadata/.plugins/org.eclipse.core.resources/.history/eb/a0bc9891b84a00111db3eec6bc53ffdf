package kosta.advice;

import org.aspectj.lang.JoinPoint;

public class SampleAdvice {
	/**
	 * 사전처리
	 */
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + "의 before입니다.\n");
	}
	
	/**
	 * 사후처리(정상 동작)
	 */
	public void afterReturning(JoinPoint joinPoint, Object obj) {
		System.out.println("정상적으로 동작했을 때 사후처리입니다.");
		
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + "의 리턴값은 " + obj + "\n");
	}
	
	/**
	 * 사후처리(예외 발생)
	 */
	public void afterThrowing(Throwable e) {
		System.out.println("예외가 발생했을 때 사후처리입니다. ");
		System.out.println("예외정보: " + e);
	}
	
	/**
	 * 사후처리(무조건)
	 */
	public void afterFinally() {
		System.out.println("예외발생 여부와 상관없이 무조건 사후처리");
	}
}
