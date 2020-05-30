package be.ucll.taskmgr.model.db;

import be.ucll.taskmgr.model.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
