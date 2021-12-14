package ga.linuxcafe.pms.parameters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gender {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gender_seq")
	@SequenceGenerator(name="gender_seq", allocationSize = 1)
	private int id;

	private String details;
}
