package be.ucll.taskmgr.model.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Entity
public class Task {

    private UUID uuid;

    private String title;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    public Task() {
        setRandomUuid();
    }

    public Task(String title, LocalDateTime dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        setRandomUuid();
    }

    public Task(String title, String description, LocalDateTime dueDate){
        setTitle(title);
        setDueDate(dueDate);
        setDescription(description);
        setRandomUuid();
    }

    public Task(String title, String description, LocalDateTime dueDate, UUID uuid){
        setTitle(title);
        setDueDate(dueDate);
        setDescription(description);
        setUuid(uuid);
    }


    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) throw new IllegalArgumentException("Description cannot be empty");
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private void setRandomUuid(){
        this.uuid = UUID.randomUUID();
    }

    public void setDueDate(LocalDateTime dueDate) {
        if (dueDate == null) throw new IllegalArgumentException("Due date cannot be null.");
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        this.title = title;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDateString() {
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' HH:mm");
        return dTF.format(dueDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
