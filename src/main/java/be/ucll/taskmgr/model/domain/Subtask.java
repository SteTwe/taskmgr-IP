package be.ucll.taskmgr.model.domain;

import javax.persistence.Entity;


@Entity
public class Subtask {

    private int id;

    private String title;

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
        return id + ". " + title +": " + description;
    }
}
