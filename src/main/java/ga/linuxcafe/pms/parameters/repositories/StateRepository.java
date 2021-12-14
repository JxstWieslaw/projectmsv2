package ga.linuxcafe.pms.parameters.repositories;

import ga.linuxcafe.pms.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
