package com.example.todo.task.service;

import com.example.todo.task.dtos.*;
import com.example.todo.task.entity.Task;
import com.example.todo.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse createNewTask(TaskCreate taskCreate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(taskCreate.getTime(), formatter);

        String content = taskCreate.getContent();
        Task task = new Task(content, dateTime);
        taskRepository.save(task);

        return new TaskResponse(task);
    }

    public TaskResponse update(TaskUpdate taskUpdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(taskUpdate.getTime(), formatter);

        Long id = taskUpdate.getTaskId();
        String content = taskUpdate.getContent();
        Task task = taskRepository.findById(id).get();
        task.update(content, dateTime); //??????
        taskRepository.save(task);

        return new TaskResponse(task);
    }

    public TaskResponse taskEnd(TaskEnd taskEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(taskEnd.getTime(), formatter);

        Long id = taskEnd.getTaskId();

        Task task = taskRepository.findById(id).get();
        task.update_time(dateTime);
        task.complete();

        return new TaskResponse(task);
    }

    public TaskDeleteResponse deleteTask(TaskDelete taskDelete) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(taskDelete.getTime(), formatter);

        Long id = taskDelete.getTaskId();

        Task task = taskRepository.findById(id).get();

        taskRepository.delete(task);

        return new TaskDeleteResponse(task, "지워짐");
    }
//    public TaskResponse updateTask(TaskUpdate taskUpdate) {
//        Task task = taskRepository.findById(가져오려는 Task의 Id);
//        task.update(taskUpdate);
//        taskRepository.save(task);
//        return new TaskResponse(task);
//    }
}
