package com.capgemini.go.admin.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.go.admin.dto.GrowthDto;
import com.capgemini.go.admin.dto.RevenueDto;
import com.capgemini.go.admin.entity.OrderEntity;
@Repository
public interface AdminDao extends JpaRepository<OrderEntity, Integer>{

	@Query("SELECT NEW com.capgemini.go.admin.dto.RevenueDto(o.userID , o.orderID , p.productID ,  p.productCatagory , p.productPrice ) "+
	"FROM OrderEntity o INNER JOIN Product p ON p.productID=o.productID " + "WHERE o.productID=?1")
	List<RevenueDto> revenueReport(String product_id);
	
	@Query("FROM OrderEntity")
	List<OrderEntity> viewOrderedProduct();
	
	@Query("SELECT sum(p.productPrice)"+
			"FROM Product p INNER JOIN OrderEntity o ON p.productID = o.productID " 
		+ "WHERE month(o.orderDispatchTime)=?1 AND year(o.orderDispatchTime)=?2")
	Double growthMonthly(int month, int year);
	
	
	@Query("SELECT sum(p.productPrice)"+
			"FROM Product p INNER JOIN OrderEntity o ON p.productID= o.productID "
			+ "WHERE year(o.orderDispatchTime)=?1")
	Double growthYear(int time);
	
	@Query("SELECT year(o.orderDispatchTime) FROM OrderEntity o")
	List<Integer> viewOrderedYear();
	
	
	
	
	
}


