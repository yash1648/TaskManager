package org.taskmanager.taskmanager.services;


import org.springframework.stereotype.Repository;
import org.taskmanager.taskmanager.entities.TaskEntities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public class TaskService {

    private ArrayList<TaskEntities> task;
    private int taskid;
    private final SimpleDateFormat simpledate;
    TaskService(){
        this.task=new ArrayList<>();
        this.taskid=1;
        this.simpledate=new SimpleDateFormat("yyyy-MM-dd");
    }

    public TaskEntities addTask(String title,String description,String deadline) throws ParseException {
        TaskEntities tentity=new TaskEntities();
        tentity.setId(taskid);
        tentity.setTitle(title);
        tentity.setDescription(description);
        tentity.setDeadline(simpledate.parse(deadline));
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
                .filter(t -> t.getId() == id)
                .findFirst();

        return taskEntity.orElse(null);


    }

    public TaskEntities updateTask(int id,String description,String deadline,Boolean completed)throws ParseException{
        TaskEntities task=getTaskById(id);
        if(task==null) {
return null;
        }
            if(description!=null ){
            task.setDescription(description);}
            if (deadline!=null){
            task.setDeadline(simpledate.parse(deadline));}
            if(completed != null){
            task.setCompleted(completed);}
            return task;





    }


}
