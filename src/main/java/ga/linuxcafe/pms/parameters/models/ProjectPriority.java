package ga.linuxcafe.pms.parameters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPriority {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="projectpriority_seq")
	@SequenceGenerator(name="projectpriority_seq", allocationSize = 1)
	private int id;

	private String details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
