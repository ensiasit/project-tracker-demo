package ma.ensiasit.ensias.project_tracking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

  @Id
  private String id;

  private String description;

  private LocalDate deadline;

}
