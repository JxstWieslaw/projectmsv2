package ga.linuxcafe.pms.accounts.repositores;

import ga.linuxcafe.pms.accounts.models.TransactionStatus;
import ga.linuxcafe.pms.hr.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer> {

}
