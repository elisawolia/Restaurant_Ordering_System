package model;

import java.util.LinkedList;

public class AllIngred {
	private LinkedList<Ingredient> ingredients;

	public AllIngred() {
		ingredients = new LinkedList<>();
	}

	public String[] getIngredientsNames() {
		String[] names = new String[ingredients.size()];
		for (int i = 0; i < ingredients.size(); i++){
			names[i] = ingredients.get(i).getIngred();
		}
		return names;
	}

	public void addIngred(Ingredient ingredient) {
		ingredients.add(ingredient);
	}
}
