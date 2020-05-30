package be.ucll.taskmgr.model.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Subtask {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String title;

    @NotEmpty @Size(min=4, max = 50)
    private String description;

    public Subtask() {

    }

    public Subtask(String title, String description){
        setTitle(title);
        setDescription(description);
    }

    public Subtask(String title, String description, int id){
        setTitle(title);
        setDescription(description);
        setId(id);
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

    @Override
    public String toString() {
        return title +": " + description;
    }
}
