package be.ucll.taskmgr.service;

import be.ucll.taskmgr.model.domain.dto.TaskDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceImpTest {

    @Autowired
    private TaskServiceImp service;

    private LocalDateTime date = LocalDateTime.now();

    @BeforeEach
    private void setup() {
        TaskDto dto = new TaskDto();
        dto.setTitle("title");
        dto.setDescription("description");
        dto.setDueDate(date);
        dto.setSubtasks(new ArrayList<>());
        service.addTask(dto);
    }

    @AfterEach
    private void cleanup() {
        service.deleteTasks();
    }

    @Test
    public void getAllTasks() {
        List<TaskDto> tasks = service.getAllTasks();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());

        TaskDto dto = tasks.get(0);
        assertNotNull(dto);
        assertEquals("title", dto.getTitle());
        assertEquals("description", dto.getDescription());
    }
    

}
