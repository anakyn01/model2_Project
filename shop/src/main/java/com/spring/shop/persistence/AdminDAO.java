package com.spring.shop.persistence;

import java.util.List;

import com.spring.shop.domain.CategoryVO;
import com.spring.shop.domain.GoodsVO;
import com.spring.shop.domain.GoodsViewVO;

public interface AdminDAO {
	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	//상품등록
	public void register(GoodsVO vo) throws Exception;
	
	//상품목록
	public List<GoodsVO> goodslist() throws Exception;
	
	//view
	//public GoodsVO goodsView(int gdsNum) throws Exception;
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//상품삭제
	public void goodsDelete(int gdsNum) throws Exception;
	
	
	
	
	
	
}
