package kyobo.kr.booksmall.service;

import kyobo.kr.booksmall.vo.MemberVO;

public interface MemberService {

	//ȸ������ 
	public void memberJoin(MemberVO member)throws Exception;
	
	//���̵� �ߺ��˻�
	public int idCheck(String memberId) throws Exception;
}
