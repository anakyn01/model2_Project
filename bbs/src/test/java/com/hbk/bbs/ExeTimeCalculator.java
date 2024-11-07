package com.hbk.bbs;
/*
프록시와 관점지향프로그래밍
프록시
재귀로 만들면 복잡해지고 실행시간을 밀리초가 아니라 나노초 단위로 바꾸면 코드수정이 필요하다
기존 코드를 수정하지 않고 코드 중복도 피할수 있는 방법이 프록시 객체이다

*/

public class ExeTimeCalculator implements Calculator {
	
	private Calculator delegate;
	
	public ExeTimeCalculator(Calculator delegate) {//생성자
		this.delegate = delegate;
	}

	@Override
	public long factorial(long num) {
long start = System.nanoTime();
long result = delegate.factorial(num);
long end = System.nanoTime();
System.out.printf("%s.factorial(%d) 실행 시간= %d\n", delegate.getClass().getSimpleName(), num, (end - start));	
return result;
	}

}
