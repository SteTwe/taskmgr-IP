package be.ucll.taskmgr.model.domain.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateUserDtoTest {

    private CreateUserDto createUserDto;


    private void setup(){
        createUserDto = new CreateUserDto();
    }

    @Test
    public void nameTest(){
        setup();

        createUserDto.setUsername("name");
        assertEquals("name", createUserDto.getUsername());
    }

    @Test
    public void passwordTest(){
        setup();

        createUserDto.setPassword("pwd");
        assertEquals("pwd", createUserDto.getPassword());
    }

}
