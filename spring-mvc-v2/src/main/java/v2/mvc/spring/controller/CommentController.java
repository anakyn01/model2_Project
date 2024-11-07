package v2.mvc.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import v2.mvc.spring.service.CommentService;
import v2.mvc.spring.vo.CommentAddRequestVO;
import v2.mvc.spring.vo.CommentResponseVO;
 
@Controller
@RequestMapping("/comment")
public class CommentController {
 
    @Autowired
    private CommentService commentService;
 
    @PostMapping("/add")
    @ResponseBody
    public CommentResponseVO add(CommentAddRequestVO commentAddRequestVO) {
        return this.commentService.add(commentAddRequestVO);
    }
}
