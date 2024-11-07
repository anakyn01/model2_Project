package com.spring.pagenation.domain;

import java.util.Date;

public class BoardVO {//Getter와 setter가 있어야 데이터를 사용할수 있기에 필수 작업입니다

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	
	public int getBno() {return bno;}
	public String getTitle() {return title;}
	public String getContent() {return content;}
	public String getWriter() {return writer;}
	public Date getRegDate() {return regDate;}
	public int getViewCnt() {return viewCnt;}
	
	public void setBno(int bno) {this.bno = bno;}
	public void setTitle(String title) {this.title = title;}
	public void setContent(String content) {this.content = content;}
	public void setWriter(String writer) {this.writer = writer;}
	public void setRegDate(Date regDate) {this.regDate = regDate;}
	public void setViewCnt(int viewCnt) {this.viewCnt = viewCnt;}
	
	
}
