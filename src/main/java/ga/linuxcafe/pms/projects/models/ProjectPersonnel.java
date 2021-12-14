package ga.linuxcafe.pms.projects.models;

import ga.linuxcafe.pms.hr.models.Employee;
import ga.linuxcafe.pms.parameters.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPersonnel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne
	@JoinColumn(name="projectid", insertable=false, updatable=false)
	private Project project;
	private Integer projectid;

	@ManyToOne
	@JoinColumn(name="clientid", insertable=false, updatable=false)
	private Client client;
	private Integer clientid;

	@ManyToOne
	@JoinColumn(name="projectleadid", insertable=false, updatable=false)
	private Employee eProjectLead;
	private Integer projectleadid;

	@ManyToOne
	@JoinColumn(name="projectteamid", insertable=false, updatable=false)
	private Employee eProjectTeam;
	private Integer projectteamid;

}
