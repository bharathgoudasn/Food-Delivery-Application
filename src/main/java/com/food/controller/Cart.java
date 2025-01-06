package com.food.controller;


import java.util.HashMap;
import java.util.Map;

import com.food.model.CartItem;

public class Cart {

	public static Map<Integer,CartItem> items;
	
	public Cart() {
		this.items=new HashMap<Integer,CartItem>();
	}
	
	public void addItem(CartItem item) {
		int itemId=item.getItemid();
		if(items.containsKey(itemId))
		{
			CartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
		}
		else {
			items.put(itemId, item);
		}
	}
	
	public void updateItem(int itemId,int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity<=0) {
				items.remove(itemId);
			}
			else {
				CartItem existingItem = items.get(itemId);
				existingItem.setQuantity(quantity);
			}
		}
	}
	
	public void removeItem(int itemId) {
		items.remove(itemId);
	}
	
	public Map<Integer,CartItem> getItems()
	{
		return items;
	}
	
	
	public void clear()
	{
		items.clear();
	}
	
	
	

	
	
	}
	


