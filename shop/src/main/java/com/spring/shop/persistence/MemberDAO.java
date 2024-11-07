package com.spring.shop.persistence;

import com.spring.shop.domain.MemberVO;

public interface MemberDAO {
 //회원가입 
 public void signup(MemberVO vo)throws Exception;
 //로그인
 public MemberVO signin(MemberVO vo)throws Exception;
}
