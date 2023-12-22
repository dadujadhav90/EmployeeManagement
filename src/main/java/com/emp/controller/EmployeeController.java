package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.entity.Employee;
import com.emp.service.EmployeeService;

import jakarta.validation.Valid;
@Controller
public class EmployeeController {
//	@Autowired
//	private EmployeeService empService;
//	
//	@GetMapping("/")
//	public String getAllEmp(Model model) {
//			//return findPaginated(1, "currentPage", "asc", model);		
//		model.addAttribute("listEmp",this.empService.getAllEmployees());
//		return "index";
//	}
//	
//	@GetMapping("/showNewEmpForm")
//	public String showNewEmployeeForm(Model model) {
//		//create model attribute to bind form data
//		Employee emp=new Employee();
//		model.addAttribute("employee",emp);
//		return "new_employee";
//	}
//	
//	@PostMapping("/saveEmployee")
//	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,BindingResult result) {
//		//save employee to database
//		if(result.hasErrors()) {
//			return "new_employee";
//		}
//		this.empService.saveEmployee(employee);
//		return "redirect:/";
//	}
//	
//	@GetMapping("/showEmpUpdateForm/{id}")
//	public String showUpdateForm(@PathVariable("id") int id,Model model) {
//		Employee employee=this.empService.getEmployeeById(id);
//		model.addAttribute("employee",employee);
//		return "update_employee";
//	}
//	
//	@GetMapping("/deleteEmployee/{id}")
//	public String deleteEmployee(@PathVariable("id") int id) {
//		//delete employee 
//		this.empService.deleteEmployeeById(id);
//		return "redirect:/";
//	}
//	/*	
//	@GetMapping("/search")
//	public String search(@PathVariable("query") String query,Employee employee) {
//		model.addAttribute("action","search");
//		return "redirect:/";
//	}*/
//	@PostMapping("/searchEmployee/{id}")
//	public String saveEmployee(@PathVariable("id") String sid,Model m) {
//		int id=Integer.parseInt(sid);
//		Employee employee=this.empService.getEmployeeById(id);
//	    m.addAttribute("emp",employee);
//	    return "redirect:/";
//	}
}
