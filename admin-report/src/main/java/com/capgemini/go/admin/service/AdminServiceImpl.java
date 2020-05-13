package com.capgemini.go.admin.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.admin.dao.AdminDao;
import com.capgemini.go.admin.dto.GrowthDto;
import com.capgemini.go.admin.dto.RevenueDto;
import com.capgemini.go.admin.entity.OrderEntity;
import com.capgemini.go.admin.entity.Product;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	
	//method for revenue report
	public List<RevenueDto> revenueReport(String productID) {
		return adminDao.revenueReport(productID);
	}
	
	//method for Monthly growth report
	public List<GrowthDto> growthReportMonthly(int month, int year) {
		GrowthDto result = new GrowthDto();
		Double totalSale;
		Double previous;
		List<GrowthDto> resultList = new ArrayList<>();
		totalSale = adminDao.growthMonthly(month,year);
		previous = adminDao.growthMonthly(month-1,year);
		if(month<2)
			previous = adminDao.growthMonthly(12,year-1);
		
		result.setMonth(month);
		result.setYear(year);
		Double percentage;
		
		//setting the revenue of the period
		if(totalSale != null)
			result.setRevenue(totalSale);
		else
			result.setRevenue(0.0);
		
		//getting the growth result
		if(previous!=null && totalSale !=null) {
			result.setChange(result.getRevenue()-previous);
			percentage = (result.getChange()/result.getRevenue())*100;
			result.setPercentageGrowth(Double.parseDouble(String.format("%.3f", percentage)));
		}
		else if(previous == null && totalSale != null) {
		result.setChange(result.getRevenue());
		result.setPercentageGrowth((result.getChange()/result.getRevenue())*100);
		}
		else if(previous != null && totalSale ==null) {
			result.setChange(-previous);
			result.setPercentageGrowth(-100.0);
		}
		else {
			result.setChange(0.0);
			result.setPercentageGrowth(0.0);
		}
		//setting other properties
		if(result.getPercentageGrowth()<2)
			result.setColour("Red");
		else if(result.getPercentageGrowth()>2 && result.getPercentageGrowth()<10)
			result.setColour("Blue");
		else
			result.setColour("Green");
		
		resultList.add(result);
		return resultList;
	}
	
	
	
	//method for yearly growth report
	public List<GrowthDto> growthReportYearly(int year) {
		GrowthDto result = new GrowthDto();
		Double totalSale;
		Double previous;
		List<GrowthDto> resultList = new ArrayList<>();
		totalSale = adminDao.growthYear(year);
		previous = adminDao.growthYear(year-1);
		result.setYear(year);
		Double percentage;
		
		//setting the revenue of the period
		if(totalSale != null)
			result.setRevenue(totalSale);
		else
			result.setRevenue(0.0);
		
		//getting the previous result
		if(previous!=null && totalSale !=null) {
			result.setChange(result.getRevenue()-previous);
			percentage = (result.getChange()/result.getRevenue())*100;
			result.setPercentageGrowth(Double.parseDouble(String.format("%.3f", percentage)));
		}
		else if(previous == null && totalSale != null) {
		result.setChange(result.getRevenue());
		result.setPercentageGrowth((result.getChange()/result.getRevenue())*100);
		}
		else if(previous != null && totalSale ==null) {
			result.setChange(-previous);
			result.setPercentageGrowth(-100.0);
		}
		else {
			result.setChange(0.0);
			result.setPercentageGrowth(0.0);
		}
		//setting other properties
		if(result.getPercentageGrowth()<2)
			result.setColour("Red");
		else if(result.getPercentageGrowth()>2 && result.getPercentageGrowth()<10)
			result.setColour("Blue");
		else
			result.setColour("Green");
		
		resultList.add(result);
		return resultList;
		
	}
	
	//method to select all the sale year
	public Set<Integer> saleYear(){
		List<Integer> year = adminDao.viewOrderedYear();
		Integer start= Collections.min(year);
		Set<Integer> result = new HashSet<>();
		Integer end = LocalDateTime.now().getYear();
		for(Integer i=start; i<=end; i++)
			result.add(i);
		return result;
	}
	
	//method to view all the ordered product
	public Set<String> viewOrderedProduct() {
		List<OrderEntity> list = adminDao.viewOrderedProduct();
		Set<String> resultList = list.stream().map(OrderEntity::getProductID).collect(Collectors.toSet());
		return resultList;
		
	}
}
