package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<ProductLine> getProductLines() {
		List<ProductLine> productlinelist = (List<ProductLine>) productLineRepository.findAll();
		return productlinelist;
	}

	@Override
	public Optional<ProductLine> getProducLinePorId(String id) {
		Optional<ProductLine> productLine = productLineRepository.findById(id);
		return productLine;
	}

	@Override
	public void eliminarProductLine(String id) {
		productLineRepository.deleteById(id);
	}

}
