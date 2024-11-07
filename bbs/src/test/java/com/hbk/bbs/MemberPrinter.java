package com.hbk.bbs;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {

	private DateTimeFormatter dateTimeFormatter;
	/*자동 주입 대상 타입이 Optional인 경우, 일치하는 빈이 존재하지 않으면 값이 없는 Optional을 인자로 전달하고, 
	 * 일치하는 빈이 존재하면 해당 빈을 값으로 갖는 Optional을 인자로 전달한다*/
	public void setDateFormatter(Optional<DateTimeFormatter> dateTimeFormatter) {
	//public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		if(dateTimeFormatter.isPresent()) {
			this.dateTimeFormatter = dateTimeFormatter.get();
		}else {
			this.dateTimeFormatter = null;
		}
	}
	/*
	@Autowired 애노테이션을 붙인 세터 메서드에서 @Nullable 애노테이션을 의존 주입 대상 파라미터에 붙이면, 
	스프링 컨테이너는 세터 메서드를 호출할 때 자동 준비할 빈이 존재하면 해당 빈을 인자로 전달하고, 
	존재하지 않으면 인자로 null을 전달한다
	*/
}
