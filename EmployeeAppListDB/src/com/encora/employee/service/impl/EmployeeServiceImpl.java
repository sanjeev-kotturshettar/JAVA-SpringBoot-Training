package com.encora.employee.service.impl;

import java.util.List;

import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.service.EmployeeService;
import com.encora.employee.utils.EmployeeCache;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void saveEmployee(EmployeeDTO empDTO) {
		EmployeeCache cache = EmployeeCache.getInstance();
		cache.getEmployeeList().add(empDTO);
	}

	@Override
	public void updateEmployee(EmployeeDTO empDTO) {
		EmployeeDTO dto = null;
		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeeDTO> employeeList = cache.getEmployeeList();
		int i = 0;
		for (EmployeeDTO employee : employeeList) {
			if(employee.getEmployeeID() == empDTO.getEmployeeID()) {
				employeeList.set(i, empDTO);
			}
			i++;
		}
	}

	@Override
	public EmployeeDTO searchEmployee(EmployeeDTO empDTO) {
		EmployeeDTO dto = null;
		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeeDTO> employeeList = cache.getEmployeeList();
		for (EmployeeDTO employee : employeeList) {
			if(employee.getEmployeeID() == empDTO.getEmployeeID()) {
				dto = employee;
			}
		}
		return dto;
	}

	@Override
	public void deleteEmployee(EmployeeDTO empDTO) {
		EmployeeDTO dto = null;
		EmployeeCache cache = EmployeeCache.getInstance();
		List<EmployeeDTO> employeeList = cache.getEmployeeList();
		int i = 0;
		for (EmployeeDTO employee : employeeList) {
			if(employee.getEmployeeID() == empDTO.getEmployeeID()) {
				employeeList.remove(i);
			}
			i++;
		}
	}

	@Override
	public EmployeeDTO firstEmployee() {
		EmployeeCache cache = EmployeeCache.getInstance();
		EmployeeDTO dto = cache.getEmployeeList().get(0);
		return dto;
	}

	@Override
	public EmployeeDTO lastEmployee() {
		EmployeeCache cache = EmployeeCache.getInstance();
		EmployeeDTO dto = cache.getEmployeeList().get(-1);
		return dto;
	}

	@Override
	public EmployeeDTO previousEmployee() {
		return null;
	}

	@Override
	public EmployeeDTO nextEmployee() {
		return null;
	}

}
