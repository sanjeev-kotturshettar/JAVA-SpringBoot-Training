package com.common;

import java.util.Arrays;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public void setYear(int year) {
		//Validate Year
		if (year > 2030) 
			this.year = 2030;
		else if (year < 2023) 
			this.year = 2023;
		else
			this.year = year; 
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setMonth(int month) {
		
		//Validate Month
		if (month < 1)
			this.month = 1;
		else if (month > 12) 
			this.month = 12;
		else
			this.month = month;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public void setDay(int day) {
		this.day = day;
		
		//Initialise min and max date
		int min = 1;
		int max = 31;
		
		//Change max if month is February
		if(this.month == 2) {
			max = 28;
		}
		
		//If date is lesser than min or bigger than max
		if (day < min || day > max) {
			if(day < min) {
				this.day = min;
			}
			
			if(this.month == 2 && day > max) {
				boolean checkLoopYear = checkLeepYear(this.year);
				this.day = max;
				if(checkLoopYear)
					this.day = ++max;
			}
			
			if(day > max) {
				Integer[] leepMonth = {4, 6, 9, 11};
				if(Arrays.asList(leepMonth).contains(this.month)) {
					this.day = --max;
				}
				
				Integer[] bigMonth = {1, 3, 5, 7, 8, 10, 12};
				if(Arrays.asList(bigMonth).contains(this.month)) {
					this.day = max;
				}
			}
			
		}
	}
	
	public int getDay() {
		return this.day;
	}
	
	public Date(int day, int month, int year) {
		//setters and getters
		setDay(day);
		setMonth(month);
		setYear(year);	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return day+"-"+month+"-"+year;
	}
	
	public boolean checkLeepYear(int year) {
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}

}
