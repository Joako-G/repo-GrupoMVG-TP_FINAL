package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.repository.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Service("productServiceImpMysql")
public class ProductServiceMysqlImp implements IProductService{


	@Autowired
	private Product product;
	
	@Autowired
	private IProductRepository productRepository;
	
	@Override
	public void guardarProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getProductos() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	@Override
	public Product getProduct() {
		return product;
	}

	@Override
	public Optional<Product> getProductPorId(String id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}
}
