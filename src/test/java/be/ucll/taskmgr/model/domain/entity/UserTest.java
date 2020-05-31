package be.ucll.taskmgr.model.domain.entity;


import be.ucll.taskmgr.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserTest {

    private User user;


    private void setup(){
        user = new User();
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
    public void passwordTest(){
        setup();

        user.setPassword("TestPassword");
        assertEquals("TestPassword", user.getPassword());
    }

    @Test
    public void roleTest(){
        setup();

        user.setRole(UserRole.ADMIN);
        assertEquals(UserRole.ADMIN, user.getRole());
    }

    @Test
    public void userTest(){
        user = new User("Username", "password");

        assertNotNull(user);
        assertEquals("Username", user.getUsername());
        assertEquals("password", user.getPassword());
    }



}
