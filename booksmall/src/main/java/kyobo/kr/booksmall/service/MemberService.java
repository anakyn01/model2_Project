package kyobo.kr.booksmall.service;

import kyobo.kr.booksmall.vo.MemberVO;

public interface MemberService {

	//회원가입 
	public void memberJoin(MemberVO member)throws Exception;
	
	//아이디 중복검사
	public int idCheck(String memberId) throws Exception;
}
