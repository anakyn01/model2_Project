package com.spring.pagenation.nexture;

public abstract class ServiceMenu {
int cut;
int color;
int perm;
int shampoo;
int massage;
ServiceMenu(){
	this.cut = PriceTable.CUT;
	this.color = PriceTable.COLOR;
	this.perm = PriceTable.PERM;
	this.shampoo = PriceTable.SHAMPOO;
	this.massage = PriceTable.massage;
}

public abstract String calculator();
}
/*
데이터 추상화 는 특정 세부 정보를 숨기고 사용자에게 필수적인 정보만 보여주는 프로세스입니다.
추상화는 추상 클래스 또는 인터페이스 
객체를 생성하는데 사용할수없는 클래스

추상 메소드 : 추상클래스에서만 사용합니다 본문이 없다
*/
