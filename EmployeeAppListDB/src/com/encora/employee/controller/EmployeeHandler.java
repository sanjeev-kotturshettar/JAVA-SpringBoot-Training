package com.encora.employee.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.service.EmployeeService;
import com.encora.employee.service.impl.EmployeeServiceImpl;
import com.encora.employee.view.EmployeeFrame;

public class EmployeeHandler implements ActionListener{
	EmployeeFrame ef;
	EmployeeService employeeService;
	
	public EmployeeHandler(EmployeeFrame employeeFrame) {
		ef = employeeFrame;
		employeeService = new EmployeeServiceImpl();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand().toLowerCase();
		EmployeeDTO empDTO = getEmployeeData(ef);
		switch (action) {
		case "save":
			employeeService.saveEmployee(empDTO);
			break;
		case "update":
			employeeService.updateEmployee(empDTO);
			break;
		case "search":
			EmployeeDTO searchResult = employeeService.searchEmployee(empDTO);
			refreshEmployeeForm(searchResult);
			break;
		case "delete":
			employeeService.deleteEmployee(empDTO);
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
		//ef.getGenderGroup().setText(dto.getGender());
		ef.getFacilityOptionPF().setState(dto.isPf());
		ef.getFacilityOptionMealCard().setState(dto.isMealCard());
		ef.getFacilityOptionGraduity().setState(dto.isGarduity());
		ef.getFacilityOptionMediClaim().setState(dto.isMediClaim());
		ef.getFacilityOptionNPS().setState(dto.isNps());
		ef.getTextAreaAddress().setText(dto.getAddress());
		ef.getTextSalary().setText(dto.getSalary());
		ef.getSelectLocation().select(dto.getOfficeLocation());
		
		
		
	}
	
	public EmployeeDTO getEmployeeData(EmployeeFrame ef) {
		EmployeeDTO dto = new EmployeeDTO();
		if(!ef.getTextId().getText().equals("")) {
			dto.setEmployeeID(Integer.parseInt(ef.getTextId().getText()));
		}
		dto.setEmployeeName(ef.getTextName().getText());
		dto.setGender(ef.getGenderGroup().getSelectedCheckbox().getLabel());
		dto.setPf(ef.getFacilityOptionPF().getState());
		dto.setMealCard(ef.getFacilityOptionMealCard().getState());
		dto.setGarduity(ef.getFacilityOptionGraduity().getState());
		dto.setNps(ef.getFacilityOptionNPS().getState());
		dto.setMediClaim(ef.getFacilityOptionMediClaim().getState());
		dto.setOfficeLocation(ef.getSelectLocation().getSelectedItem());
		dto.setAddress(ef.getTextAreaAddress().getText());
		
		dto.setSalary(ef.getTextSalary().getText());
		return dto;
	}

}
