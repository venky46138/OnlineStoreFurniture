package com.services;
import com.entity.Bill;
import com.entity.Card;

public interface PaymentServiceInterface {
	Bill getBillById(long billNo) throws Exception;
	double payByCash(double amount) throws Exception;
	Card payByCard(Card card) throws Exception;
	public Bill addBillDetails(Bill bill);

}
