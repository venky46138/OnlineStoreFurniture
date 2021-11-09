package com.services;
import com.entity.*;
import com.exception.OrderServiceException; 

public interface OrderCancellationServiceInterface {
	String deleteOrder(FurnitureOrder order) throws OrderServiceException;
	String deleteOrderById(String orderId) throws OrderServiceException;
}
