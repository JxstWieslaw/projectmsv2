package ga.linuxcafe.pms.projects.models;

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
public class ProjectMaintenance {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="projectmaintenance_seq")
	@SequenceGenerator(name="projectmaintenance_seq", allocationSize = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="projectid", insertable=false, updatable=false)
	private Project project;
	private Integer projectid;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false)
	private Employee employee;
	private Integer employeeid;
	
	private String remarks;
	
}
