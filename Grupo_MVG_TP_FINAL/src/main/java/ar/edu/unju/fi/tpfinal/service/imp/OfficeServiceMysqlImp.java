package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.repository.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Service("officeServiceMysql")
public class OfficeServiceMysqlImp implements IOfficeService {
	
	@Autowired
	private IOfficeRepository officeRepository;

	@Override
	public void guardarOffice(Office office) {
		officeRepository.save(office);
	}

	@Override
	public List<Office> getOffices() {
		List<Office> offices = (List<Office>) officeRepository.findAll();
		return offices;
	}

	@Override
	public Optional<Office> getOfficePorId(String id) {
		Optional<Office> office = officeRepository.findById(id);
		return office;
	}

	@Override
	public void eliminarOffice(String id) {
		officeRepository.deleteById(id);
		
	}

}
