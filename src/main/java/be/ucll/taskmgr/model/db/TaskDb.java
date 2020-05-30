package be.ucll.taskmgr.model.db;

import be.ucll.taskmgr.model.domain.entity.Subtask;
import be.ucll.taskmgr.model.domain.entity.Task;

import java.util.List;
import java.util.UUID;

@Deprecated
public interface TaskDb {

    void addTask(Task task);

    Task getTask(UUID uuid);

    List<Task> getAllTasks();

    void editTask(Task task);

    void addSubTask(UUID uuid, Subtask subtask);
}
