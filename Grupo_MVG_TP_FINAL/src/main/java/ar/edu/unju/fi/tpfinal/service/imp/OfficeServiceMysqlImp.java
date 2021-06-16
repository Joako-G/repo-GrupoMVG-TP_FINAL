package ar.edu.unju.fi.tpfinal.service.imp;

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

}
