package ga.linuxcafe.pms.parameters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PercentComplete {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="percentcomplete_seq")
	@SequenceGenerator(name="percentcomplete_seq", allocationSize = 1)
	private int id;
	private int value;
}
