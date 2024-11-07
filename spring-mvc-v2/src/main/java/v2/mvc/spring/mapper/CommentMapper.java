package v2.mvc.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import v2.mvc.spring.vo.CommentInsertVO;

@Mapper
public interface CommentMapper {
	int insert(CommentInsertVO commentInsertVO);
}
