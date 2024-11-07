package com.hbk.bbs;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

	@Autowired //의존대상을 설정 코드에서 직업 주입하지 않고 
	//스프링이 자동으로 의존하는 빈 객체를 주입해주는 기능 이를 자동 주입이라 한다
	private MemberDao memberDao;
	
	public void ChangePassword(String email, String oldPwd, String newPwd) throws MemberNotFoundException {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
