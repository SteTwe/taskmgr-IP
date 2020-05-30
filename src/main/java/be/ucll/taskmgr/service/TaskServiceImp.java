package be.ucll.taskmgr.service;

import be.ucll.taskmgr.model.db.SubtaskRepository;
import be.ucll.taskmgr.model.db.TaskDb;
import be.ucll.taskmgr.model.db.TaskRepository;
import be.ucll.taskmgr.model.domain.dto.SubtaskDto;
import be.ucll.taskmgr.model.domain.dto.TaskDto;
import be.ucll.taskmgr.model.domain.entity.Subtask;
import be.ucll.taskmgr.model.domain.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;
    private final SubtaskRepository subtaskRepository;

    private TaskDb taskDb;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository, SubtaskRepository subtaskRepository){
        this.taskRepository = taskRepository;
        this.subtaskRepository = subtaskRepository;
        //enable if you want to preload tasks
        init();
    }

    /**
     * Pre loading some tasks
     */
    private void init(){
        addTask(new Task("Task 1", "Default task 1", LocalDateTime.now()).createDto());
        addTask(new Task("Task 2", "Default task 2", LocalDateTime.now()).createDto());
        addTask(new Task("Task 3", "Default task 3", LocalDateTime.now()).createDto());
    }


    @Override
    public List<TaskDto> getAllTasks(){
        return taskRepository.findAll().stream().map(Task::createDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskDto(UUID uuid){
        if(taskRepository.findById(uuid).isPresent()) {
            Task old = taskRepository.findById(uuid).get();
            return old.createDto();
        }
        else return null;
    }

    @Override
    public void addTask(TaskDto dto){
        taskRepository.save(dto.createTask());
    }

    @Override
    public void editTask(TaskDto dto){
        if (taskRepository.findById(dto.getUuid()).isPresent()){
            Task updated = taskRepository.findById(dto.getUuid()).get();
            updated.setTitle(dto.getTitle());
            updated.setDueDate(dto.getDueDate());
            updated.setDescription(dto.getDescription());
            taskRepository.save(updated);
        }
    }

    @Override
    public void addSubtask(UUID uuid, SubtaskDto dto){
        Subtask subtask = dto.createSubtask();
        Task task = getTask(uuid);
        task.addSubtask(subtask);
        subtaskRepository.save(subtask);
        taskRepository.save(task);
    }

    private Task getTask(UUID uuid){
        if(taskRepository.findById(uuid).isPresent()){
            return taskRepository.findById(uuid).get();
        } else throw new IllegalArgumentException("UUID not found");
    }

}
