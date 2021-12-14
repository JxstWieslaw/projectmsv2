package ga.linuxcafe.pms.parameters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectStage {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="projectstage_seq")
	@SequenceGenerator(name="projectstage_seq", allocationSize = 1)
	private int id;

	private String details;

}
