package be.ucll.taskmgr.model.domain.dto;

import be.ucll.taskmgr.model.domain.entity.Task;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDto {

    private UUID uuid;

    @NotEmpty
    @Size(min=4, max = 50)
    private String description;

    @NotEmpty
    private String title;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private LocalDateTime dueDate;
    private List<SubtaskDto> subtasks;

    public TaskDto(){
        this.subtasks=new ArrayList<>();
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) throw new IllegalArgumentException("Description cannot be empty");
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        if (dueDate == null) throw new IllegalArgumentException("Due date cannot be null.");
        this.dueDate = dueDate;
    }

    public List<SubtaskDto> getSubtasks() {
        return new ArrayList<>(subtasks);
    }

    public void setSubtasks(List<SubtaskDto> subtasks) {
        this.subtasks = subtasks;
    }
    
    public String getDateString() {
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' HH:mm");
        return dTF.format(dueDate);
    }


    public Task createTask(){
        return new Task(title, description, dueDate, UUID.randomUUID());
    }
}
