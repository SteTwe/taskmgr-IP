package be.ucll.taskmgr.model.db;

import be.ucll.taskmgr.model.domain.Task;

import javax.security.auth.Subject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TaskDb {

    void addTask(Task task);

    Task getTask(UUID id);

    List<Task> getAllTasks();

    void editTask(Task task);

    //TODO change String --> Subtask
    void addSubTask(UUID id, String subtask);
}
