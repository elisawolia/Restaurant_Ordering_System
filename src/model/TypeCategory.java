package model;

public class TypeCategory {
	private String text;
	private int id;

	public TypeCategory(int id, String text) {
		this.text = text;
		this.id = id;
	}

	public String toString() {
		return text;
	}

	public int getId() {
		return id;
	}
}
