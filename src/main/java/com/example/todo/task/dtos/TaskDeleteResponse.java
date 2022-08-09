package com.example.todo.task.dtos;

import com.example.todo.task.entity.Task;
import lombok.Getter;

@Getter
public class TaskDeleteResponse {
    private Long taskId;
    private String message;

    public TaskDeleteResponse(Task task, String message) {
        this.taskId = task.getTaskId();
        this.message = message;
    }
}
