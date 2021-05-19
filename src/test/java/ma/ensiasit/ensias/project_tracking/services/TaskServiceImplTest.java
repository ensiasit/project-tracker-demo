package ma.ensiasit.ensias.project_tracking.services;

import ma.ensiasit.ensias.project_tracking.models.Task;
import ma.ensiasit.ensias.project_tracking.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private TaskServiceImpl taskService;

  @Test
  void givenExistingTaskShouldReturnCorrectTask() {
    // Given
    String id = "id-1";
    Task task = new Task(id, null, null);

    when(taskRepository.findById(id)).thenReturn(Optional.of(task));

    // When
    Task returnedTask = taskService.getTask(id);

    // Then
    verify(taskRepository).findById(id);
    assertEquals(id, returnedTask.getId());
  }

}