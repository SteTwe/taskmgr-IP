package be.ucll.taskmgr.model.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Task {

    private String title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    public Task() {

    }

    public Task(String title, LocalDateTime dueDate) {
        setTitle(title);
        setDueDate(dueDate);
    }

    private void setDueDate(LocalDateTime dueDate) {
        if (dueDate == null) throw new IllegalArgumentException("Due date cannot be null.");
        this.dueDate = dueDate;
    }

    private void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        this.title = title;
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
