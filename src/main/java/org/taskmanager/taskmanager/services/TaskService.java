package org.taskmanager.taskmanager.services;


import org.springframework.stereotype.Repository;
import org.taskmanager.taskmanager.entities.TaskEntities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public class TaskService {

    private ArrayList<TaskEntities> task;
    private int taskid;

    TaskService(){
        this.task=new ArrayList<>();
        this.taskid=1;
    }

    public TaskEntities addTask(String title,String description,String deadline){
        TaskEntities tentity=new TaskEntities();
        tentity.setId(taskid);
        tentity.setTitle(title);
        tentity.setDescription(description);
        tentity.setDeadline(new Date(deadline));
        tentity.setCompleted(false);
        task.add(tentity);
        taskid++;
        return tentity;
    }

    public ArrayList<TaskEntities> getTasks(){
        return task;
    }

    public TaskEntities getTaskById(int id ){
        Optional<TaskEntities> taskEntity = task.stream()
                .filter(t -> t.getId() == id) // ✅ Filter tasks by ID
                .findFirst();                 // ✅ Get the first match

        return taskEntity.orElse(null);


    }
}
