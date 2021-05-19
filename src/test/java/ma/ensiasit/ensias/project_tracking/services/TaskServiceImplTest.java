package ma.ensiasit.ensias.project_tracking.services;

import ma.ensiasit.ensias.project_tracking.exceptions.DocumentNotFoundException;
import ma.ensiasit.ensias.project_tracking.models.Task;
import ma.ensiasit.ensias.project_tracking.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    when(taskRepository.findById(id)).thenReturn(Optional.of(new Task(id, null, null)));

    // When
    var returnedTask = taskService.getTask(id);

    // Then
    verify(taskRepository).findById(id);
    assertEquals(id, returnedTask.getId());
  }

  @Test
  void givenNotExistingTaskShouldReturnCorrectTask() {
    // Given
    String id = "id-1";

    when(taskRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(
            //Then
            DocumentNotFoundException.class,
            //Whe
            () -> taskService.getTask(id)
    );

    verify(taskRepository).findById(id);
  }
}