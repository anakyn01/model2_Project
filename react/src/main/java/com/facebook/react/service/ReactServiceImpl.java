package com.facebook.react.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.react.dao.ReactDAO;

@Service
public class ReactServiceImpl implements ReactService{
	
	private ReactDAO reactDAO;//ÇÊµå
	
	@Autowired//½Ì±ÛÅæ ÄÄÆ÷³ÍÆ®
	public ReactServiceImpl(ReactDAO reactDAO) {
		this.reactDAO = reactDAO;
	}

	@Override
	public int create(Map<String, Object> map) {
		int seq = this.reactDAO.insert(map);
		return seq;
	}

	@Override
	public Map<String, Object> read(int reactContSeq) {
		Map<String, Object> reactCont = this.reactDAO.selectOne(reactContSeq);
		return reactCont;
	}
	

}
