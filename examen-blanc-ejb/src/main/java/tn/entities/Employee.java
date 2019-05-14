package tn.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long matricule;
	private String firstName;
	private String lastName;
	private String password;
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;
	@OneToMany(mappedBy="employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Device> devices ; 
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}   
	public long getMatricule() {
		return this.matricule;
	}

	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public EmployeeType getEmployeeType() {
		return this.employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
   
}
