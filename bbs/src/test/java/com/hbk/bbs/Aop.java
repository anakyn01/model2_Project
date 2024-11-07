package com.hbk.bbs;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //aop 구현클래스에 
public class Aop {
	
	@Pointcut("execution(public * com.hbk.bbs..*(..))")//공통기능
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")//공통기능을 구현한 메서드에 Throwable[예외처리를 할수있는 최상위 클래스]
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		 long start = System.nanoTime();
		 try {Object result = joinPoint.proceed();
/*AOP around의 proceed()메소드에 동작에 대한 개념정리
Advice메소드의 동작시점
before :비즈니스 메소드 실행전에 advice메소드 실행
after-returning : 비즈니스 메소드가 성공적으로 리턴되면 advice메소드 동작 
after-throwing : 비즈니스 메소드 실행중 예외[실패]가 발생할 경우
after : 비즈니스 메소드의 성공 실패와 상관없이 비즈니스 메소드 실행후 무조건 Advice메소드 동작
around : 비즈니스 메소드 실행전과 실행후 Advice메소드 동작형태

around 어드바이스 메소드를 비즈니스 메소드로 진행하도록 하는 메소드가 proceed()메소드이다
proceed()메소드가 리턴 시키는 값이 Object[비즈니스 결과 값이 담김]

자바에서 메서드 이름과 파라미터를 합쳐서 메서드 시그니처라고 합니다
*/
		 return result;
		 }finally {
			 long finish = System.nanoTime();
			 Signature sig = joinPoint.getSignature();
			 System.out.printf("%s.%s(%s) 실행시간 : %d ns\n",joinPoint.getTarget().getClass().getSimpleName(), sig.getName(), Arrays
					 .toString(joinPoint.getArgs()), (finish - start));
		 }
		 /*Signature : 메서드 정의에서 매서드 이름과 매개변수 리스트의 조합
		 어플리케이션에 대해서 디지털서명 알고리즘.
		 */
	}

}
/*여러 객체에 공통으로 적용할수 있는 기능을 분리해서 재사용성을 높여주는 프로그래밍 기법
- 컴파일 시점에서 코드에 공통기능을 삽입하는 방법
- 클래스 로딩 시점에 바이트 코드에 공통기능을 삽입하는 방법
- 런타임에 프록시 객체를 생성해서 공통기능을 삽입하는 방법
스프링에 AOP구현
@Aspect, @Pointcut[공통기능], @Around[공통기능을 구현한 메서드에]

캐시 기능, 성능 모니터링 기능과 같은 Around Advice를 이용합니다
*/
