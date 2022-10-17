package EmployeeSpring.EmployeeSpringboot;


import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmployeeSpring.Employee.Model.Employee;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
	
		return employeeRepository.findAll();
	}

	public void employeeService(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> optional= employeeRepository.findById(id);
		Employee employee=null;
	if(optional.isPresent())
		{
		employee=optional.get();
		
		}
	else {
		System.out.println("erorr");
	}
		return employee;
	}

	private Optional<Employee> isPresent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
	this.employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		
	}

}
