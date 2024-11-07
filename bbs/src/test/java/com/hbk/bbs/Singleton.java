package com.hbk.bbs;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Singleton {//fuzo로 구현
	private static final Singleton instance = new Singleton();
	//인스탄스 객체 생성
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {//인스턴스가 필요할때 마다 getInstance()가 항상 사용하도록 합니다
		return instance;
	}
	
	public void singleton() {
		System.out.println("Singleton");
	}
	
	@Test
	void sigletonTest() {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1 = " + instance1);
		System.out.println("instance2 = " + instance2);
		
		//assertThat(instance1).isSameAS(instance2);
	}
	

}
/*
싱글톤(Singleton)
특정 클래스의 인스턴스를 1개만 생성되는것을 보장하는 디자인패턴
생성자를 통해서 여러 번 호출이 되더라도 인스턴스를 새로 생성하지 않고 
최초 호출시에 만들어 두었던 인스턴스 재활용하는 패턴

1초에 10번 똑같은 요청을 보내면 요청을 처리하기 위한 똑같은 객체를 1초에 10번 생성하고 소멸하는
메모리 낭비 문제가 발생합니다

그래서 싱글톤 패턴을 사용하면 객체한번 생성후 여러번 재사용하기에 메모리 낭비를 방지 할수 있다

싱글톤 단점
- 의존성이 높아진다(높은 결합[클래스 사이에 의존성])
- private생성자 때문에 상속이 어렵다 => 상속을 통한 자식 클래스로 만들수 없다
- 테스트하기가 힘들다 
싱글톤 패턴의 인스턴스는 자원을 공유하고 있다는 특징을 가집니다
서로 독립적이어야 하는 단위 테스트에 문제가 발생합니다

그래서 안티패턴이라고 얘기 합니다


*/
