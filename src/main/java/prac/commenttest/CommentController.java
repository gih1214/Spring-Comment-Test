package prac.commenttest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import prac.commenttest.domain.Comment;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/")
    public String index(Model model) {
        List<Comment> commentEntity = commentService.댓글보기();
        model.addAttribute("comments", commentEntity);
        return "/commentTest";
    }

    @PostMapping("/comment")
    public String write(Comment comment) { // x-www-form~~

        commentService.댓글쓰기(comment);
        return "redirect:/";
    }

    // data를 리턴하면 CommentApiController를 원래 만들어야 한다.
    @DeleteMapping("/api/comment/{id}")
    public @ResponseBody ResponseEntity<?> deleteById(@PathVariable Integer id) {

        commentService.댓글삭제(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/comment/{id}")
    public @ResponseBody ResponseEntity<?> updateById(@PathVariable Integer id, Comment comment) {

        commentService.댓글수정(id, comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
