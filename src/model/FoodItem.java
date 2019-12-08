package model;

import java.io.Serializable;

public class FoodItem implements Serializable {
	private static final long serialVersionUID = -8219218627533074108L;

	private static int count = 0;
	private int		id;
	private String	itemName;
	private double	size;
	private double	price;

	public FoodItem(String itemName, double size, double price) {
		this.itemName = itemName;
		this.size = size;
		this.price = price;

		this.id = count;
		count++;
	}

	public int getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public double getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}
}
