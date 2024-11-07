package com.spring.pagenation.domain;

public class Page {//페이징 관련 클래스

	/**
	 * 
	 */
	private int num;//현재 페이지 번호
	public int getPageNum() {
		return pageNum;
	}

	private int count;//게시물 총갯수
	private int postNum = 10;//한페이지에 출력할 게시물에 갯수
    private int pageNum;//하단 페이징 번호([게시물 총갯수 / 한페이지의 출력할 갯수]의 올림)
    private int displayPost; //출력할 게시물
    private int pageNumCnt = 10; //한번에 표시할 페이징 번호의 갯수
    private int endPageNum; //표시되는 페이지 번호중 마지막 번호
    private int startPageNum; //표시되는 페이지 번호중 첫번째 번호
    
    //다음 이전 표시여부
    private boolean prev;//11page이상일때
    private boolean next;
	
    public int getNum() {return num;}
	public int getCount() {return count;}
	public int getPostNum() {return postNum;}
	public int getDisplayPost() {return displayPost;}
	public int getPageNumCnt() {return pageNumCnt;}
	public int getEndPageNum() {return endPageNum;}
	public int getStartPageNum() {return startPageNum;}
	public boolean isPrev() {return prev;}
	public boolean isNext() {return next;}
	
	public void setNum(int num) {this.num = num;}
	public void setCount(int count) {this.count = count; dataCalc();}//함수 추가
	public void setPostNum(int postNum) {this.postNum = postNum;}
	public void setPageNum(int pageNum) {this.pageNum = pageNum;}
	public void setDisplayPost(int displayPost) {this.displayPost = displayPost;}
	public void setPageNumCnt(int pageNumCnt) {this.pageNumCnt = pageNumCnt;}
	public void setEndPageNum(int endPageNum) {this.endPageNum = endPageNum;}
	public void setStartPageNum(int startPageNum) {this.startPageNum = startPageNum;}
	public void setPrev(boolean prev) {this.prev = prev;}
	public void setNext(boolean next) {this.next = next;}
    
	private void dataCalc() {//데이터들을 재계산하는 메서드
		//마지막 번호
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		
		//시작 번호
		startPageNum = endPageNum - (pageNumCnt -1);
		
		//마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNumCnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		//prev next
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
		
		displayPost = (num - 1) * postNum;		
		
	}
	
	//검색 타입과 검색어
	private String searchType;
	private String keyword;
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getSearchTypeKeyword() {
		
		if(searchType.equals("") || keyword.equals("")) {
			return "";
		}else {
			return "&searchType=" + searchType + "&keyword=" + keyword;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
}
