package com.example.demo.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {

	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	public List<CartClass> getCartByUserId(int id) {
		return cartService.getCartByUserId(id);
	}
	
	public void removeCartById(int id) {
		cartService.removeCartById(id);
	}
	
	public void addCart(CartClass cart) {
		cartService.addCart(cart);
	}
	
	public void setPaid(List<CartClass> cart) {
		cartService.setPaid(cart);
	}
} 
