package v2.mvc.spring.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import v2.mvc.spring.vo.BlogEditRequestVO;


/*
DAO 클래스는 Data Access Object의 약자로, 이름처럼 "데이터에 접근하는 객체" 입니다. 
매퍼 XML에 작성한 쿼리를 실행시키기 위해 작성하므로 매퍼 XML과 한 쌍입니다.
*/
@Repository
public class BlogDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//insert메소드 작성 글쓰기가 성공하면 순번이 매겨지며 생성되고 그렇지 않으면 실패
	public int insert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("TB_BLG_CONT.insert", map);
		if(result > 0 && map.containsKey("seq_blg_cont")) {
			return (int) map.get("seq_blg_cont");
		}
		return -1;
	}

	public Map<String, Object> selectOne(int blogContSeq) {
		return this.sqlSessionTemplate.selectOne("TB_BLG_CONT.selectOne",blogContSeq);
	}
	

	public int update(BlogEditRequestVO blogEditRequestVO) {
	    return this.sqlSessionTemplate.update("TB_BLG_CONT.update", blogEditRequestVO);
	}

		
}
