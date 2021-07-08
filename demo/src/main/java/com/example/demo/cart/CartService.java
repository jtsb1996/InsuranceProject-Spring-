package com.example.demo.cart;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CartService {
	private final CartRepo cartRepo;
	
	public CartService(CartRepo cartRepo) {
		this.cartRepo = cartRepo;
	}
	
	public List<CartClass> getCartByUserId(int id) {
		return cartRepo.findByUserId(id);
	}
	
	public void removeCartById(int id) {
		cartRepo.deleteById(id);
	}
	
	public void addCart(CartClass cart) {
		cartRepo.save(cart);
	}
	
	public void setPaid(List<CartClass> cart) {
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i).setiPaid("T");
			cartRepo.save(cart.get(i));
		}
	}
	
}
