package com.encora.employee.controller;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.service.EmployeeService;
import com.encora.employee.service.impl.EmployeeSerivceImpl;
import com.encora.employee.view.EmployeeFrame;

public class EmployeeHandler implements ActionListener {
	EmployeeFrame ef;
	EmployeeService employeeService;
	public EmployeeHandler(EmployeeFrame employeeFrame) {
		// TODO Auto-generated constructor stub
		ef = employeeFrame;
		employeeService = new EmployeeSerivceImpl();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand().toLowerCase();
		EmployeeDTO empDto = getEmployeeData(ef);
		switch (action) {
		case "save":
			employeeService.saveEmployee(empDto);
			break;
		case "update":
			employeeService.updateEmployee(empDto);
			break;
		case "search":
			EmployeeDTO searchResult = employeeService.searchEmployee(empDto);
			refreshEmployeeForm(searchResult);
			break;
		case "delete":
			employeeService.deleteEmployee(empDto);
			break;
		case "first":
			EmployeeDTO firstEmployeeResult  = employeeService.firstEmployee();
			System.out.println(firstEmployeeResult);
			refreshEmployeeForm(firstEmployeeResult);
			break;
		case "last":
			EmployeeDTO lastEmployeeResult  = employeeService.lastEmployee();
			refreshEmployeeForm(lastEmployeeResult);
			break;
		case "previous":
			EmployeeDTO previousEmployeeResult  = employeeService.previousEmployee();
			System.out.println(previousEmployeeResult);
			refreshEmployeeForm(previousEmployeeResult);
			break;
		case "next":
			EmployeeDTO nextEmployeeResult  = employeeService.nextEmployee();
			System.out.println(nextEmployeeResult);
			refreshEmployeeForm(nextEmployeeResult);
			break;
		default:
			break;
		}
		
	}

	public void refreshEmployeeForm(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		ef.getTextId().setText(""+dto.getEmployeeID());
		ef.getTextName().setText(dto.getEmployeeName());
	}

	public EmployeeDTO getEmployeeData(EmployeeFrame ef) {
		// TODO Auto-generated method stub
		EmployeeDTO employeeDTO = new EmployeeDTO();
		if (!ef.getTextId().getText().equals("")) {
			employeeDTO.setEmployeeID(Integer.parseInt(ef.getTextId().getText()));
		}
		employeeDTO.setAddress(ef.getTextAreaAddress().getText());
		employeeDTO.setEmployeeName(ef.getTextName().getText());
		employeeDTO.setGender(ef.getGenderGroup().getSelectedCheckbox().getLabel());
		employeeDTO.setPf(ef.getFacilityOptionPF().getState());
		employeeDTO.setMealCard(ef.getFacilityOptionMealCard().getState());
		employeeDTO.setGarduity(ef.getFacilityOptionGraduity().getState());
		employeeDTO.setNps(ef.getFacilityOptionNPS().getState());
		employeeDTO.setMediClaim(ef.getFacilityOptionMediClaim().getState());
		employeeDTO.setOfficeLocation(ef.getSelectLocation().getSelectedItem());
		employeeDTO.setSalary(ef.getTextSalary().getText());
		
		return employeeDTO;
		
	}

}
