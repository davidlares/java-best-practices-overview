package com.davidlares.aw.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable {
	
	public int id;
	public int timeViewed;

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public void showData() {
	}
	
	public int getId() {
		return id;
	}
	
	public int getTimeViewed() {
		return timeViewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "	Hello Amazon ToString override Method";
	}
	
	public static ArrayList<Movie> makeMoviesList(){
		ArrayList<Movie> movies = new ArrayList();
		
		for(int a = 0; a < 5; a++) {
			movies.add(new Movie("Movie"+a,"adventure","The creator", 120, (short)(201+a)));
		}
		
		return movies;
	}

	
	// Metodos de Implements
	
	@Override
	public Date startedToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int) (dateF.getTime() - dateI.getTime() ));
		} else {
			setTimeViewed(0);
		}
	}
	
	
	
}
