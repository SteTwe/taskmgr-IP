package be.ucll.taskmgr.model.domain.dto;

import be.ucll.taskmgr.model.UserRole;
import be.ucll.taskmgr.model.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserDtoTest {

    private UserDto user;

    private void setup(){
        user = new UserDto();
    }

    @Test
    public void idTest(){
        setup();

        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    public void nameTest(){
        setup();

        user.setUsername("TestUser");
        assertEquals("TestUser", user.getUsername());
    }


    @Test
    public void roleTest(){
        setup();

        user.setRole(UserRole.ADMIN);
        assertEquals(UserRole.ADMIN, user.getRole());
    }
}
