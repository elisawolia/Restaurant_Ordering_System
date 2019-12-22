package gui;

import java.util.EventObject;

public class IngredEvent extends EventObject {
	private int id;
	private String ingred;
	private double price;
	private double left;

	public IngredEvent(Object source) {
		super(source);
	}

	public IngredEvent(Object source, String ingred, double price, double left) {
		super(source);

		this.ingred = ingred;
		this.price = price;
		this.left = left;
	}

	public IngredEvent(Object source, int id, double left) {
		super(source);

		this.id = id;
		this.left = left;
	}

	public int getId() {
		return id;
	}

	public String getIngred() {
		return ingred;
	}

	public double getPrice() {
		return price;
	}

	public double getLeft() {
		return left;
	}
}
