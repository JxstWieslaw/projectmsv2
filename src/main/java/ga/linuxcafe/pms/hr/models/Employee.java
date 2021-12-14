package ga.linuxcafe.pms.hr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ga.linuxcafe.pms.parameters.models.*;
import ga.linuxcafe.pms.projects.models.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employee_id")
public class Employee  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;

	@ManyToOne
	@JoinColumn(name="employeetypeid", insertable=false, updatable=false)
	private EmployeeType employeeType;
	private Integer employeetypeid;

	@ManyToOne
	@JoinColumn(name="titleid", insertable=false, updatable=false)
	private Title title;
	private Integer titleid;

	@ManyToOne
	@JoinColumn(name="genderid", insertable=false, updatable=false)
	private Gender gender;
	private Integer genderid;

	@ManyToOne
	@JoinColumn(name="maritalstatusid", insertable=false, updatable=false)
	private MaritalStatus maritalStatus;
	private Integer maritalstatusid;
	
	private String username;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private String firstname;
	private String lastname;
	private String othername;
	private String initials;
	private String socialSecurityNumber;
	private String city;
	private String address;
	private String phone;
	private String mobile;
	private String email;

	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE},
			fetch= FetchType.LAZY)
	@JoinTable(name="project_employee",
			joinColumns=@JoinColumn(name="employee_id"),
			inverseJoinColumns=@JoinColumn(name="project_id"))
	@JsonIgnore
	private List<Project> projects;

	@ManyToOne
	@JoinColumn(name="jobroleid", insertable=false, updatable=false)
	private JobRole jobRole;
	private Integer jobroleid;

	@ManyToOne
	@JoinColumn(name="employeestatusid", insertable=false, updatable=false)
	private EmployeeStatus employeeStatus;
	private Integer employeestatusid;

	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;
	private Integer countryid;

	@ManyToOne
	@JoinColumn(name="stateid", insertable=false, updatable=false)
	private State state;
	private Integer stateid;
}
