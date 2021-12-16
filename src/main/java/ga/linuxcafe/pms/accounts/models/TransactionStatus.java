package ga.linuxcafe.pms.accounts.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionstatus_seq")
	@SequenceGenerator(name="transactionstatus_seq", allocationSize = 1)
	private int id;

	private String details;

}
