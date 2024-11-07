package com.spring.shop.service;

import javax.servlet.http.HttpSession;

import com.spring.shop.domain.MemberVO;

public interface MemberService {

	void signup(MemberVO vo) throws Exception;//회원가입 시그니처
	
	public MemberVO signin(MemberVO vo)throws Exception;//로그인
	
	public void signout(HttpSession session)throws Exception;//로그아웃
	
	

}
