package ga.linuxcafe.pms.helpdesk.repositores;

import ga.linuxcafe.pms.helpdesk.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {

}
