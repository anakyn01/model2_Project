package kyobo.kr.booksmall;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kyobo.kr.booksmall.mapper.MemberMapper;
import kyobo.kr.booksmall.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class MemberMapperTests {
	
	@Inject
	private MemberMapper membermapper;//MemberMapper.java 의존성 주입
	
	@Test
	public void memberIdChk() throws Exception{
		String id = "anakyn";
		String id2 = "test123";
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
	}
	/*public void memberJoin() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setMemberId("spring_test");
		member.setMemberPw("spring_test");
		member.setMemberName("spring_test");
		member.setMemberMail("spring_test");
		member.setMemberAddr1("spring_test");
		member.setMemberAddr2("spring_test");
		member.setMemberAddr3("spring_test");
		
		membermapper.memberJoin(member); //쿼리 메서드 실행
	}*/

}
