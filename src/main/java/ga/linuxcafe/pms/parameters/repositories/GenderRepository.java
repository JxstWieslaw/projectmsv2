package ga.linuxcafe.pms.parameters.repositories;

import ga.linuxcafe.pms.parameters.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
