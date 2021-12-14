package ga.linuxcafe.pms.parameters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Title {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="title_seq")
	@SequenceGenerator(name="title_seq", allocationSize = 1)
	private int id;

	private String details;

}
