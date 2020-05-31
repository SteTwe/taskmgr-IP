package be.ucll.taskmgr.model.domain.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SubtaskDtoTest {

    private SubtaskDto subtask;

    private void setup(){
        subtask = new SubtaskDto();
    }

    @Test
    public void idTest(){
        setup();

        subtask.setId(2);
        assertEquals(2, subtask.getId());
    }

    @Test
    public void titleTest(){
        setup();

        subtask.setTitle("Title");
        assertEquals("Title", subtask.getTitle());
    }

    @Test
    public void descriptionTest(){
        setup();

        subtask.setDescription("description");
        assertEquals("description", subtask.getDescription());
    }

}
