package ga.linuxcafe.pms.parameters.repositories;

import ga.linuxcafe.pms.parameters.models.PercentComplete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentCompleteRepository extends JpaRepository<PercentComplete, Integer> {

}
