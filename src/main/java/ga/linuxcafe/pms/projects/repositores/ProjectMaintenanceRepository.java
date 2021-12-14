package ga.linuxcafe.pms.projects.repositores;

import ga.linuxcafe.pms.projects.models.ProjectMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectMaintenanceRepository extends JpaRepository<ProjectMaintenance, Integer> {

}
