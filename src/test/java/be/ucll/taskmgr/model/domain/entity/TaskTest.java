package be.ucll.taskmgr.model.domain.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskTest {

    private Task task;
    private UUID uuid = UUID.randomUUID();
    private LocalDateTime date = LocalDateTime.now();

    private void setup(){
        task = new Task();
    }


    @Test
    public void idTest(){
        setup();

        task.setUuid(uuid);
        assertEquals(uuid, task.getUuid());
    }

    @Test
    public void titleTest(){
        setup();

        task.setTitle("Title");
        assertEquals("Title", task.getTitle());
    }

    @Test
    public void descriptionTest(){
        setup();

        task.setDescription("description");
        assertEquals("description", task.getDescription());
    }

    @Test
    public void subtaskTest(){
        task = new Task("Title", "Description", date, uuid);

        assertNotNull(task);
        assertEquals("Title", task.getTitle());
        assertEquals("Description", task.getDescription());
        assertEquals(date, task.getDueDate());
        assertEquals(uuid, task.getUuid());
    }



}