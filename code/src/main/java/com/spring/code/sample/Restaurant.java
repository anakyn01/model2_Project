package com.spring.code.sample;
/*
value=접근제한 속성을 의미합니다 => lombok.AccesslevelPublic
onMethod 
setter메서드 생성시 메서드에 추가할 어노테이션을 지정합니다
onParam  setter매서드의 파라미터에 어노테이션을 사용하는 경우에 적용합니다
*/
/*
스프링 4.3이후 단일 생성자 묵시적 자동주입 
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component //스프링에서 관리해야 하는 대상
@Data//가장 자주 사용하는 어노테이션 
//ToStringm EqualAndHashCode, @Getter, @Setter
public class Restaurant {
	
	@Setter(onMethod = @_({@Autowired}))
	private Chef chef;

}
