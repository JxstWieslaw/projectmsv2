package ga.linuxcafe.pms.accounts.repositores;

import ga.linuxcafe.pms.accounts.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}
