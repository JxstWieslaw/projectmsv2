package ga.linuxcafe.pms.projects.repositores;

import ga.linuxcafe.pms.projects.models.ProjectPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectPersonnelRepository extends JpaRepository<ProjectPersonnel, Integer> {

}
