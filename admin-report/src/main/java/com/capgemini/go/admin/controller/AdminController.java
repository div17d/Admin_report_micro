package com.capgemini.go.admin.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.admin.dao.AdminDao;
import com.capgemini.go.admin.dto.GrowthDto;
import com.capgemini.go.admin.dto.RevenueDto;
import com.capgemini.go.admin.entity.OrderEntity;
import com.capgemini.go.admin.entity.Product;
import com.capgemini.go.admin.exception.ProductNotFoundException;
import com.capgemini.go.admin.exception.ReportNotFoundException;
import com.capgemini.go.admin.exception.YearNotFoundException;
import com.capgemini.go.admin.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/view")
	public Set<String> getOrderedProduct() throws ProductNotFoundException {
		if(adminService.viewOrderedProduct().isEmpty()) {
			throw new ProductNotFoundException("There exists no product with this ID");
		}
		return adminService.viewOrderedProduct();
		}
	
	@GetMapping("/viewRevenue/{productID}")
	public List<RevenueDto> getRevenue(@PathVariable("productID") String productID) throws ReportNotFoundException {
		List<RevenueDto> revenue= adminService.revenueReport(productID);
		if(revenue.isEmpty()) {
			throw new ReportNotFoundException("We can not fecth the report");
		}
		return revenue;
	}
	
	@GetMapping("/saleYear")
	public Set<Integer> getSaleYear() throws YearNotFoundException {
		return adminService.saleYear();
		}
	
	@GetMapping("/viewGrowth/month/{month}/year/{year}")
	public List<GrowthDto> getGrowthMonthly(@PathVariable("month") int month, @PathVariable("year") int year) throws ReportNotFoundException {
		if(adminService.growthReportMonthly(month, year).isEmpty()) {
			throw new ReportNotFoundException("We can not fecth the report");
		}
		return adminService.growthReportMonthly(month, year);
		}
	
	@GetMapping("/viewGrowth/year/{year}")
	public List<GrowthDto> getGrowthYearly(@PathVariable("year") int year) throws ReportNotFoundException{
		if(adminService.growthReportYearly(year).isEmpty()) {
			throw new ReportNotFoundException("We can not fecth the report");
		}
		return adminService.growthReportYearly(year);
		}
	
	}
	