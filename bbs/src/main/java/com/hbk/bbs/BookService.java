package com.hbk.bbs;

import java.util.List;
import java.util.Map;

public interface BookService {

	String create(Map<String, Object> map);//메소드 시그니처

	Map<String, Object> detail(Map<String, Object> map);//디테일 메소드 시그니처

	boolean edit(Map<String, Object> map);//책수정 기능 메소드 시그니처

	boolean remove(Map<String, Object> map);//삭제 기능 메소드 시그니처

	List<Map<String, Object>> list(Map<String, Object> map);//리스트 메소드 시그니처

}
