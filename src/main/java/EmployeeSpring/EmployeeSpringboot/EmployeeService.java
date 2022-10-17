package EmployeeSpring.EmployeeSpringboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmployeeSpring.Employee.Model.Employee;
@Service
public interface EmployeeService {
	public static final EmployeeService repo = null;

	List<Employee> getAllEmployees();

	void deleteEmployeeById(long id);

	Employee getEmployeeById(long id);

	void saveEmployee(Employee employee);

}
