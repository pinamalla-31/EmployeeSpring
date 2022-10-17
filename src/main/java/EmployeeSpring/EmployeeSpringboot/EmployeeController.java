package EmployeeSpring.EmployeeSpringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import EmployeeSpring.Employee.Model.Employee;

@Controller
public class EmployeeController {
 //display list of employees
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployees() );
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showEmployeeForm(Model model)
	{
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		return "new_Employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/";
		
	}
	@GetMapping("/deleteEmployee/{id}")
		public String deleteEmployeeById(@PathVariable (name="id")long id ) 
		{
			this.employeeService.deleteEmployeeById(id);
			return "redirect:/";
		}
	@GetMapping("/showFomUpadate/{id}")
	public String showFormForUpdate(@PathVariable(name="id")long id ,Model model)
	{
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (name="id")long id ,Model model)
	{
		
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}
}