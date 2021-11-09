package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.exception.ShoppingCartException;
import com.services.ShoppingCartServicesInterface;

@RestController
@RequestMapping("/api/showCart")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartServicesInterface shoppingcart;
	
	@GetMapping(path="/getAllCarts")
	public ResponseEntity<List<Cart>> getAllCarts() throws ShoppingCartException{
		List<Cart> resultcart=  shoppingcart.getAllCarts();
		return new ResponseEntity<List<Cart>>(resultcart,HttpStatus.OK);
	}
	
	@GetMapping(path="/getCartById")
	public ResponseEntity<Object> getCartById(@PathVariable int cartId) throws ShoppingCartException{
		Cart resultcart;
		try {
			resultcart= shoppingcart.getCartById(cartId);
			return new ResponseEntity<Object>(resultcart,HttpStatus.OK);
		}
		catch(ShoppingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
		}	
	}
	
	@PutMapping(path="/updateCart")
	public ResponseEntity<Object> updateCart(@PathVariable Cart cart) throws ShoppingCartException{
		Cart resultcart;
		try {
			resultcart= shoppingcart.updateCart(cart);
			return new ResponseEntity<Object>(resultcart,HttpStatus.OK);
		}
		catch(ShoppingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
		}
		
	}
	@PutMapping(path="/updateCartById/{cartId}")
	public ResponseEntity<Object> updateCartById(@RequestBody Cart cart) throws ShoppingCartException{
		Cart updatecart;
		try {
			updatecart= shoppingcart.updateCartById(cart.getCartId(),cart);
			return new ResponseEntity<Object>(updatecart,HttpStatus.OK);
		}
		catch(ShoppingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
		}
	}
	@DeleteMapping(path="/deleteCart")
	public ResponseEntity<Object> deleteCart(@PathVariable Cart cart) throws ShoppingCartException{
              try {
            	  return new ResponseEntity<Object>(shoppingcart.deleteCart(cart),HttpStatus.OK);
              }
              catch(ShoppingCartException e) {
            	  return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
              }
	}
	@DeleteMapping(path="/deleteCartById/{cartId}")
	public ResponseEntity<Object> deleteCartById(@PathVariable int cartId) throws ShoppingCartException{
		 try {
       	  return new ResponseEntity<Object>(shoppingcart.deleteCartById(cartId),HttpStatus.OK);
         }
         catch(ShoppingCartException e) {
       	  return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
         }
	}
}
