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
	private int typeCategory;

	public FoodItem(int id, String itemName, double size, double price, String icon, String desc) {
		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.icon = icon;
		this.desc = desc;

		this.id = id;
	}

	public  FoodItem(String itemName, double size, double price, int typeCat, String desc, String icon) {
		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.icon = icon;
		this.desc = desc;
		this.typeCategory = typeCat;
	}

	public FoodItem(int id, String itemName, double size, double price) {
		this.itemName = itemName;
		this.size = size;
		this.price = price;

		this.id = id;
	}

	public int getTypeCategory() {
		return typeCategory;
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
