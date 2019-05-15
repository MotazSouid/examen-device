package tn.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.entities.Device;
import tn.entities.Employee;
import tn.interfaces.EmployeeServiceLocal;
import tn.interfaces.EmployeeServiceRemote;

/**
 * Session Bean implementation class EmployeService
 */
@Stateless
public class EmployeService implements EmployeeServiceLocal, EmployeeServiceRemote {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EmployeService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see EmployeeServiceLocal#suppEmpAllDev(Long)
     */
    public void suppEmpAllDev(Long matricule) {
    	Employee emp = em.find(Employee.class, matricule );
        em.remove(emp);
    }

	/**
     * @see EmployeeServiceLocal#ajouterEmployee(Employee)
     */
    public void ajouterEmployee(Employee employe) {
        em.persist(employe);
    }

	/**
     * @see EmployeeServiceLocal#ajouterDevice(Device)
     */
    public void ajouterDevice(Device device) {
        em.persist(device);
    }

	/**
     * @see EmployeeServiceLocal#affecterDeviceAEmployee(String, Long)
     */
    public void affecterDeviceAEmployee(String deviceUniqueIdentifier, Long matricule) {
        Employee emp = em.find(Employee.class, matricule);
        Device dev = em.find(Device.class, deviceUniqueIdentifier);
        dev.setEmployee(emp);
        List<Device> devices = new ArrayList<>();
        devices.addAll(emp.getDevices());
        devices.add(dev);
        emp.setDevices(devices);
    }

	/**
     * @see EmployeeServiceLocal#getDevicesByEmploye(Long)
     */
    public List<Device> getDevicesByEmploye(Long matricule) {
        Employee emp = em.find(Employee.class, matricule);
        return emp.getDevices();
    }

	@Override
	public Employee login(Long matricule, String password) {
		Employee emp = em.createQuery("select c from Employee c where c.matricule = :matricule "
				+ "and c.password = :password",Employee.class)
				.setParameter("matricule", matricule)
				.setParameter("password",password )
				.getSingleResult();
		return emp;
		
	}

	@Override
	public List<String> getEmpNames() {
		List<Employee> emps = em.createQuery("select c from Employee c",Employee.class).getResultList();
		List<String> names = new ArrayList<>();
		for(Employee e: emps)
		{
			names.add(e.getFirstName());
		}
		return names;
	}

	@Override
	public List<Employee> allEmployees() {
		
		return em.createQuery("select c from Employee c", Employee.class).getResultList();
	}

	@Override
	public List<Device> allDevices() {
		
		return em.createQuery("select c from Device c",Device.class).getResultList();
	}

}
