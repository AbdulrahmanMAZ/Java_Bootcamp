package com.abdulrahman.assignment13.controller;

import com.abdulrahman.assignment13.module.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v3")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/task")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/task")
    public String addTask(@RequestBody Task task) {
        task.setStatus("not done");
       tasks.add(task);
        return "Added Successfully";
    }
    @PutMapping("/task/{item}")
    public String UpdateTask(@PathVariable int item,@RequestBody Task task) {
        tasks.set(item,task);
        return "Updated Successfully";
    }
    @DeleteMapping("/task/{item}")
    public String DeleteTask(@PathVariable int item) {
        tasks.remove(item);
        return "Deleted Successfully";
    }
    @PutMapping("/task/status/{item}")
    public String ChangeStatus(@PathVariable int item) {
        if (tasks.get(item).getStatus().equals("not done")){
        tasks.get(item).setStatus("Done");}
        else {
            tasks.get(item).setStatus("not done");
        }

        return "Task is done Successfully";
    }
    @GetMapping("/task/{title}")
    public ArrayList<Task> getTasks(@PathVariable String title) {
        ArrayList<Task> matchTasks = new ArrayList<>();
        for (Task t:tasks) {

            if (t.getTitle().equals(title)){
                matchTasks.add(t);
            }        }
        return matchTasks;
    }

}
