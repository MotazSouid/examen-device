package tn.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.entities.Device;
import tn.entities.Employee;

@Local
public interface EmployeeServiceLocal {
	
	public void ajouterEmployee (Employee employe);
	
	public void ajouterDevice (Device device);
	
	public void affecterDeviceAEmployee(String deviceUniqueIdentifier, Long matricule);
	
	public List<Device> getDevicesByEmploye(Long matricule);
	
	public void suppEmpAllDev (Long matricule);

}
