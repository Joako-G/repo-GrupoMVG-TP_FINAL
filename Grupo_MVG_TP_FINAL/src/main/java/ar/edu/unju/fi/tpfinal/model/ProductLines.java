package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTLINES")
public class ProductLines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prL_productLine")
	private Long id;
	
	@Column(name = "prL_textDescription")
	private String textDescription;
	
	@Column(name = "prL_htmlDescription")
	private String htmlDescription;
	
	@Column(name = "prL_image")
	private byte[] image;
	
	@OneToMany(mappedBy = "product")
	private List<Products> products = new ArrayList<Products>();
	
	public ProductLines() {
		// TODO Auto-generated constructor stub
	}

	public ProductLines(Long id, String textDescription, String htmlDescription, byte[] image,
			List<Products> products) {
		super();
		this.id = id;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductLines [id=" + id + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + Arrays.toString(image) + "]";
	}

}
