package kyobo.kr.booksmall.mapper;


import kyobo.kr.booksmall.vo.MemberVO;

public interface MemberMapper {

	//ȸ����� insert������ ��������� �ż��� �ۼ�
	public void memberJoin(MemberVO member);
	//���̵� �ߺ��˻�
	public int idCheck(String memberId);

}
