package ga.linuxcafe.pms.parameters.repositories;

import ga.linuxcafe.pms.parameters.models.ProjectPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPriorityRepository extends JpaRepository<ProjectPriority, Integer> {

}
