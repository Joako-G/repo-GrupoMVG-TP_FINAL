package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productCode")
	private long id;
	
	@NotEmpty(message = "Debe ingresar el nombre del producto")
	@Column(name="productName", length = 20)
	private String nombreProducto;
	
	@Column(name="productSacle")
	private LocalDate productScale;
	
	@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora")
	@Column(name="productVendor", length = 30)
	private String vendedorProducto;
	
	@NotEmpty(message = "Debe ingresar descripcion del producto")
	@Column(name="productDescription", length = 150)
	private String descripcionProducto;
	
	@NotNull(message = "Debe ingresar el stock del producto")
	@Column(name="quantityInStock")
	private int stock;
	
	@NotNull(message = "Debe ingresar el precio del producto")
	@Column(name="buyPrice")
	private float precioCompra;
	
	@Column(name="MSRP")
	private float MSRP;
	
	@Autowired
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productLine")
	private ProductLine productLine;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(@NotNull long id, @NotEmpty(message = "Debe ingresar el nombre del producto") String nombreProducto,
			LocalDate productScale,
			@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora") String vendedorProducto,
			@NotEmpty(message = "Debe ingresar descripcion del producto") String descripcionProducto,
			@NotNull(message = "Debe ingresar el stock del producto") int stock,
			@NotNull(message = "Debe ingresar el precio del producto") float precioCompra, float mSRP,
			@Valid ProductLine productLine) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.productScale = productScale;
		this.vendedorProducto = vendedorProducto;
		this.descripcionProducto = descripcionProducto;
		this.stock = stock;
		this.precioCompra = precioCompra;
		MSRP = mSRP;
		this.productLine = productLine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public LocalDate getProductScale() {
		return productScale;
	}

	public void setProductScale(LocalDate productScale) {
		this.productScale = productScale;
	}

	public String getVendedorProducto() {
		return vendedorProducto;
	}

	public void setVendedorProducto(String vendedorProducto) {
		this.vendedorProducto = vendedorProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getMSRP() {
		return MSRP;
	}

	public void setMSRP(float mSRP) {
		MSRP = mSRP;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nombreProducto=" + nombreProducto + ", productScale=" + productScale
				+ ", vendedorProducto=" + vendedorProducto + ", descripcionProducto=" + descripcionProducto + ", stock="
				+ stock + ", precioCompra=" + precioCompra + ", MSRP=" + MSRP + ", productLine=" + productLine + "]";
	}
	

}
