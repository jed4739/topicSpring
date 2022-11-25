package com.example.topicSpring;

import com.example.topicSpring.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TopicSpringApplicationTests {
    @Autowired
    private BoardService boardService;

    /**
     * Board Data Test
     * Paging check, title or content check
     * */
    @Test
    void testJPA() {
        for (int i = 1; i < 200; i++) {
            String a = String.format("테스트 제목 입니다. : [%03d]", i);
            String b = "테스트용 내용입니다.";
            this.boardService.create(a,b,null);
        }
    }

}
