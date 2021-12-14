package ga.linuxcafe.pms.parameters.repositories;

import ga.linuxcafe.pms.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
