package org.taskmanager.taskmanager.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.taskmanager.taskmanager.dto.CreateTaskDTO;
import org.taskmanager.taskmanager.entities.TaskEntities;
import org.taskmanager.taskmanager.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskservice;

    public TaskController(TaskService taskservice){
        this.taskservice=taskservice;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntities>> getTasks(){
        return ResponseEntity.ok(taskservice.getTasks());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskEntities> getTaskById(@PathVariable int id){

       var task=taskservice.getTaskById(id);
       return (task==null)?ResponseEntity.notFound().build(): ResponseEntity.ok(task);
    }

    @PostMapping("/addtask")
    public ResponseEntity<TaskEntities> addTask(@RequestBody CreateTaskDTO body){
       return ResponseEntity.ok( taskservice.addTask(body.getTitle(),body.getDescription(),body.getDeadline()));
    }


}
