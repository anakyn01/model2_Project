package com.spring.pagenation.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.pagenation.domain.BoardVO;

@Repository //BoardDAO를 상속받는 BoardDAOImple이 생성
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sql;
	private static String namespace="com.spring.pagenation.mappers.board";


	@Override//게시물 목록
	public List<BoardVO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}


	@Override//쓰기
	public void write(BoardVO vo) throws Exception {
		sql.insert(namespace + ".write", vo);		
	}


	@Override//조회
	public BoardVO view(int bno) throws Exception {
		return sql.selectOne(namespace + ".view", bno);
	}


	@Override//게시물 수정
	public void modify(BoardVO vo) throws Exception {
		sql.update(namespace + ".modify", vo);		
	}


	@Override//게시물 삭제 번호만 있으면 삭제할수 있기때문에 매개변수 타입을 정수로 했습니다
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
		
	}


	@Override//게시물 총 갯수
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
	}


	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
    HashMap<String, Integer> data = new HashMap<String, Integer>();
    data.put("displayPost", displayPost);
    data.put("postNum", postNum);	
		return sql.selectList(namespace +".listPage", data);
	}


	@Override //게시물목록 + 페이징 + 검색 매서드의 배개변수로 searchType, keyword를 받을수 있게 해주었고
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)throws Exception {
	
	HashMap<String, Object> data = new HashMap<String, Object>();
	data.put("displayPost", displayPost);
	data.put("postNum", postNum);
	
	data.put("searchType", searchType);//해시맵에도 추가를 하였습니다
	data.put("keyword", keyword);
	
	return sql.selectList(namespace +".listPageSearch", data);
	}


	@Override//게시물 총갯수 + 검색 적용
	public int searchCount(String searchType, String keyword) throws Exception {

		HashMap data = new HashMap();
		
		data.put("searchType", searchType);//해시맵에도 추가를 하였습니다
		data.put("keyword", keyword);
				
		return sql.selectOne(namespace + ".searchCount", data);
	}
	

}
/*
@Resource @Inject @Autowired
세 개의 어노테이션은 컨테이너에 생성된 빈(Bean) 객체를 자동으로 주입받을 수 있도록 해주는 어노테이션입니다. 
Bean 객체를 이용할 때 코드를 아주 간결하게 해주기 때문에 필수로 사용되는 어노테이션입니다. 

@Resource
필드명 또는 생성자 파라미터 변수의 이름과 Bean 객체의 ID를 매핑시켜서 먼저 찾는 방식입니다. 
만약 매핑되는 ID가 없으면 타입을 검색해서 찾아줍니다. 그런데 같은 타입도 없다면 예외를 발생시킵니다. (name="ID")로 ID를 강제 지정할 수도 있습니다.
타입 또는 이름이 항상 맞으면 좋겠지만 오버라이딩을 사용하는 경우 둘 다 달라질 수 있기 때문에 항상 이름을 명시해서 사용해주는 것이 나중에 보기도 좋고 안정적입니다.

@Inject
타입이 같은 Bean을 먼저 찾습니다. 
하지만 같은 타입의 Bean 객체가 여러 개 있다면 다음은 이름으로 찾는데, 그래도 없다면 예외가 발생합니다. 
부모 클래스 타입에다가 여러 자식 클래스의 Bean 객체 중 하나를 오버라이딩 시키는 경우 발생할 수 있는 문제입니다. 
따라서 @Named 어노테이션을 사용해 정확한 Bean ID를 지정해주는 것이 좋습니다

@Autowired
스프링에서 제공해주는 어노테이션입니다. 
스프링 의존적이라 나중에 프레임워크를 바꿀 계획이 있다면 위의 두 어노테이션을 사용하는 것이 좋습니다.
사용법과 동작은 @Inject와 거의 유사합니다. 
특정 Bean 객체를 강제로 지정해주는 어노테이션만 @Qualifier를 사용해주면 됩니다.
*/
