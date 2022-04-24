package com.jazaSoftware.taskManager.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jazaSoftware.taskManager.model.TaskManager;

@Repository
public interface TaskManagerDao extends JpaRepository<TaskManager, Integer> {

	public TaskManager findTaskManagerBytaskId(Integer id);

	@Query(value = "select task from TaskManager where date=CURDATE()+2")
	public List<String> findTaskByDate();

	@Query(value = "select task from TaskManager where label_label_id=:n and date=CURDATE()")
	public List<String> findTaskByLabel(@Param("n") Integer p_id);

	@Query(value = "select task from TaskManager where priority='HIGH' or priority='CRITICAL' ")
	public List<String> findCriticalAndHighPriorityTask();

}
