package com.example.topicSpring.constroller;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.domain.dto.CommentForm;
import com.example.topicSpring.service.BoardService;
import com.example.topicSpring.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final BoardService boardService;
    private final CommentService commentService;

    /*
    * BoardService 에서 id 를 검사후 없을 시 404 오류 호출
    * 템플릿에서 작성한 내용을 가져오기위해 @RequestParam 을 사용
    * - name 의 이름이 content 라서 해당 메소드에서도 일치시켜줘야 함. -> DTO 형식 으로 전환
    * */
    @PostMapping("/create/{id}")
    public String createComment(Model model, @PathVariable("id") Long id,
                                @Valid CommentForm commentForm, BindingResult bindingResult) {
        Board board = this.boardService.getBoard(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("board", board);
            return "board_detail";
        }
        this.commentService.create(board, commentForm.getContent());
        return String.format("redirect:/board/detail/%s", id);
    }
}
