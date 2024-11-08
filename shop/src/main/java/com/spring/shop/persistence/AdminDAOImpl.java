package com.spring.shop.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.shop.domain.CategoryVO;
import com.spring.shop.domain.GoodsVO;
import com.spring.shop.domain.GoodsViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Inject
	private SqlSession sql;

	//매퍼
	private static String namespace = "com.spring.shop.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

	//상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
		
	}

	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	}

	//상품조회 view
	/*@Override
	public GoodsVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace+".goodsView",gdsNum);
	}*/
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace+".goodsView",gdsNum);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);	
	}

	@Override//삭제
	public void goodsDelete(int gdsNum) throws Exception {
		sql.delete(namespace + ".goodsDelete", gdsNum);
		
	}
	
	
	
	

}
