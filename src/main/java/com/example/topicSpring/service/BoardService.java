package com.example.topicSpring.service;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.error.DataNotFoundException;
import com.example.topicSpring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Board 의 서브스 클래스
 * 해당 서비스를 유지할 지, 혹은 member 테이블의 pk의 의존하는 형식으로 할지 정해야함.
 * */

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    /*
    * board Repository 를 통해 모두 조회하여 List 형식으로 return 한다.
    * 해당 메소드는 BoardController 의 home 메소드에서 사용 중.
    * */
    public List<Board> getList() {
        return this.boardRepository.findAll();
    }
    /*
    * board 의 pk인 id를 Optional 형태의 board 라는 인스턴스로 저장.
    * board 가 값이 있는 지 체크 후, 값이 없을 시 DataNotFoundException 로 전송
    * */
    public Board getBoard(Long id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if (board.isPresent()) {
            return board.get();
        } else {
            throw new DataNotFoundException("board not found");
        }
    }

    public void create(String title, String content) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        this.boardRepository.save(board);
    }
}
