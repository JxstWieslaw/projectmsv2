package ga.linuxcafe.pms.hr.repositories;

import ga.linuxcafe.pms.hr.models.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRoleRepository extends JpaRepository<JobRole, Integer> {

}
