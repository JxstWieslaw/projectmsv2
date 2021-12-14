package ga.linuxcafe.pms.helpdesk.repositores;

import ga.linuxcafe.pms.helpdesk.models.Ticket;
import ga.linuxcafe.pms.hr.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
