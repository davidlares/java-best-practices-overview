package com.davidlares.aw.model;

import java.util.ArrayList;

public class Serie extends Film {

	private int id;
	private int seasonQuantity;
	private ArrayList<Chapter> chapters;

	public Serie(String title, String genre, String creator, int duration, int seasonQuantity, ArrayList<Chapter> chapters) {
		super(title, genre, creator, duration);
		// TODO Auto-generated constructor stub
		this.seasonQuantity = seasonQuantity;
		this.chapters = chapters;
	}
	
	public int getId() {
		return id;
	}

	public int getSeasonQuantity() {
		return seasonQuantity;
	}

	public void setSeasonQuantity(int seasonQuantity) {
		this.seasonQuantity = seasonQuantity;
	}

	// serie
	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hello Amazon ToString override Method";
	}
	
	public static ArrayList<Serie> makeSeriesList(){
		
		ArrayList<Serie> series = new ArrayList();
		for(int i = 1; i <= 5; i++) {
			series.add(new Serie("Serie " + i, "Genre " + i, "creator" + i, 1200, 5, Chapter.makeChaptersList() ));
		}
		return series;
	}
	
	
	
	
}
