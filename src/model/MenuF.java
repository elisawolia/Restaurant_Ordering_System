package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MenuF {
	private List<FoodItem> menu;

	public MenuF() {
		menu = new LinkedList<FoodItem>();
	}

	public void addItem(FoodItem foodItem) {
		menu.add(foodItem);
	}

	public void addMenu(MenuF newmenu) {
		menu.addAll(newmenu.getMenu());
	}

	public void removeItem(int id) {
		menu.remove(id);
	}

	public List<FoodItem> getMenu() {
		return Collections.unmodifiableList(menu);
	}

	public FoodItem getItem(int id) {
		return menu.get(id);
	}

	public void setMenu(List<FoodItem> fd) {
		menu = fd;
	}

	public int Msize() {
		return menu.size();
	}
}
