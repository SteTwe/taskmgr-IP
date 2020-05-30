package be.ucll.taskmgr.model.db;

import be.ucll.taskmgr.model.domain.entity.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<Subtask, Integer> {
}
