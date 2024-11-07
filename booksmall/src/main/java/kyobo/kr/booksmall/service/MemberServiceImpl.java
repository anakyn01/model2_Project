package kyobo.kr.booksmall.service;

import javax.inject.Inject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;




import kyobo.kr.booksmall.mapper.MemberMapper;
import kyobo.kr.booksmall.vo.MemberVO;

@Service
@MapperScan("kyobo.kr.booksmall.mapper")
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberMapper membermapper;

	@Override
	public void memberJoin(MemberVO member) throws Exception {
		membermapper.memberJoin(member);
	}

	@Override
	public int idCheck(String memberId) throws Exception {
		
		return membermapper.idCheck(memberId);
	}

}
