package ma.ensiasit.ensias.project_tracking.repositories;

import ma.ensiasit.ensias.project_tracking.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
