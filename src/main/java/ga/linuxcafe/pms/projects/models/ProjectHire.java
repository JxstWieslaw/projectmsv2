package ga.linuxcafe.pms.projects.models;

import ga.linuxcafe.pms.parameters.models.Client;
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
public class ProjectHire {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="projecthire_seq")
	@SequenceGenerator(name="projecthire_seq", allocationSize = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="projectid", insertable=false, updatable=false)
	private Project project;
	private Integer projectid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateHired;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateDue;

	@ManyToOne
	@JoinColumn(name="clientid", insertable=false, updatable=false)
	private Client client;
	private Integer clientid;
	
	private String price;
	
	private String remarks;
}
