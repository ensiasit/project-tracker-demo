package ma.ensiasit.ensias.project_tracking.services;

import lombok.AllArgsConstructor;
import ma.ensiasit.ensias.project_tracking.exceptions.DocumentNotFoundException;
import ma.ensiasit.ensias.project_tracking.models.Task;
import ma.ensiasit.ensias.project_tracking.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  @Override  public List<Task> getAll() {
    return taskRepository.findAll();
  }

  @Override
  public Task addTask(Task payload) {
    return taskRepository.save(payload);
  }

  @Override
  public Task getTask(String id) {
    return taskRepository
      .findById(id)
      .orElseThrow(() -> new DocumentNotFoundException(String.format("Document with id='%s' not found.", id)));
  }

}
