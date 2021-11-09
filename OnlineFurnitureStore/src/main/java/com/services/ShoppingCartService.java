package com.services;
import java.util.List;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import com.repositry.ShoppingCartRepositry;
import com.entity.Cart;
import com.exception.ShoppingCartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ShoppingCartService implements ShoppingCartServicesInterface {
	@Autowired
	ShoppingCartRepositry shoppingrepo;
	
	//to get carts
	@Transactional
	@Override
	public List<Cart> getAllCarts() throws ShoppingCartException{
		 List<Cart> tempcart= shoppingrepo.findAll();
		 if(tempcart.isEmpty()) {
			 throw new ShoppingCartException("Cart not found");
		 }
		 else {
			 List<Cart> getAllcarts= shoppingrepo.findAll();
			 return getAllcarts;
		 }
	}
	
	//to get cart by id
	@Transactional
	@Override
	public Cart getCartById(int cartId)  throws ShoppingCartException{
	   Optional<Cart> tempcart= shoppingrepo.findById(cartId);
	   if(tempcart.isPresent() == false) {
		   throw new ShoppingCartException("Cart not found");
	   }
	   else {
		   Cart getcart= shoppingrepo.findById(cartId).orElse(null);
		   return getcart;
	   }
	}
	     
	  // to update cart by id
	   @Transactional
	   @Override
	   public Cart updateCartById(int cartId, Cart cart) throws ShoppingCartException{
		   Optional<Cart> tempcart= shoppingrepo.findById(cartId);
		   if(tempcart.isPresent() == false) {
			   throw new ShoppingCartException(" Cart is Empty");
		   }
		   else {
			   Cart updatecart= shoppingrepo.save(cart);
			   return updatecart;
		   } 
	   }
	   // to delete cart from database
	   @Transactional
	   @Override
	   public String deleteCart(Cart cart ) throws ShoppingCartException{
		   Optional<Cart> carttemp= shoppingrepo.findById(cart.getCartId());
		   if(carttemp.isEmpty()) {
			   throw new ShoppingCartException("Cart not found");
		   }
		   else {
			   shoppingrepo.deleteById(cart.getCartId());
			   return "All Carts are deleted";
		   }
	   }
	   // to delete cart by id
	   @Transactional
	   @Override
	   public String deleteCartById(int cartId) throws ShoppingCartException{
		   Optional<Cart> tempcart = shoppingrepo.findById(cartId);
		   if(tempcart.isPresent()) {
			  shoppingrepo.deleteById(cartId);
			  return "Cart deleted successfully"; 
		   }
		   else {
			   throw new ShoppingCartException("Cart not Found");
		   }
		   
	   }
	   //to update cart
	   
    @Transactional
	@Override
	public Cart updateCart(Cart cart) throws ShoppingCartException {
    	Optional<Cart> tempcart= shoppingrepo.findById(cart.getCartId());
    	if(tempcart.isEmpty()) {
    		throw new ShoppingCartException("Cart not found");
    	}
    	else {
    		Cart updatecart= shoppingrepo.save(cart);
    		return updatecart;
    		
    	}
		
	
	}
		
	
	
}
