package com.Test.springconmongo.controller;


//Imports
import com.Test.springconmongo.model.Task;
import com.Test.springconmongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

}
