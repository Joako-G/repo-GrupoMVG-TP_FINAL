package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerNumber")
	private Long idCliente;
	
	@NotNull(message = "Debe ingresar el nombre de la empresa")
	@Column(name="customerName", length = 30)
	private String empresaNombre;
	
	@NotEmpty(message = "Debe ingresar el apellido")
	@Column(name="contactLastName", length = 20)
	private String apellido;
	
	@NotEmpty(message = "Debe ingresar el nombre")
	@Column(name="contactFirsName", length = 30)
	private String nombre;
	
	@NotNull(message = "Debe ingresar el numero de celular/telefono")
	@Size(min=7,max=9,message = "Debe ingresar un numero valido")
	@Column(name="phone")
	private int telefono;
	
	@NotEmpty(message = "Debe ingresar la direccion")
	@Column(name="addressLine1")
	private String direccion1;
	
	@Column(name="addressLine2")
	private String direccion2;
	
	@NotEmpty(message = "Debe ingresar el nombre de la ciudad")
	@Column(name="city")
	private String ciudad;
	
	@Column(name="state")
	private String estado;
	
	
	@Column(name="postalCode")
	private int codigoPostal;
	
	@NotEmpty(message = "Debe ingresar el pais")
	@Column(name="country")
	private String pais;

	@NotNull(message = "Debe ingresar un limite para el credito")
	@Column(name="creditLimit")
	private double limiteCredito;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="salesRepEmployeeNumber")
	private Employee numeroEmpleado;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Long idCliente, String empresaNombre, String apellido, String nombre, int telefono, String direccion1,
			String direccion2, String ciudad, String estado, int codigoPostal, String pais, double limiteCredito,
			Employee numeroEmpleado) {
		super();
		this.idCliente = idCliente;
		this.empresaNombre = empresaNombre;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.limiteCredito = limiteCredito;
		this.numeroEmpleado = numeroEmpleado;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmpresaNombre() {
		return empresaNombre;
	}

	public void setEmpresaNombre(String empresaNombre) {
		this.empresaNombre = empresaNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Employee getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(Employee numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	@Override
	public String toString() {
		return "Customer [idCliente=" + idCliente + ", empresaNombre=" + empresaNombre + ", apellido=" + apellido
				+ ", nombre=" + nombre + ", telefono=" + telefono + ", direccion1=" + direccion1 + ", direccion2="
				+ direccion2 + ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal
				+ ", pais=" + pais + ", limiteCredito=" + limiteCredito + ", numeroEmpleado=" + numeroEmpleado + "]";
	}
	
}
