package ga.linuxcafe.pms.accounts.services;

import ga.linuxcafe.pms.accounts.models.TransactionStatus;
import ga.linuxcafe.pms.accounts.repositores.TransactionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionStatusService {

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    public List<TransactionStatus> getAll(){
        return transactionStatusRepository.findAll();
    }

    public void save(TransactionStatus transactionStatus){
        transactionStatusRepository.save(transactionStatus);
    }

    public void delete(Integer id){
        transactionStatusRepository.deleteById(id);
    }
    
    public TransactionStatus getById(Integer id){
        return transactionStatusRepository.findById(id).orElse(null);
    }
}
