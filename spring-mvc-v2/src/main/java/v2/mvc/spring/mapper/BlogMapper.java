package v2.mvc.spring.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import v2.mvc.spring.vo.BlogListRequestVO;
import v2.mvc.spring.vo.BlogListResponseVO;


@Mapper
public interface BlogMapper {
	
	int delete(int blgContSeq);
	List<BlogListResponseVO> selectList(BlogListRequestVO blogListRequestVO);
	
}