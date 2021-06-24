package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@SpringBootTest
class OfficeTest {

	@Autowired
	IOfficeService officeService;
	
	@Autowired
	IEmployeeService employeeService;
	
	@Test
	void testGuardarOffice() {
		Office office1 = new Office("1", "San Francisco", "+16502194782", "100 MArket Stret", "Suite 300", "CA", "USA", "94080", "NA");
		officeService.guardarOffice(office1);
		
		Office office2 = new Office("2", "Boston", "+1 215 837 0825", "1550 Court Place", "Suite 102", "MA", "USA", "02107", "NA");
		officeService.guardarOffice(office2);
		
		Office office3 = new Office("3", "NYC", "+1 212 555 3000", "523 East 53rd Street", "apt. 5A", "NY", "USA", "10022", "NA");
		officeService.guardarOffice(office3);
		
		Office office4 = new Office("4", "Paris", "+33 14 723 4404", "43 Rue Jouffroy D'abbans", "apt. 6B", "Nantua", "France", "75017", "EMEA");
		officeService.guardarOffice(office4);
		
		Office office5 = new Office("5", "Tokyo", "+81 33 224 5000", "4-1 Kioicho", null, "Chiyoda-Ku", "Japan", "102-8578", "Japan");
		officeService.guardarOffice(office5);
		
		assertEquals("1", office1.getId());
	}

}
