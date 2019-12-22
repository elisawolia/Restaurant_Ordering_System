package model;

import javax.swing.*;

public class Ingredient {
	private int id;
	private String ingred;
	private double price;
	private double left;

	public Ingredient(){
	};

	public Ingredient(int id, String ingred, double price, double left) {
		this.id = id;
		this.ingred = ingred;
		this.price = price;
		this.left = left;
	}

	public Ingredient(int id, double left) {
		this.id = id;
		this.left = left;
	}

	public Ingredient(String ingred, double price, double left) {
		this.ingred = ingred;
		this.price = price;
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
