package com.encora.employee.common.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.encora.employee.dto.EmployeeDTO;

public class EmployeeCache {
	private List<EmployeeDTO> employeeList;
	
	private static EmployeeCache employeeCache = new EmployeeCache(); 
	
	private EmployeeCache() {}
	
	public static EmployeeCache getInstance() {
		if(employeeCache == null ) {
			employeeCache = new EmployeeCache();
		}
		return employeeCache;
	}


	public void refreshEmployeeCache() {
		employeeList = new ArrayList<EmployeeDTO>(20);
		Connection con = null;
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_db.employees");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeName(rs.getString(2));
				dto.setGender(rs.getNString(3));
				employeeList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public List<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeDTO> employeeList) {
		this.employeeList = employeeList;
	}
}
