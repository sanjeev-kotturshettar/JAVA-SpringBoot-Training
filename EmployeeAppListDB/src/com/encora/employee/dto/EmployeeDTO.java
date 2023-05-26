package com.encora.employee.dto;

public class EmployeeDTO {
	private int employeeID;
	private String employeeName;
	private String gender;
	private boolean pf;
	private boolean mealCard;
	private boolean garduity;
	private boolean nps;
	private boolean mediClaim;
	private String officeLocation;
	private String address;
	private String salary;
	
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isPf() {
		return pf;
	}
	public void setPf(boolean pf) {
		this.pf = pf;
	}
	public boolean isMealCard() {
		return mealCard;
	}
	public void setMealCard(boolean mealCard) {
		this.mealCard = mealCard;
	}
	public boolean isGarduity() {
		return garduity;
	}
	public void setGarduity(boolean garduity) {
		this.garduity = garduity;
	}
	public boolean isNps() {
		return nps;
	}
	public void setNps(boolean nps) {
		this.nps = nps;
	}
	public boolean isMediClaim() {
		return mediClaim;
	}
	public void setMediClaim(boolean mediClaim) {
		this.mediClaim = mediClaim;
	}
	public String getOfficeLocation() {
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDTO [employeeID=");
		builder.append(employeeID);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", pf=");
		builder.append(pf);
		builder.append(", mealCard=");
		builder.append(mealCard);
		builder.append(", garduity=");
		builder.append(garduity);
		builder.append(", nps=");
		builder.append(nps);
		builder.append(", mediClaim=");
		builder.append(mediClaim);
		builder.append(", officeLocation=");
		builder.append(officeLocation);
		builder.append(", address=");
		builder.append(address);
		builder.append(", salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}
	
	
}
