package com.spring.shop.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.shop.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.spring.shop.mappers.memberMapper";

	@Override//회원가입
	public void signup(MemberVO vo) throws Exception {
		sql.insert(namespace + ".signup", vo);
		
	}

	@Override//로그인
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".signin", vo);
	}

}
