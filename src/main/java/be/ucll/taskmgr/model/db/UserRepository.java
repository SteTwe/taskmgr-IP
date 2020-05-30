package be.ucll.taskmgr.model.db;

import be.ucll.taskmgr.model.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
