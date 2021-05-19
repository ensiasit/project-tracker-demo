package ma.ensiasit.ensias.project_tracking.controllers;

import lombok.AllArgsConstructor;
import ma.ensiasit.ensias.project_tracking.models.Task;
import ma.ensiasit.ensias.project_tracking.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @GetMapping("/api/tasks")
  public List<Task> getAll() {
    return taskService.getAll();
  }

  @PostMapping("/api/tasks")
  public Task addTask(@RequestBody Task payload) {
    return taskService.addTask(payload);
  }

  @GetMapping("/api/tasks/{id}")
  public Task getTask(@PathVariable String id) {
    return taskService.getTask(id);
  }

  @DeleteMapping("/api/tasks/{id}")
  public Task deleteTask(@PathVariable String id) {
    return taskService.deleteTask(id);
  }

}
