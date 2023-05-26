package com.encora.employee.service;

import com.encora.employee.dto.EmployeeDTO;

public interface EmployeeService {
	public void saveEmployee(EmployeeDTO employeeDTO);
	
	public void updateEmployee(EmployeeDTO employeeDTO);
	
	public EmployeeDTO searchEmployee(EmployeeDTO employeeDTO);
	
	public void deleteEmployee(EmployeeDTO employeeDTO);
	
	public EmployeeDTO firstEmployee();
	
	public EmployeeDTO previousEmployee();
	
	public EmployeeDTO nextEmployee();
	
	public EmployeeDTO lastEmployee();

}
