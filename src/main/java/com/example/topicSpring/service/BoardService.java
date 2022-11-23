package com.example.topicSpring.service;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.error.DataNotFoundException;
import com.example.topicSpring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Board Service class
 * 해당 서비스를 유지할 지, 혹은 member 테이블의 pk의 의존하는 형식으로 할지 정해야함.
 * */
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public List<Board> getList() {
        return this.boardRepository.findAll();
    }
    public Board getBoard(Long id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if (board.isPresent()) {
            return board.get();
        } else {
            throw new DataNotFoundException("Board not found");
        }
    }
    public void create(String title, String content) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        this.boardRepository.save(board);
    }
}
