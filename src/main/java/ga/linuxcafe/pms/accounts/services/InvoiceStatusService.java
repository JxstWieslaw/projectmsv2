package ga.linuxcafe.pms.accounts.services;

import ga.linuxcafe.pms.accounts.models.InvoiceStatus;
import ga.linuxcafe.pms.accounts.repositores.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InvoiceStatusService {
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//Return list of countries
	public List<InvoiceStatus> getAll(){
		return invoiceStatusRepository.findAll();
	}
	
	//SAve new InvoiceStatus
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	//get by id
	public Optional<InvoiceStatus> getById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceStatusRepository.deleteById(id);
	}

}
