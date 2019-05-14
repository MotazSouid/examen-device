package tn.esprit.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.entities.Device;
import tn.entities.Employee;
import tn.entities.EmployeeType;
import tn.interfaces.EmployeeServiceRemote;

@ManagedBean(name="examenBean")
@SessionScoped
public class ExamenBean implements Serializable {
	private long matricule;
	private String password;
	private Employee emp;
	private List<Device> devices;
	private List<String> names;
	private List<String> models;
	private Device device;
	private String name;
	private String model;
	private List<Employee> employees;
	@EJB
	EmployeeServiceRemote employeService;
	
	public String affecterDevice()
	{
		employeService.affecterDeviceAEmployee(device.getUniqueIdentifier(), emp.getMatricule());
		return "productOwner?faces-redirect=true";
	}
	
	public String login()
	{
		emp = employeService.login(matricule, password);
		String navigateTo = "";
		if(emp!= null)
		{
		if(emp.getEmployeeType().toString().equals("EMP"))
		{
			devices = employeService.allDevices();
			employees = employeService.allEmployees();
			navigateTo = "productOwner?faces-redirect=true";
		}
		else
		{
			devices = employeService.allDevices();
			employees = employeService.allEmployees();
			navigateTo = "productOwner?faces-redirect=true";
		}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
		return navigateTo;
	}
	
	public long getMatricule() {
		return matricule;
	}
	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public EmployeeServiceRemote getEmployeService() {
		return employeService;
	}
	public void setEmployeService(EmployeeServiceRemote employeService) {
		this.employeService = employeService;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
		
}
