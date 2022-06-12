package prac.commenttest;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import prac.commenttest.domain.Comment;
import prac.commenttest.domain.CommentRepository;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void 댓글쓰기(Comment comment) {

        commentRepository.save(comment);
    }

    @Transactional
    public List<Comment> 댓글보기() {

        List<Comment> commentEntity = commentRepository.findAll();
        return commentEntity;
    }

    @Transactional
    public void 댓글삭제(Integer id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    public void 댓글수정(Integer id, Comment comment) {

        Optional<Comment> commentOp = commentRepository.findById(id);

        Comment commentEntity = commentOp.get();
        commentEntity.setContent(comment.getContent());
    }

}
