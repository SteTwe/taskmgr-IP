package be.ucll.taskmgr.model.domain.dto;

import be.ucll.taskmgr.model.domain.entity.Subtask;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SubtaskDto {

    private int id;

    @NotEmpty
    private String title;

    @NotEmpty @Size(min=4, max = 50)
    private String description;

    public SubtaskDto() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) throw new IllegalArgumentException("Description cannot be empty");
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Subtask createSubtask(){
        return new Subtask(title, description, id);
    }

}
