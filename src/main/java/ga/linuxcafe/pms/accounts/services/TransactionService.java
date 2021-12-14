package ga.linuxcafe.pms.accounts.services;

import ga.linuxcafe.pms.accounts.models.Transaction;
import ga.linuxcafe.pms.accounts.repositores.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	//Return list of transactions
	public List<Transaction> getAll(){
		return transactionRepository.findAll();
	}


	//Save new Transaction
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}
	
	//get by id
	public Transaction getById(int id) {
		return transactionRepository.findById(id).orElse(null);
	}

	public void delete(Integer id) {
		transactionRepository.deleteById(id);
	}

}
