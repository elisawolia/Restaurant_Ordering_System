package model;

import java.io.Serializable;

public class FoodItem implements Serializable {
	private static final long serialVersionUID = -8219218627533074108L;

	private int		id;
	private String	itemName;
	private double	size;
	private double	price;
	private String 	icon;
	private String	desc;

	public FoodItem(int id, String itemName, double size, double price, String icon, String desc) {
		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.icon = icon;

		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public String getIcon() {
		return icon;
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
