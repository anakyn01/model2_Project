package com.spring.shop.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.spring.shop.domain.MemberVO;
import com.spring.shop.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;//1
	
	//회원가입
	@Override
	public void signup(MemberVO vo)throws Exception{//2
		dao.signup(vo);
	}

	@Override//로그인
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
	}

	@Override//로그아웃
	public void signout(HttpSession session) throws Exception {
		session.invalidate();		
	}

}
