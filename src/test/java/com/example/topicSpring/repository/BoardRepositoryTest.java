package com.example.topicSpring.repository;

import com.example.topicSpring.model.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BordRepository bordRepository;

    /*
    * data size test
    *
    * */
    @Test
    public void DataSizeTest() {
        List<Board> DataAll = this.bordRepository.findAll();
        Assertions.assertEquals(2, DataAll.size());

        Board B = DataAll.get(0);
        Assertions.assertEquals("질문!", B.getTitle());
    }

    /** board data insert test */
    @Test
    public void JpaTest() {
        Board board1 = new Board();
        board1.setTitle("질문!");
        board1.setContent("질문 어떻게 함");
        this.bordRepository.save(board1);

        Board board2 = new Board();
        board2.setTitle("질문2!");
        board2.setContent("사실 그런거 없음");
        this.bordRepository.save(board2);
    }

}
