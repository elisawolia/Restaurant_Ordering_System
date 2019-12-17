package gui;

import java.util.EventObject;

public class OrdEvent extends EventObject {
	private int		id;
	private String	itemName;
	private double	size;
	private double	price;
	private int		typeCat;
	private String	desc;
	private String	icon;

	public OrdEvent(Object source) {
		super(source);
	}

	public OrdEvent(Object source, int id, String itemName, double size, double price) {
		super(source);

		this.id = id;
		this.itemName = itemName;
		this.size = size;
		this.price = price;
	}

	public OrdEvent(Object source, String itemName, double size, double price, int typeCat, String desc, String path)
	{
		super(source);

		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.typeCat = typeCat;
		this.desc = desc;
		this.icon = path;
	}

	public String getIcon() {
		return icon;
	}

	public int getId() {
		return id;
	}

	public int getTypeCat() {
		return typeCat;
	}

	public String getDesc() {
		return desc;
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
