package v2.mvc.spring.service;



import java.util.List;
import java.util.Map;

import v2.mvc.spring.vo.BlogEditRequestVO;
import v2.mvc.spring.vo.BlogListRequestVO;
import v2.mvc.spring.vo.BlogListResponseVO;


public interface BlogService {

	int create(Map<String, Object> map);//insert

	Map<String, Object> read(int blogContSeq);//read

	boolean edit(BlogEditRequestVO blogEditRequestVO);

	boolean delete(int blogContSeq);

	List<BlogListResponseVO> list(BlogListRequestVO blogListRequestVO);
	
}
