package ga.linuxcafe.pms.projects.repositores;

import ga.linuxcafe.pms.projects.models.ProjectHire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectHireRepository extends JpaRepository<ProjectHire, Integer> {

}
