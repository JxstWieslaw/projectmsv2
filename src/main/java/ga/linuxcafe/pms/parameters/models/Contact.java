package ga.linuxcafe.pms.parameters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contact_seq")
	@SequenceGenerator(name="contact_seq", allocationSize = 1)
	private int id;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String mobile;
	private String remarks;


}
