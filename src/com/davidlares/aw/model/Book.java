package com.davidlares.aw.model;

import java.util.Date;

public class Book extends Publication implements IVisualizable {
	
	private int id;
	private String isbn;
	private boolean read;
	private int timeRead;
	
	public Book(String title, Date editionDate, String editorial, String[] authors) {
		super(title, editionDate, editorial, authors);
		// TODO Auto-generated constructor stub
		this.isbn = isbn;
		this.read = read;
		this.timeRead = timeRead;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public int getTimeRead() {
		return timeRead;
	}

	public void setTimeRead(int timeRead) {
		this.timeRead = timeRead;
	}

	@Override
	public Date startedToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getSeconds() > dateI.getSeconds()) {
			setTimeRead(dateF.getSeconds() - dateI.getSeconds());
		} else {
			setTimeRead(0);
		}
	}
	
}
