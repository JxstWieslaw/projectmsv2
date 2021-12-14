package ga.linuxcafe.pms.projects.repositores;


import ga.linuxcafe.pms.projects.dto.ProjectProjectStatus;
import ga.linuxcafe.pms.projects.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery=true, value="SELECT ps.id as statusId, p.name as projectName, p.acquisition_date as dateOpened, p.due_date as dateDue, " +
            " ps.priority as priority, ps.percent_complete as percentComplete, ps.status as status FROM project p" +
            " left join project_status ps " +
            "ON p.status_id = ps.id " +
            "GROUP BY ps.id, p.name, p.acquisition_date, p.due_date, ps.priority, ps.percent_complete, ps.status " +
            "ORDER BY 3 DESC;")
    List<ProjectProjectStatus> projectProjectStatus();

}
