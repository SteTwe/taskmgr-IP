package be.ucll.taskmgr.controller;


import be.ucll.taskmgr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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




}
