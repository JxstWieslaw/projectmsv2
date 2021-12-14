package ga.linuxcafe.pms.hr.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class EmployeeType {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="employeetype_seq")
    @SequenceGenerator(name="employeetype_seq", allocationSize = 1)
    private Integer id;
    private String description;
    private String details;

    public EmployeeType() {
    }

    public EmployeeType(Integer id, String description, String details) {
        this.id = id;
        this.description = description;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
