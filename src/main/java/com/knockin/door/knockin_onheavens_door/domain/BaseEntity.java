package com.knockin.door.knockin_onheavens_door.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP NOT NULL COMMENT '생성일자'")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '수정일자'")
    private Timestamp updatedAt;

    @Column(columnDefinition = "bit default false NOT NULL COMMENT '이용가능여부'")
    protected boolean isDeleted;
}
