package com.example.todo.task.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String content;

    private LocalDateTime createdAt; // 생성일자

    private LocalDateTime time; // 수행일자

    private boolean end;    // 수행여부

    private String message;

    public Task(String content, LocalDateTime time) {
        this.content = content;
        this.time = time;
        this.end = false;
        this.createdAt = LocalDateTime.now();
    }

    public Task() {}

    public void update(String content, LocalDateTime time){
        this.content = content;
        this.time = time;
    }
    public void setter(){

    }
    public void complete() {
        this.end = true;
    }

    public void update_time(LocalDateTime dateTime) {
        this.time = dateTime;
    }

}
