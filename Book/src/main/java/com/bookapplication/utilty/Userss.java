package com.bookapplication.utilty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Userss {

	
	
	Order order;

	public Order getOrder() {
		return order;
	}

    
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	
	 
}
