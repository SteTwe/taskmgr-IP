package be.ucll.taskmgr.model.db;

import be.ucll.taskmgr.model.domain.Task;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class TaskDbInMemory implements TaskDb{

    private List<Task> tasks;

    public TaskDbInMemory(){
        this.tasks = new ArrayList<>();
        //tasks.add(new Task("Task 1", LocalDateTime.now()));
    }

    @Override
    public void addTask(Task task) {
        throw new NotImplementedException();
    }

    @Override
    public Task getTask(UUID id) {
        throw new NotImplementedException();
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void editTask(UUID id, String title, String description, LocalDateTime date) {
        throw new NotImplementedException();
    }

    @Override
    public void addSubTask(UUID id, String subtask) {
        throw new NotImplementedException();
    }
}
