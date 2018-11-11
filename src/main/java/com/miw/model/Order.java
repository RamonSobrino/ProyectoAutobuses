package com.miw.model;

public class Order {

	private Book book;
	private Integer number;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Order [book=" + book + ", number=" + number + "]";
	}
	
}
