package ma.ensiasit.ensias.project_tracking.services;

import ma.ensiasit.ensias.project_tracking.models.Task;

import java.util.List;

public interface TaskService {

  List<Task> getAll();

  Task addTask(Task payload);

  Task getTask(String id);

}
