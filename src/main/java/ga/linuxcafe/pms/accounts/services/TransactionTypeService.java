package ga.linuxcafe.pms.accounts.services;


import ga.linuxcafe.pms.accounts.models.TransactionType;
import ga.linuxcafe.pms.accounts.repositores.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeService {
	@Autowired
	private TransactionTypeRepository transactionTypeRepository;
	
	//Return list of transaction Types
	public List<TransactionType> getAll(){
		return transactionTypeRepository.findAll();
	}
	
	//SAve new TransactionType
	public void save(TransactionType transactionType) {
		transactionTypeRepository.save(transactionType);
	}
	
	//get by id
	public Optional<TransactionType> getById(int id) {
		return transactionTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		transactionTypeRepository.deleteById(id);
	}

}
