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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String description;

	@ManyToOne
	@JoinColumn(name="managerid", insertable=false, updatable=false)
	private Employee employee;
	private Integer managerid;

}
