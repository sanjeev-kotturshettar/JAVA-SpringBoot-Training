package com.encora.employee.service;

import com.encora.employee.dto.EmployeeDTO;

public interface EmployeeService {
	public void saveEmployee(EmployeeDTO empDTO);

	public void updateEmployee(EmployeeDTO empDTO);

	public EmployeeDTO searchEmployee(EmployeeDTO empDTO);

	public void deleteEmployee(EmployeeDTO empDTO);

	public EmployeeDTO firstEmployee();

	public EmployeeDTO lastEmployee();

	public EmployeeDTO previousEmployee();

	public EmployeeDTO nextEmployee();

}


