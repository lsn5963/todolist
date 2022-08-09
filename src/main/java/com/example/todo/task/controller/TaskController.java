package com.example.todo.task.controller;

import com.example.todo.task.dtos.*;
import com.example.todo.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public TaskResponse createNewTask(@RequestBody TaskCreate taskCreate) {
        return taskService.createNewTask(taskCreate);
    }

    @PatchMapping("")
    public TaskResponse updateTask(@RequestBody TaskUpdate taskUpdate){
        return taskService.update(taskUpdate);
    }

    @PatchMapping("/check")
    public TaskResponse finish(@RequestBody TaskEnd taskEnd){
        return taskService.taskEnd(taskEnd);
    }

    @DeleteMapping("")
    public TaskDeleteResponse delete(@RequestBody TaskDelete taskDelete){
        return taskService.deleteTask(taskDelete);
    }

}
