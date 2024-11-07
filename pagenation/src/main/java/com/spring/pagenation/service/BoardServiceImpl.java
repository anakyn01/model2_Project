package com.spring.pagenation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.pagenation.dao.BoardDAO;
import com.spring.pagenation.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO dao;
	
	@Override//list
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}
	@Override//write
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);		
	}
	@Override
	public BoardVO view(int bno) throws Exception {
		return dao.view(bno);
	}
	@Override//수정
	public void modify(BoardVO vo) throws Exception{
		dao.modify(vo);
	}
	@Override
	public void delete(int bno) throws Exception{
		dao.delete(bno);
	}
	@Override
	public int count() throws Exception{
		return dao.count();
	}
	@Override//목록 + 페이징
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}
	@Override//목록 + 페이징 + 검색
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	@Override//게시물 총 갯수
	public int searchCount(String searchType, String keyword) throws Exception {
		return dao.searchCount(searchType, keyword);
	}

}
