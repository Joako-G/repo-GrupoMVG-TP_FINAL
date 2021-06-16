package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductService {

	public void guardarProduct(Product product);
	public List<Product> getProductos();
	public Product getProduct();
}
