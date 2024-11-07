package com.hbk.bbs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;//bean
import org.springframework.stereotype.Service;

/*서비스 클래스는 비즈니스 클래스가 위치하는 곳이다
스프링 MVC구조에서 서비스클래스는 컨트롤러와 DAO를 연결하는 역활을 한다
@Service 주석 설정
*/

@Service //controller,service,repository 컴포넌트 스캔이 가능하도록 만드는 수단
//비즈니스 로직에 대한 정보를 담고있다
public class BookServiceImpl implements BookService{
	@Autowired
	BookDao bookDao;
	
	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.bookDao.insert(map);
		if (affectRowCount == 1) {
			return map.get("book_id").toString();
		}
		return null;
	}
	
	//서비스는 DAO를 호출한 결과를 바로 리턴한다
	@Override
	public Map<String, Object> detail(Map<String, Object> map){
		return this.bookDao.selectDetail(map);
	}
	//수정 서비스 클래스 메소드 : 1개의 행이 제대영향을 받았는지 검사하는 역활
	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.bookDao.update(map);
		return affectRowCount == 1;
	}
	//삭제 기능 서비스 클래스 메소드 생성 : 1개의 행이 제대영향을 받았는지 검사
	@Override
	public boolean remove(Map<String, Object> map) {
		int affectRowCount = this.bookDao.delete(map);
		return affectRowCount == 1;
	}
	
	//목록 서비스 클래스 메소드
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map){
		return this.bookDao.selectList(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
