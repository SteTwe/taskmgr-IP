package be.ucll.taskmgr.model.db;

import be.ucll.taskmgr.model.domain.entity.Subtask;
import be.ucll.taskmgr.model.domain.entity.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Deprecated
public class TaskDbInMemory implements TaskDb{

    private List<Task> tasks;

    public TaskDbInMemory(){
        this.tasks = new ArrayList<>();
        tasks.add(new Task("Kakken", "Ge moet gaan kakken", LocalDateTime.now()));
        tasks.add(new Task("Pissen", "Ge moet gaan pissen", LocalDateTime.now()));
        tasks.add(new Task("Eten", "Ge moet gaan eten", LocalDateTime.now()));
        tasks.add(new Task("Drinken", "Ge moet gaan drinken", LocalDateTime.now()));
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Task getTask(UUID uuid) {
        for (Task task: tasks){
            if (task.getUuid().equals(uuid)){
                Task res = new Task();
                res.setTitle(task.getTitle());
                res.setDueDate(task.getDueDate());
                res.setDescription(task.getDescription());
                res.setUuid(task.getUuid());
                return res;
            }
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void editTask(Task task) {
        for (Task old: tasks){
            if (old.getUuid().equals(task.getUuid())){
                old.setTitle(task.getTitle());
                old.setDescription(task.getDescription());
                old.setDueDate(task.getDueDate());
            }
        }
    }

    @Override
    public void addSubTask(UUID uuid, Subtask subtask) {
        for (Task task : tasks){
            if (task.getUuid().equals(uuid)){
                task.addSubtask(subtask);
            }
        }
    }
}
