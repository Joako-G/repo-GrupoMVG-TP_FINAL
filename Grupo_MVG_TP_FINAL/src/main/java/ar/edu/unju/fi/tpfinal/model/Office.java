package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "OFFICES")
public class Office {
	
	@Id
	@Column(name = "officeCode", length = 10)
	private String id;
	
	@NotEmpty(message = "Debe ingresar la ciudad")
	@Column(name = "city", length = 50)
	private String ciudad;
	
	@NotEmpty(message = "Debe ingresar el telefono")
	@Column(name = "phone", length = 50)
	private String telefono;
	
	@NotEmpty(message = "Debe ingresar la direccion")
	@Column(name = "addressLine1", length = 50)
	private String direccion1;
	
	@Column(name = "addressLine2", length = 50)
	private String direccion2;
	
	@NotEmpty(message = "Debe ingresar el estado o provincia")
	@Column(name = "state", length = 50)
	private String estado;
	
	@NotEmpty(message = "Debe ingresar el pais")
	@Column(name = "country", length = 50)
	private String pais;
	
	@Column(name = "postalCode", length = 15)
	private String codigoPostal;
	
	@Column(name = "territory", length = 10)
	private String territorio;
	
	//Relacion con Employee
	@OneToMany(mappedBy = "oficina")
	private List<Employee> empleados = new ArrayList<Employee>();
	
	public Office() {
		// TODO Auto-generated constructor stub
	}

	public Office(String id, @NotEmpty(message = "Debe ingresar la ciudad") String ciudad,

			@Min(value = 1000000, message = "El numero de telefono debe ser mayor a 1000000") @Max(value = 999999999, message = "El numero de telefono no debe superar los 9999999") String telefono,
			@NotEmpty(message = "Debe ingresar la direccion") String direccion1, String direccion2,
			@NotEmpty(message = "Debe ingresar el estado o provincia") String estado,
			@NotEmpty(message = "Debe ingresar el pais") String pais, String codigoPostal, String territorio,
			List<Employee> empleados) {
		super();
		this.id = id;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.estado = estado;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
		this.territorio = territorio;
		this.empleados = empleados;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTerritorio() {
		return territorio;
	}

	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", ciudad=" + ciudad + ", telefono=" + telefono + ", direccion1=" + direccion1
				+ ", direccion2=" + direccion2 + ", estado=" + estado + ", pais=" + pais + ", codigoPostal="
				+ codigoPostal + ", territorio=" + territorio + ", empleados=" + empleados + "]";
	}
	
}
