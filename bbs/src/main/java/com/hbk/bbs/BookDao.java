package com.hbk.bbs;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//디펜던시(Dependency Injecttion) 의존성주입 객체가 필요로하는 의존객체를 외부에서 제공(주입)하는 방식
@Repository//해당클래스가 데이터 접근 계층의 구현체임을 며시적표현
public class BookDao {
	 @Autowired // @Autowired 가 붙은 필드 생성자,세터 메서드등에 자동으로 관련의존성(빈)
	 SqlSessionTemplate sqlSessionTemplate;
	 
	 //제너릭이란 java에서 많이 쓰이는 자료형태 insert method
	 public int insert(Map<String, Object> map) {
		 return this.sqlSessionTemplate.insert("book.insert", map);
	 }
	 
/*상세 DAO메소드 작성 제너릭 선언부에서 적은 제너릭으로 리턴타입 파라미터타입이 정해지는 메소드
public class Student<T>{ 
	static <T> T getOneStudent(T id){
	return id;
	}
}
public static <T[제너릭 타입]>T[리턴타입] getName(T[파라미터 타입){return name;}
*/	 
	 public Map<String, Object> selectDetail(Map<String, Object>map){
		 return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	 }
	 /*
	 sqlSessionTemplate의  selectOne 메소드는 데이터를 한개만 가져올때 사용한다
	 만약 쿼리 결과 행수가 0이면  selectOne메소드는 null을 리턴하고
	 쿼리결과가 여러개면 TooManyResultSException예외를 던진다
	 앞선에 작성한 쿼리의 조건이 PK(무조건 행이 유일함(unique)) 이고 보장하기 때문에
	 결과가 0개 아니면 1개다 그래서 selectOne 메소드를 사용합니다
	 쿼리 실행 리턴값이 Map<String, Object> 타입이다
	 그래서 매퍼XML (book_SQL) 에 resultType과 일치해야 한다 
	 */
	 //수정기능 DAO메소드 작성
	 public int update(Map<String, Object> map) {
		 return this.sqlSessionTemplate.update("book.update", map);
		//첫번째 파라미터는 쿼리 ID, 두번째 파라미터는 쿼리파라미터 
	 }
	 
	 //삭제 기능 DAO메소드 작성
	 public int delete(Map<String, Object> map) {
		 return this.sqlSessionTemplate.delete("book.delete", map);
	 }
	 //목록 DAO메소드 작성
	 public List<Map<String, Object>> selectList(Map<String, Object> map){
		 return this.sqlSessionTemplate.selectList("book.select_list", map);
		 //첫번째 파라미터는 쿼리ID 두번째 ID는 쿼리파라미터
		 //sqlSessionTemplate.selectList는 결과집합목록을 리턴합니다
		 //결과 집합타입인 Map<String, Object> List타입으로 읽는다
		 //List인터페이스를 구현한 클래스로 ArrayList, Vector, LinkedList, Stack
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
