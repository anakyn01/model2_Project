package v2.mvc.spring.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import v2.mvc.spring.mapper.CommentMapper;
import v2.mvc.spring.service.CommentService;
import v2.mvc.spring.vo.CommentAddRequestVO;
import v2.mvc.spring.vo.CommentInsertVO;
import v2.mvc.spring.vo.CommentResponseVO;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentMapper commentMapper;
 
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
    
    @Override
    public CommentResponseVO add(CommentAddRequestVO commentAddRequestVO){
        ModelMapper modelMapper = new ModelMapper();
        CommentInsertVO commentInsertVO = modelMapper.map(commentAddRequestVO, CommentInsertVO.class);
     
        if (commentInsertVO.getTmpPw() != null) {
            String sha256hex = DigestUtils.sha256Hex(commentInsertVO.getTmpPw());
            commentInsertVO.setTmpPw(sha256hex);
        }
     
        int affectRowCount = this.commentMapper.insert(commentInsertVO);
     
        if (affectRowCount == 0) {
            return null;
        }
     
        ModelMapper modelMapperInsertToResponse = new ModelMapper();
        CommentResponseVO commentResponseVO = modelMapperInsertToResponse.map(commentInsertVO, CommentResponseVO.class);
     
        return commentResponseVO;
    }
}
