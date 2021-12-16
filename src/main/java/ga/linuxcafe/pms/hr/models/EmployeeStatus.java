package ga.linuxcafe.pms.hr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ga.linuxcafe.pms.parameters.models.CommonObject;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Getter
@Setter
public class EmployeeStatus extends CommonObject {

}
