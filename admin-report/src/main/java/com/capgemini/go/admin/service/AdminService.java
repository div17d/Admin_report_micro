package com.capgemini.go.admin.service;

import java.util.ArrayList;
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


public interface AdminService {
	
	List<RevenueDto> revenueReport(String productID);
	
	List<GrowthDto> growthReportMonthly(int month, int year);
	
	List<GrowthDto> growthReportYearly(int year);
	
	Set<Integer> saleYear();
	
	Set<String> viewOrderedProduct();
}
