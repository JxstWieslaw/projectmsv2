package ga.linuxcafe.pms.helpdesk.models;

import ga.linuxcafe.pms.hr.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticket_seq")
    @SequenceGenerator(name="ticket_seq", allocationSize = 1)
    private Integer id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "raisedbyid", insertable = false, updatable = false)
    private Employee employee;
    private Integer raisedbyid;

    @ManyToOne
    @JoinColumn(name = "ticketstatusid", insertable = false, updatable = false)
    private TicketStatus ticketStatus;
    private Integer ticketstatusid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ticketDate;

}
