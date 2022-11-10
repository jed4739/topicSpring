package com.example.topicSpring.constroller;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/board/list")
    public String list(Model model) {
        List<Board> boardList = this.boardRepository.findAll();
        model.addAttribute("boardList",boardList);
        return "board_list";
    }
}
