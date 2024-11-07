package kyobo.kr.booksmall.mapper;


import kyobo.kr.booksmall.vo.MemberVO;

public interface MemberMapper {

	//회원등록 insert쿼리를 실행시켜줄 매서드 작성
	public void memberJoin(MemberVO member);
	//아이디 중복검사
	public int idCheck(String memberId);

}
