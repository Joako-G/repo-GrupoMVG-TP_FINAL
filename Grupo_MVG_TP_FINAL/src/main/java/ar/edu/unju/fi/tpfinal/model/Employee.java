package ar.edu.unju.fi.tpfinal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@Column(name = "employeeNumber")
	private Long id;
	
	@Column(name = "lastName")
	private String apellido;
	
	@Column(name = "firstName")
	private String nombre;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "email")
	private String correo;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "officeCode")
	private Office oficina;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
	private Employee gerente;
	
	@OneToMany(mappedBy = "gerente")
	private List<Employee> empleados;
	
	@Column(name = "jobTitle")
	private String titulo;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String apellido, String nombre, String extension, String correo, Office oficina,
			Employee gerente, List<Employee> empleados, String titulo) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.extension = extension;
		this.correo = correo;
		this.oficina = oficina;
		this.gerente = gerente;
		this.empleados = empleados;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Employee getGerente() {
		return gerente;
	}

	public void setGerente(Employee gerente) {
		this.gerente = gerente;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", extension=" + extension
				+ ", correo=" + correo + ", gerente=" + gerente + ", empleados=" + empleados + ", titulo=" + titulo
				+ "]";
	}
	
}
