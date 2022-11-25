package com.example.topicSpring.service;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.domain.Member;
import com.example.topicSpring.error.DataNotFoundException;
import com.example.topicSpring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Board Service class
 * 해당 서비스를 유지할 지, 혹은 member 테이블의 pk의 의존하는 형식으로 할지 정해야함.
 * */
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public Page<Board> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.boardRepository.findAll(pageable);
    }
    public Board getBoard(Long id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if (board.isPresent()) {
            return board.get();
        } else {
            throw new DataNotFoundException("Board not found");
        }
    }
    public void create(String title, String content, Member member) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setAuthor(member);
        this.boardRepository.save(board);
    }
    public void modify(Board board, String title, String content) {
        board.setTitle(title);
        board.setContent(content);
        this.boardRepository.save(board);
    }

    public void delete(Board board) {
        this.boardRepository.delete(board);
    }
}
