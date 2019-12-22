package controller;

import gui.IngredEvent;
import model.AllIngred;
import model.Database;
import model.Ingredient;

public class ControllerIngred {
	private Database DB = new Database();
	private AllIngred ingres;

	public ControllerIngred() {
		ingres = DB.getIngreds();
	}
	public void addIngred(IngredEvent e){
		String ingred = e.getIngred();
		Double price = e.getPrice();
		Double left = e.getLeft();

		Ingredient ingredient = new Ingredient(ingred, price, left);
		DB.newIngred(ingredient);
	}

	public void updateIngred(IngredEvent e) {
		int id = e.getId();
		double left = e.getLeft();

		Ingredient ingredient = new Ingredient(id, left);
		DB.updateIngred(ingredient);
	}

	public String[] getNames() {
		return ingres.getIngredientsNames();
	}
}
