package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {
	
	void guardarProductLine(ProductLine productLine);
	public List<ProductLine> getProductLines();
	
	public Optional<ProductLine> getProducLinePorId(String id);
	public void eliminarProductLine(String id);

}
