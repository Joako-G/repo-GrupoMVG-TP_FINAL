package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductService {

	public void guardarProduct(Product product);
	public List<Product> getProductos();
	public Optional<Product> getProductPorId(String id);
	public Product getProduct();
	//public Optional<Product> getProductPorId(String id);
	public void eliminarProduct(String id);
}
