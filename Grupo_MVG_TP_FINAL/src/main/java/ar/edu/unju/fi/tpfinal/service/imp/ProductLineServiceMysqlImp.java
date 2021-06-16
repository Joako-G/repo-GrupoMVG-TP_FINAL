package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Service("productLineServiceMysql")
public class ProductLineServiceMysqlImp implements IProductLineService {

	@Autowired
	private IProductLineRepository productLineRepository;
	
	@Override
	public void guardarProductLine(ProductLine productLine) {
		productLineRepository.save(productLine);
		
	}

}
