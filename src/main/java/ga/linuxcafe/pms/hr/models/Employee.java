package ga.linuxcafe.pms.hr.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ga.linuxcafe.pms.parameters.models.*;
import ga.linuxcafe.pms.projects.models.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee  {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(name="employee_seq", allocationSize = 1)
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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Integer getEmployeetypeid() {
		return employeetypeid;
	}

	public void setEmployeetypeid(Integer employeetypeid) {
		this.employeetypeid = employeetypeid;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Integer getTitleid() {
		return titleid;
	}

	public void setTitleid(Integer titleid) {
		this.titleid = titleid;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getGenderid() {
		return genderid;
	}

	public void setGenderid(Integer genderid) {
		this.genderid = genderid;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getMaritalstatusid() {
		return maritalstatusid;
	}

	public void setMaritalstatusid(Integer maritalstatusid) {
		this.maritalstatusid = maritalstatusid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public JobRole getJobRole() {
		return jobRole;
	}

	public void setJobRole(JobRole jobRole) {
		this.jobRole = jobRole;
	}

	public Integer getJobroleid() {
		return jobroleid;
	}

	public void setJobroleid(Integer jobroleid) {
		this.jobroleid = jobroleid;
	}

	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Integer getEmployeestatusid() {
		return employeestatusid;
	}

	public void setEmployeestatusid(Integer employeestatusid) {
		this.employeestatusid = employeestatusid;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
}
