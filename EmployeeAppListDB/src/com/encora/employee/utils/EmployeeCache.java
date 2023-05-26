package com.encora.employee.utils;

import java.util.ArrayList;
import java.util.List;

import com.encora.employee.dto.EmployeeDTO;

public class EmployeeCache {
	private List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
	
	private static EmployeeCache employeeCache = new EmployeeCache();

	private EmployeeCache() {}
	
	public static EmployeeCache getInstance() {
		if(employeeCache == null) {
			employeeCache = new EmployeeCache();
		}
		return employeeCache;
	}
	
	public void refreshEmployeeCache() {
		
		
	}

	public List<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeDTO> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeCache [employeeList=");
		builder.append(employeeList);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
