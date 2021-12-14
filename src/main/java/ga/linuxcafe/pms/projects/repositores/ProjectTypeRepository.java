package ga.linuxcafe.pms.projects.repositores;

import ga.linuxcafe.pms.projects.models.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Integer> {

}
