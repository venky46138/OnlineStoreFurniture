package com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Cart;
@Repository
public interface ShoppingCartRepositry extends JpaRepository<Cart,Integer> {
	

}
