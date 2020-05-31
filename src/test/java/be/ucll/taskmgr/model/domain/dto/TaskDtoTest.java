package be.ucll.taskmgr.model.domain.dto;

import be.ucll.taskmgr.model.domain.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskDtoTest {

    private TaskDto task;

    private UUID uuid = UUID.randomUUID();
    private LocalDateTime date = LocalDateTime.now();


    private void setup(){
        task = new TaskDto();
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

}
