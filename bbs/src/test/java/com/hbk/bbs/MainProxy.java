package com.hbk.bbs;

public class MainProxy {
	
	public static void main(String[] args) {
		ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCal1.factorial(20));
		
		ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factorial(20));
	}
	/*
	핵심 기능의 실행은 다른 객체에 위임하고 부가적인 기능을 제공하는 객체를 프록시(proxy)라고 부른다
실제 핵심 기능을 실행하는 객체는 대상객체라고 부른다	
new ExeTimeCalculator 프록시 
new ImpeCalculator(), RecCalculator()대상 객체입니다
프록시에 특징 핵심기능은 구현하지 않는다 대신에 여러 객체에 공통으로 적용할수 있는 기능을 구현한다
공통기능 구현과 핵심기능 구현을 분리하는 것이 AOP의 핵심이다
	*/

}
