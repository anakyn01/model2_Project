package com.hbk.bbs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
/*
컴포넌트 스캔은 스프링이 직접 클래스를 검색해서 빈으로 등록해 주는 기능이다
설정 클래스에서 빈으로 등록하지 않아도 원하는 클래스를 빈으로 등록할수 있으므로 
컴포넌트 스캔기능을 사용하면 설정코드가 크게 줄어든다
*/
@ComponentScan(basePackages= {"spring"}, excludeFilters= @Filter(type=FilterType.REGEX, pattern="spring\\..*Dao"))
/*@Component 어노테이션을 붙인 클래스를 스캔해서 스프링 빈으로 등록하려면 설정 클래스에서 @ComponentScan어노테이션을 적용해야 한다
이 코드는 @Filter 애노테이션의 type 속성값으로 FilterType.REGEX를 주었다. 이는 정규표현식을 사용해서 제외 대상을 지정한다는 것을 의미한다. 
위 설정에서는 "spring."으로 시작하고 Dao로 끝나느 정규표현식을 지정했으므로 spring.MemberDao 클래스를 컴포넌트 스캔 대상에서 제외한다.

@Component 애노테이션을 붙인 클래스만 컴포넌트 스캔 대상에 포함되는 것은 아니다. 
다음 애노테이션을 붙인 클래스가 컴포넌트 스캔 대상에 포함된다.

@Component
@Controller
@Service
@Repository
@AspectJ : 자바에서 완벽한 AOP솔루션 제공을 목표로 한다 OOP객체지향
AOP 관점지향프로그래밍 반복되고 공통적으로 사용되는 부분을 분리합니다
@Configuration

@Aspect 애노테이션을 제외한 나머지 애노테이션은 실제로는 @Component 애노테이션에 대한 특수 애노테이션이다.

컴포넌트 스캔에 따른 충돌 처리
컴포넌트 스캔 기능을 사용해서 자동으로 빈을 등록할 때는 충돌에 주의해야 한다. 크게 빈 이름 충돌과 수동 등록에 따른 충돌이 발생할 수 있다.

빈 이름 충돌
spring 패키지와 spring2 패키지에 MemberRegisterService 클래스가 존재하고 
두 클래스 모두 @Component 애노테이션을 붙였다고 하자. 이 상태에서 spring과 spring2 모두 컴포넌트 스캔을 하면 익셉션이 발생하낟.

이렇게 컴포넌트 스캔 과정에서 서로 다른 타입인데 같은 빈 이름을 사용하는 경우가 있다면 
둘 중 하나에 명시적으로 빈 이름을 지정해서 이름 충돌을 피해야 한다.

수동 등록한 빈과 충돌
스캔할 때 사용하는 빈 이름과 수동 등록한 빈 이름이 같은 경우 수동 등록한 빈이 우선한다.
*/
public class ComScan {

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
}
