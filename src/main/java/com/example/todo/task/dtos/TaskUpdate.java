package com.example.todo.task.dtos;

import lombok.Getter;

@Getter
public class TaskUpdate {
    private String content;
    private String time;
    private Long taskId;
}
