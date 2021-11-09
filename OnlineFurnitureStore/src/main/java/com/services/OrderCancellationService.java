package com.services;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FurnitureOrder;
import com.exception.OrderServiceException;
import com.repositry.OrderCancellationRepository;

@Service
@Transactional

public class OrderCancellationService implements OrderCancellationServiceInterface {
	@Autowired
	OrderCancellationRepository ocr;
	
	@Override
	public String deleteOrder(FurnitureOrder order) throws OrderServiceException 
	{
		List<FurnitureOrder> resultFurniture;
		try {
			resultFurniture = ocr.findAll();
			if (resultFurniture != null) 
			{
				ocr.deleteAll();
				return "All Values are deleted successfully";
			} 
			else 
			{
				throw new OrderServiceException("There is no value in the furniture");
			}
		} 
		catch (Exception e) 
		{
			throw new OrderServiceException("There is no value in the furniture");
		}
	}
	@Override
    public String deleteOrderById(String orderId) throws OrderServiceException {
		try {
			Optional<FurnitureOrder> del = ocr.findById(orderId);
			if (del == null) 
			{
				throw new OrderServiceException("no user found");
			} 
			else 
			{
				ocr.deleteById(orderId);
				return "Order Deleted" + del;

			}
		} 
		catch (Exception e) 
		{
			throw new OrderServiceException("No order found");
		}
	}
}
