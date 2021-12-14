package ga.linuxcafe.pms.parameters.repositories;

import ga.linuxcafe.pms.parameters.models.ProjectStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectStageRepository extends JpaRepository<ProjectStage, Integer> {

}
