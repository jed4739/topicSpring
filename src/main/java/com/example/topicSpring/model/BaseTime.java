package com.example.topicSpring.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * BaseTime 은 엔티티에 생성날짜를 추가해줍니다.
 * 엔티티 클래스에 상속하면 사용할 수 있습니다.
 * */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTime {

    @CreatedDate
    @Column(nullable = false, name = "createdDate", updatable = false)
    private LocalDateTime createdDate;

//    @LastModifiedDate
//    @Column(name = "modifiedDate", nullable = false)
//    private LocalDateTime modifiedDate;


}
