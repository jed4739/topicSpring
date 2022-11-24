package com.example.topicSpring.constroller;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.domain.dto.BoardForm;
import com.example.topicSpring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @RequestMapping("/list")
    public String home(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Board> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging);
        return "board_list";
    }
    /*
    * 해당 URL 은 Board 테이블의 pk를 쿼리로 나타냄
    * */
    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board_detail";
    }
    @GetMapping("/create")
    public String boardCreate(BoardForm boardForm) {
        return "board_form";
    }
    /*
    * RequestParam 으로 템플릿에서 바로 값 전달 -> DTO를 통해서 값을 전달
    * BindingResult 로 Error 처리
    * 비지니스 로직은 Service 에서 처리
    * */
    @PostMapping("/create")
    public String boardCreate(@Valid @ModelAttribute("boardForm") BoardForm boardForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board_form";
        }
        this.boardService.create(boardForm.getTitle(), boardForm.getContent());
        return "redirect:/board/list";
    }
}
