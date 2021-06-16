package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@SpringBootTest
class OfficeTest {

	@Autowired
	IOfficeService officeService;
	
	@Test
	void testGuardarOffice() {
		Office office = new Office("1234", "San Salvador de Jujuy", "123456789", "Av. Exodo", null, "Jujuy", "Argentina", "4600", null, null);
		officeService.guardarOffice(office);
		assertEquals("1234", office.getId());
	}

}
