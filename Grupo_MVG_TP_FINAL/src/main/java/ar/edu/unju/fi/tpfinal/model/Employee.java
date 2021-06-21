package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeNumber")
	private Integer id;
	
	@NotEmpty(message = "Debe ingresar su apellido")
	@Column(name = "lastName", length = 50)
	private String apellido;
	
	@NotEmpty(message = "Debe ingresar su nombre")
	@Column(name = "firstName", length = 50)
	private String nombre;
	
	@NotNull
	@Column(name = "extension", length = 10)
	private String extension;
	
	@NotNull(message = "Debe ingresar su email")
	@Column(name = "email", length = 100)
	private String correo;
	
	@NotNull
	@Column(name = "jobTitle", length = 50)
	private String titulo;
	
	//Relacion con Office
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "officeCode")
	private Office oficina;
	
	//Relacion con Employee
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
	private Employee superior;
	
	@OneToMany(mappedBy = "superior")
	private List<Employee> empleados = new ArrayList<Employee>();
	
	//Relacion con Customer
	@Autowired
	@OneToMany(mappedBy = "empleado")
	private List<Customer> clientes = new ArrayList<Customer>();
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer id, @NotEmpty(message = "Debe ingresar su apellido") String apellido,
			@NotEmpty(message = "Debe ingresar su nombre") String nombre, @NotNull String extension,
			@NotNull String correo, @NotNull String titulo, Office oficina, Employee superior,
			List<Employee> empleados, List<Customer> clientes) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.extension = extension;
		this.correo = correo;
		this.titulo = titulo;
		this.oficina = oficina;
		this.superior = superior;
		this.empleados = empleados;
		this.clientes = clientes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Office getOficina() {
		return oficina;
	}

	public void setOficina(Office oficina) {
		this.oficina = oficina;
	}

	public Employee getSuperior() {
		return superior;
	}

	public void setSuperior(Employee superior) {
		this.superior = superior;
	}

	public List<Employee> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Employee> empleados) {
		this.empleados = empleados;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Customer> getClientes() {
		return clientes;
	}

	public void setClientes(List<Customer> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", extension=" + extension
				+ ", correo=" + correo + ", titulo=" + titulo + ", oficina=" + oficina + ", superior=" + superior
				+ ", empleados=" + empleados + ", clientes=" + clientes + "]";
	}

}
