package be.ucll.taskmgr.service;

import be.ucll.taskmgr.model.db.TaskDb;
import be.ucll.taskmgr.model.db.TaskDbInMemory;
import be.ucll.taskmgr.model.domain.Subtask;
import be.ucll.taskmgr.model.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private TaskDb taskDb;

    public TaskService(){
        this.taskDb = new TaskDbInMemory();
    }

    public List<Task> getAllTasks(){
        return taskDb.getAllTasks();
    }

    public Task getTask(UUID uuid){
        return taskDb.getTask(uuid);
    }

    public void addTask(Task task){
        taskDb.addTask(task);
    }

    public void editTask(Task task){
        taskDb.editTask(task);
    }

    public void addSubtask(UUID uuid, Subtask subtask){
        taskDb.addSubTask(uuid, subtask);
    }

}
