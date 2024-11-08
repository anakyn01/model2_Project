package com.hbk.bbs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);	
Greeter g = ctx.getBean("greeter", Greeter.class);
String msg = g.greet("스프링 레거시");
System.out.println(msg);
ctx.close();

	}

}
/*
ApplicationConfigApplicationContext 클래스는 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
AnnotaitionConfigApplicationContext는 객체를 생성할 때 앞서 작성한 AppContext 클래스를 생성자 파라미터로 전달한다. 
AnnotationConfigApplicationContext는 AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화 한다.
getBean()메서드는 AnnotationConfigApplicationContext가 자바 설정을 읽어와 생성한 빈 객체를 검색할 때 사용된다. 
첫 번째 파라미터는 @Bean 애노테이션의 메서드 이름인 빈 객체의 이름이며, 두 번째 파라미터는 검색할 빈 객체의 타입이다.
*/
