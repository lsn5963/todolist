package com.example.todo.task.dtos;

import com.example.todo.task.entity.Task;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskResponse {

    private final Long taskId;

    private final String content;

    private final LocalDateTime createdAt;

    private final LocalDateTime time;

    private final boolean end;


    public TaskResponse(Task task) {
        this.taskId = task.getTaskId();
        this.content = task.getContent();
        this.createdAt = task.getCreatedAt();
        this.time = task.getTime();
        this.end = task.isEnd();
    }
}
