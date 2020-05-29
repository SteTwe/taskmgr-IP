package be.ucll.taskmgr.controller;


import be.ucll.taskmgr.model.domain.Task;
import be.ucll.taskmgr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", service.getAllTasks());
        return "taskOverview";
    }

    @GetMapping("/{id}")
    public String getTaskDetail(@PathVariable("id") String id, Model model){
        // When parameter "id" is not a valid UUID, catch Exception + set task as null.
        // taskDetail-page deals with null-exception and shows "Task not found"
        try{
            Task task = service.getTask(UUID.fromString(id));
            model.addAttribute("task", task);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            model.addAttribute("task", null);
        }
        return "taskDetail";
    }




}
