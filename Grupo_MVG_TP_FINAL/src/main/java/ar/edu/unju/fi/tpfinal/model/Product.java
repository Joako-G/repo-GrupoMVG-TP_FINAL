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

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productCode")
	private long productCode;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productSacle")
	private LocalDate productScale;
	
	@Column(name="productVendor")
	private String productVendor;
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="quantityInStock")
	private int quantityInStock;
	
	@Column(name="buyPrice")
	private float buyPrice;
	
	@Column(name="MSPR")
	private float MSRP;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productLine")
	private ProductLine productLine;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long productCode, String productName, LocalDate productScale, String productVendor,
			String productDescription, int quantityInStock, float buyPrice, float mSRP, ProductLine productLine) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		MSRP = mSRP;
		this.productLine = productLine;
	}



	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public LocalDate getProductScale() {
		return productScale;
	}

	public void setProductScale(LocalDate productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
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
		return "Products [productCode=" + productCode + ", productName=" + productName + ", productScale="
				+ productScale + ", productVendor=" + productVendor + ", productDescription=" + productDescription
				+ ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP=" + MSRP
				+ ", productLine=" + productLine + "]";
	}
	
}
