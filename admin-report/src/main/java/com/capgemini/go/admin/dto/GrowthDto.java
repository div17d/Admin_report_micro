package com.capgemini.go.admin.dto;

public class GrowthDto {
	
	int month;
	int year;
	Double revenue;
	Double change;
	Double percentageGrowth;
	String colour;
	
	
	public Double getPercentageGrowth() {
		return percentageGrowth;
	}

	public void setPercentageGrowth(Double percentageGrowth) {
		this.percentageGrowth = percentageGrowth;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public GrowthDto(double change) {
		super();
		this.change=change;
	}
	
	public GrowthDto(int year, double revenue) {
		super();
		this.year = year;
		this.revenue = revenue;
		
	}


	
	public GrowthDto(int month, int year, double revenue) {
		super();
		this.month = month;
		this.year = year;
		this.revenue = revenue;
	}
	
	
	
	public GrowthDto() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}

}
