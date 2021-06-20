package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Office;

public interface IOfficeService {
	
	void guardarOffice(Office office);
	public List<Office> getOffices();
	public Optional<Office> getOfficePorId(String id);

}
