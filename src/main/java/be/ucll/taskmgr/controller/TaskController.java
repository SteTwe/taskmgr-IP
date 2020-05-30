package be.ucll.taskmgr.controller;


import be.ucll.taskmgr.model.domain.dto.SubtaskDto;
import be.ucll.taskmgr.model.domain.dto.TaskDto;
import be.ucll.taskmgr.model.domain.entity.Subtask;
import be.ucll.taskmgr.model.domain.entity.Task;
import be.ucll.taskmgr.service.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImp service;

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", service.getAllTasks());
        return "taskOverview";
    }

    @GetMapping("/{id}")
    public String getTaskDetail(@PathVariable("id") String id, Model model){
        // When parameter "id" is not a valid UUID, catch Exception + set task as null.
        // taskDetail-page will deal with null-exception
        try{
            TaskDto taskDto = service.getTaskDto(UUID.fromString(id));
            model.addAttribute("task", taskDto);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            model.addAttribute("task", null);
        }
        return "taskDetail";
    }

    @GetMapping("/new")
    public String addTaskPage(Model model){
        model.addAttribute("task", new TaskDto());
        return "addTask";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute @Valid TaskDto dto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "addTask";
        }
        service.addTask(dto);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskPage(@PathVariable("id") String id, Model model){
        // When parameter "id" is not a valid UUID, catch Exception + set task as null.
        // editTask-page will deal with null-exception
        try {
            TaskDto task = service.getTaskDto(UUID.fromString(id));
            model.addAttribute("task", task);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            model.addAttribute("task", null);
        }
        return "editTask";
    }

    @PostMapping("/edit")
    public String editTask(@ModelAttribute @Valid TaskDto dto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) return "editTask";
        service.editTask(dto);
        return "redirect:/tasks/"+ dto.getUuid();
    }


    @GetMapping("/{id}/sub/create")
    public String addSubtaskPage(@PathVariable("id") String id, Model model){
        // When parameter "id" is not a valid UUID, catch Exception + set task as null.
        // addSubtask-page will deal with null-exception
        try {
            SubtaskDto subtask = new SubtaskDto();
            model.addAttribute("subtask", subtask);
            TaskDto task = service.getTaskDto(UUID.fromString(id));
            model.addAttribute("task", task);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            model.addAttribute("task", null);
        }
        return "addSubtask";
    }

    @PostMapping("/addSubtask")
    public String addSubtask(@ModelAttribute @Valid SubtaskDto dto, BindingResult bindingResult, @RequestParam(value = "taskID") String id){
        if (bindingResult.hasErrors()) return "addSubtask";
        // Highly unlikely that the id-string isn't valid.
        // However, if the string is invalid user will be sent to task overview page.
        try {
            service.addSubtask(UUID.fromString(id), dto);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return "taskOverview";
        }
        return "redirect:/tasks/" + id;
    }
}
