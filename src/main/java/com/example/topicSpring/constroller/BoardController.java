package com.example.topicSpring.constroller;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/board/list")
    public String home(Model model) {
        List<Board> boardList = this.boardService.getList();
        model.addAttribute("boardList", boardList);
        return "board_list";
    }
    /*
    * 해당 URL 은 Board 테이블의 pk를 쿼리로 나타냄
    * */
    @GetMapping("/board/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board_detail";
    }
    @GetMapping("/")
    public String root() {
        return "redirect:/board/list";
    }
}
