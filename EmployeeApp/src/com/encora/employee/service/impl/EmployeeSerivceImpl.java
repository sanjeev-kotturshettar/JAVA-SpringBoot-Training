package com.encora.employee.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.encora.employee.common.utils.DatabaseHelper;
import com.encora.employee.common.utils.EmployeeCache;
import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.service.EmployeeService;
import com.mysql.jdbc.Driver;

public class EmployeeSerivceImpl implements EmployeeService{
	
	Connection con;

	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO `emp_db`.`employees` (employee_name,gender,pf,meal_card,garduity,nps,medical_claim,location,address,salary) VALUES (?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, employeeDTO.getEmployeeName());
			ps.setString(2, employeeDTO.getGender());
			ps.setBoolean(3, employeeDTO.isPf());
			ps.setBoolean(4, employeeDTO.isMealCard());
			ps.setBoolean(5, employeeDTO.isGarduity());
			ps.setBoolean(6, employeeDTO.isNps());
			ps.setBoolean(7, employeeDTO.isMediClaim());
			ps.setString(8, employeeDTO.getOfficeLocation());
			ps.setString(9, employeeDTO.getAddress());
			ps.setString(10, employeeDTO.getSalary());
			ps.execute();
					
			/*Statement stmt = con.createStatement();
			String query = "";
			stmt.execute(query); */
			
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

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("UPDATE emp_db.employees SET employee_name = ?, gender = ?, pf = ?, meal_card = ?,"
					+ "garduity = ?, nps = ?, medical_claim = ?, location = ?, address = ?, salary = ?"
					+ "WHERE id = ?;");
			ps.setString(1, employeeDTO.getEmployeeName());
			ps.setString(2, employeeDTO.getGender());
			ps.setBoolean(3, employeeDTO.isPf());
			ps.setBoolean(4, employeeDTO.isMealCard());
			ps.setBoolean(5, employeeDTO.isGarduity());
			ps.setBoolean(6, employeeDTO.isNps());
			ps.setBoolean(7, employeeDTO.isMediClaim());
			ps.setString(8, employeeDTO.getOfficeLocation());
			ps.setString(9, employeeDTO.getAddress());
			ps.setString(10, employeeDTO.getSalary());
			ps.setInt(11, employeeDTO.getEmployeeID());
			ps.execute();
					
			/*Statement stmt = con.createStatement();
			String query = "";
			stmt.execute(query); */
			
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

	@Override
	public EmployeeDTO searchEmployee(EmployeeDTO employeeDTO) {
		Long startTime = System.currentTimeMillis();
		EmployeeDTO dto = new EmployeeDTO();
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_db.employees WHERE id = ?;");
			ps.setInt(1, employeeDTO.getEmployeeID());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto.setEmployeeName(rs.getString(2));
				dto.setGender(rs.getNString(3));
			}
			return dto;		
			/*Statement stmt = con.createStatement();
			String query = "";
			stmt.execute(query); */
			
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
			System.out.println("Time: "+(System.currentTimeMillis() - startTime));
		}
		return dto;
	}

	@Override
	public void deleteEmployee(EmployeeDTO employeeDTO) {
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM emp_db.employees WHERE id = ?;");
			ps.setInt(1, employeeDTO.getEmployeeID());
			ps.execute();
			
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

	@Override
	public EmployeeDTO firstEmployee() {
		// TODO Auto-generated method stub
		EmployeeCache cache = EmployeeCache.getInstance();
		EmployeeDTO dto = cache.getEmployeeList().get(0);
		return dto;
		
		/*
		EmployeeDTO dto = new EmployeeDTO(); 
		
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_db.employees", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				dto.setEmployeeName(rs.getString(2));
				dto.setGender(rs.getNString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}*/
	}

	@Override
	public EmployeeDTO previousEmployee() {
		// TODO Auto-generated method stub
		EmployeeDTO dto = new EmployeeDTO();
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_db.employees", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.previous()) {
				dto.setEmployeeName(rs.getString(2));
				dto.setGender(rs.getNString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}
	}

	@Override
	public EmployeeDTO nextEmployee() {
		// TODO Auto-generated method stub
		EmployeeDTO dto = new EmployeeDTO();
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_db.employees", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto.setEmployeeName(rs.getString(2));
				dto.setGender(rs.getNString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}
	}

	@Override
	public EmployeeDTO lastEmployee() {
		// TODO Auto-generated method stub
		EmployeeDTO dto = new EmployeeDTO();
		try {
			DatabaseHelper dbHelper = DatabaseHelper.getInstance();
			con = dbHelper.connectDB();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_db.employees", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.last()) {
				dto.setEmployeeName(rs.getString(2));
				dto.setGender(rs.getNString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}
	}

}
