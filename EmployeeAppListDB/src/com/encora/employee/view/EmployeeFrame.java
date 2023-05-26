package com.encora.employee.view;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.encora.employee.utils.EmployeeCache;
import com.encora.employee.controller.EmployeeHandler;

public class EmployeeFrame extends Frame{
	
	private TextField textId;
	private TextField textName;
	private Checkbox genderOptionMale;
	private Checkbox genderOptionfemale;
	private Checkbox genderOptionOther;
	private CheckboxGroup genderGroup;
	private Checkbox facilityOptionPF;
	private Checkbox facilityOptionGraduity;
	private Checkbox facilityOptionMealCard;
	private Checkbox facilityOptionNPS;
	private Checkbox facilityOptionMediClaim;
	private Choice selectLocation;
	private TextArea textAreaAddress;
	private TextField textSalary;


	public EmployeeFrame(String title, int x, int y, int width, int height, boolean visibility) {
		setBounds(x, y, width, height);
		setVisible(visibility);
		setTitle(title);
		
		//Input Items
		genderGroup = new CheckboxGroup();
		
		Label lblId = new Label("Employee Id");
		lblId.setBounds(50, 50, 100, 30);
		add(lblId);
		
		textId = new TextField();
		textId.setBounds(200, 50 ,150, 30);
		add(textId);
		
		Label lblFirstName = new Label("Employee Name");
		lblFirstName.setBounds(50, 100, 100, 30);
		add(lblFirstName);
		
		textName = new TextField();
		textName.setBounds(200, 100 ,150, 30);
		add(textName);
		

		//Gender
		Label lblGender = new Label("Gender");
		lblGender.setBounds(50, 150, 100, 30);
		add(lblGender);
		
		genderOptionMale = new Checkbox("Male", true, genderGroup);
		genderOptionMale.setBounds(200, 150 ,80, 30);
		add(genderOptionMale);
		
		genderOptionfemale = new Checkbox("Female", false, genderGroup);
		genderOptionfemale.setBounds(280, 150 ,80, 30);
		add(genderOptionfemale);
		
		genderOptionOther = new Checkbox("Others", false, genderGroup);
		genderOptionOther.setBounds(360, 150 ,80, 30);
		add(genderOptionOther);
		
		//Facilities
		Label lblFacilities = new Label("Facilities");
		lblFacilities.setBounds(50, 200, 100, 30);
		add(lblFacilities);
		
		facilityOptionPF = new Checkbox("PF");
		facilityOptionPF.setBounds(200, 200 ,60, 30);
		add(facilityOptionPF);
		
		facilityOptionGraduity = new Checkbox("Graduity");
		facilityOptionGraduity.setBounds(280, 200 ,90, 30);
		add(facilityOptionGraduity);
		
		facilityOptionMealCard = new Checkbox("Meal Card");
		facilityOptionMealCard.setBounds(360, 200 ,100, 30);
		add(facilityOptionMealCard);
		
		facilityOptionNPS = new Checkbox("NPS");
		facilityOptionNPS.setBounds(460, 200 ,60, 30);
		add(facilityOptionNPS);
		
		facilityOptionMediClaim = new Checkbox("MediClaim");
		facilityOptionMediClaim.setBounds(520, 200 ,100, 30);
		add(facilityOptionMediClaim);
		
		
		//Location Choice
		Label lblLocation = new Label("Location");
		lblLocation.setBounds(50, 250, 100, 30);
		add(lblLocation);
		
		selectLocation = new Choice();
		selectLocation.setBounds(200, 250 ,150, 30);
		selectLocation.add("Bangalore");
		selectLocation.add("Hubli");
		add(selectLocation);
		
		//Address
		Label lblAddress = new Label("Address");
		lblAddress.setBounds(370, 250, 60, 30);
		add(lblAddress);
		
		textAreaAddress = new TextArea();
		textAreaAddress.setBounds(450, 250, 200, 200);
		add(textAreaAddress);
		
		//Salary
		Label lblSalary = new Label("Salary");
		lblSalary.setBounds(50, 470, 100, 30);
		add(lblSalary);
		
		textSalary = new TextField();
		textSalary.setBounds(200, 470 ,150, 30);
		add(textSalary);
		
		//Buttons
		Button saveButton = new Button("Save");
		saveButton.setBounds(50, 520, 100, 30);
		add(saveButton);
		
		Button searchButton = new Button("Search");
		searchButton.setBounds(170, 520, 100, 30);
		add(searchButton);
		
		Button updateButton = new Button("Update");
		updateButton.setBounds(290, 520, 100, 30);
		add(updateButton);
		
		Button deleteButton = new Button("Delete");
		deleteButton.setBounds(410, 520, 100, 30);
		add(deleteButton);
		
		Button firstButton = new Button("First");
		firstButton.setBounds(50, 560, 100, 30);
		add(firstButton);
		
		Button previousButton = new Button("Previous");
		previousButton.setBounds(170, 560, 100, 30);
		add(previousButton);
		
		Button nextButton = new Button("Next");
		nextButton.setBounds(290, 560, 100, 30);
		add(nextButton);
		
		Button lastButton = new Button("Last");
		lastButton.setBounds(410, 560, 100, 30);
		add(lastButton);
		
		//Action Handlers
		saveButton.addActionListener(new EmployeeHandler(this));
		searchButton.addActionListener(new EmployeeHandler(this));
		updateButton.addActionListener(new EmployeeHandler(this));
		deleteButton.addActionListener(new EmployeeHandler(this));
		
		firstButton.addActionListener(new EmployeeHandler(this));
		previousButton.addActionListener(new EmployeeHandler(this));
		nextButton.addActionListener(new EmployeeHandler(this));
		lastButton.addActionListener(new EmployeeHandler(this));
		
		//Events
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				EmployeeFrame ef = (EmployeeFrame) e.getSource();
				ef.dispose();
			}
		});
		
		EmployeeCache cache = EmployeeCache.getInstance();
		cache.refreshEmployeeCache();
	}


	public TextField getTextId() {
		return textId;
	}


	public void setTextId(TextField textId) {
		this.textId = textId;
	}


	public TextField getTextName() {
		return textName;
	}


	public void setTextName(TextField textName) {
		this.textName = textName;
	}


	public Checkbox getGenderOptionMale() {
		return genderOptionMale;
	}


	public void setGenderOptionMale(Checkbox genderOptionMale) {
		this.genderOptionMale = genderOptionMale;
	}


	public Checkbox getGenderOptionfemale() {
		return genderOptionfemale;
	}


	public void setGenderOptionfemale(Checkbox genderOptionfemale) {
		this.genderOptionfemale = genderOptionfemale;
	}


	public Checkbox getGenderOptionOther() {
		return genderOptionOther;
	}


	public void setGenderOptionOther(Checkbox genderOptionOther) {
		this.genderOptionOther = genderOptionOther;
	}


	public CheckboxGroup getGenderGroup() {
		return genderGroup;
	}


	public void setGenderGroup(CheckboxGroup genderGroup) {
		this.genderGroup = genderGroup;
	}


	public Checkbox getFacilityOptionPF() {
		return facilityOptionPF;
	}


	public void setFacilityOptionPF(Checkbox facilityOptionPF) {
		this.facilityOptionPF = facilityOptionPF;
	}


	public Checkbox getFacilityOptionGraduity() {
		return facilityOptionGraduity;
	}


	public void setFacilityOptionGraduity(Checkbox facilityOptionGraduity) {
		this.facilityOptionGraduity = facilityOptionGraduity;
	}


	public Checkbox getFacilityOptionMealCard() {
		return facilityOptionMealCard;
	}


	public void setFacilityOptionMealCard(Checkbox facilityOptionMealCard) {
		this.facilityOptionMealCard = facilityOptionMealCard;
	}


	public Checkbox getFacilityOptionNPS() {
		return facilityOptionNPS;
	}


	public void setFacilityOptionNPS(Checkbox facilityOptionNPS) {
		this.facilityOptionNPS = facilityOptionNPS;
	}


	public Checkbox getFacilityOptionMediClaim() {
		return facilityOptionMediClaim;
	}


	public void setFacilityOptionMediClaim(Checkbox facilityOptionMediClaim) {
		this.facilityOptionMediClaim = facilityOptionMediClaim;
	}


	public Choice getSelectLocation() {
		return selectLocation;
	}


	public void setSelectLocation(Choice selectLocation) {
		this.selectLocation = selectLocation;
	}


	public TextArea getTextAreaAddress() {
		return textAreaAddress;
	}


	public void setTextAreaAddress(TextArea textAreaAddress) {
		this.textAreaAddress = textAreaAddress;
	}


	public TextField getTextSalary() {
		return textSalary;
	}


	public void setTextSalary(TextField textSalary) {
		this.textSalary = textSalary;
	}
	
	
}
