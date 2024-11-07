package com.spring.shop.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.shop.domain.CategoryVO;
import com.spring.shop.domain.GoodsVO;
import com.spring.shop.domain.GoodsViewVO;
import com.spring.shop.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	private AdminDAO dao;

	@Override
	public List<CategoryVO> category() throws Exception {

		return dao.category();
	}

	//상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
	}

	@Override
	public List<GoodsVO> goodslist() throws Exception {
		// TODO Auto-generated method stub
		return dao.goodslist();
	}

	//상품조회
	/*@Override
	public GoodsVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}*/
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}

	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
		
	}
	
	

}
