package tn.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.entities.Device;
import tn.entities.Employee;

@Remote
public interface EmployeeServiceRemote {
	
	public void ajouterEmployee (Employee employe);
	
	public void ajouterDevice (Device device);
	
	public void affecterDeviceAEmployee(String deviceUniqueIdentifier, Long matricule);
	
	public List<Device> getDevicesByEmploye(Long matricule);
	
	public void suppEmpAllDev (Long matricule);
	
	public Employee login(Long matricule, String password);
	
	public List<String> getEmpNames();
	
	public List<Employee> allEmployees();
	
	public List<Device> allDevices();
	
}
