package main.java.errors.massages;

public class FieldIsEmptyMessage extends Message {
	public FieldIsEmptyMessage(String field) {
		super(String.format("%s cannot be empty.", field));
	}
}
