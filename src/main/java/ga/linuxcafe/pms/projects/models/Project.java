package ga.linuxcafe.pms.projects.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ga.linuxcafe.pms.hr.models.Employee;
import ga.linuxcafe.pms.parameters.models.Client;
import ga.linuxcafe.pms.parameters.models.ProjectPriority;
import ga.linuxcafe.pms.parameters.models.ProjectStage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "project_id")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	@SequenceGenerator(name="project_seq", allocationSize = 1)
	private int projectId;

	private String name;

	private String description;

	@ManyToOne
	@JoinColumn(name="clientid", insertable=false, updatable=false)
	private Client client;
	private Integer clientid;

	@ManyToOne
	@JoinColumn(name="projectstageid", insertable=false, updatable=false)
	private ProjectStage projectStage;
	private Integer projectstageid;

	@ManyToOne
	@JoinColumn(name="projectpriorityid", insertable=false, updatable=false)
	private ProjectPriority projectPriority;
	private Integer projectpriorityid;

	@ManyToOne
	@JoinColumn(name="projecttypeid", insertable=false, updatable=false)
	private ProjectType projectType;
	private Integer projecttypeid;

	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE},
			fetch= FetchType.LAZY)
	@JoinTable(name="project_employee",
			joinColumns=@JoinColumn(name="project_id"),
			inverseJoinColumns=@JoinColumn(name="employee_id"))
	@JsonIgnore
	private List<Employee> employees;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;

	@OneToOne(cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE},
			fetch= FetchType.LAZY)
	@JoinColumn(name="status_id")
	@JsonIgnore
	private ProjectStatus projectStatus;

}
