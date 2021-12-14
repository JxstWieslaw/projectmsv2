package ga.linuxcafe.pms.parameters.repositories;

import ga.linuxcafe.pms.parameters.models.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Integer> {

}
