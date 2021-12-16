package ga.linuxcafe.pms.hr.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="department_seq")
	@SequenceGenerator(name="department_seq", allocationSize = 1)
	private int id;

	private String description;

	@ManyToOne
	@JoinColumn(name="managerid", insertable=false, updatable=false)
	private Employee employee;
	private Integer managerid;

}
