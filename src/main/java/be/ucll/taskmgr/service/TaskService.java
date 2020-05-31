package be.ucll.taskmgr.service;

import be.ucll.taskmgr.model.domain.dto.SubtaskDto;
import be.ucll.taskmgr.model.domain.dto.TaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<TaskDto> getAllTasks();
    void addTask(TaskDto dto);
    TaskDto getTaskDto(UUID uuid);
    void editTask(TaskDto dto);
    void addSubtask(UUID uuid, SubtaskDto dto);



}
