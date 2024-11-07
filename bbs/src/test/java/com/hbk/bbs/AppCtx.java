package com.hbk.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	@Autowired(required = false)
	MemberDao memberDao;
	
	//자동 주입이 가능한 빈이 두 개 이상이면 자동 주입할 빈을 지정할 수 있는 방법이 필요하다. @Qualifier 애노테이션을 사용하면 자동 주입 대상 빈을 한정할 수 있다.
@Bean
@Qualifier("printer")
public MemberPrinter memberPrinter1() {
	return new MemberPrinter();
}

@Bean
@Qualifier("printer")
public MemberPrinter memberPrinter2() {
	return new MemberPrinter();
}
	

}
