package be.ucll.taskmgr.service;

import be.ucll.taskmgr.model.db.TaskDb;
import be.ucll.taskmgr.model.db.TaskDbInMemory;
import be.ucll.taskmgr.model.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskDb taskDb;

    public TaskService(){
        this.taskDb = new TaskDbInMemory();
    }

    public List<Task> getAllTasks(){
        return taskDb.getAllTasks();
    }

}
