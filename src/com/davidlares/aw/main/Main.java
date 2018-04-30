package com.davidlares.aw.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.davidlares.aw.model.Chapter;
import com.davidlares.aw.model.Movie;
import com.davidlares.aw.model.Serie;
import com.davidlares.aw.report.Report;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();
	}

	public static void showMenu() {
		
	int exit = 0;
		
		do {
			System.out.println("Welcome to Amazon Viewer");
			System.out.println("");
			System.out.println("Please select a option");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Movies Report");
			System.out.println("0. Exit");
			
		// read user input
		Scanner sc = new Scanner(System.in); // source desde la entrada de texto
		int response = Integer.valueOf(sc.nextLine()); // parsing string to int
		
		switch(response) {
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
			case 0:
				System.out.println("Exit option");
				exit = 0;
				break;
			}
		
		} while (exit != 0);
	}
	
	public static void showMovies() {
		
		int exit = 1;
		
		ArrayList<Movie> movies = Movie.makeMoviesList(); // metodo estatico
		
		do {
			
			System.out.println("");
			System.out.println("Movie List");
			System.out.println("");
			
			for(int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Seen: " + movies.get(i).isViewed());
			}
			
			System.out.println("0. Back to Menu");
			System.out.println("");
			
			// user movie response
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showMenu();
			}
			
			// change movie selected status
			Movie movieSelected = movies.get(response -1);
			movieSelected.setViewed(true);
			
			// catch started date
			Date dateI = movieSelected.startedToSee(new Date());
			
			for(int i = 0; i < 10000; i++) {
				System.out.println("........");
			}
			
			// stopped
			movieSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("Viste: " + movieSelected +  " Por: " + movieSelected.getTimeViewed() + "milliseconds");
			
		}while(exit != 0);
	}
	
	public static void showSeries() {
		
		int exit = 1;
		ArrayList<Serie> series = Serie.makeSeriesList();
		do {
			
			System.out.println("");
			System.out.println("Series List");
			System.out.println("");
			
			for(int i = 0; i < series.size(); i++) {
				System.out.println(i+1 + ". " + series.get(i).getTitle() + " Seen: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Back to Menu");
			System.out.println("");
			
			// user movie response
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showMenu();
			}
			
			showChapters(series.get(response-1).getChapters());
			
			
		}while(exit != 0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 0;
		do {
			
			System.out.println("");
			System.out.println("Chapters List");
			System.out.println("");
			
			for(int i = 0; i < chaptersOfSerieSelected.size(); i++) {
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Seen: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Back to Menu");
			System.out.println("");
			
			// user movie response
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showSeries();
			}
			
			Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startedToSee(new Date());
			
			for(int i = 0; i < 10000; i++) {
				System.out.println("........");
			}
			
			chapterSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("Saw: " + chapterSelected);
			System.out.println("Por: " + chapterSelected.getTimeViewed() + "milliseconds");
			
		}while(exit != 0);
	}
	
	public static void showBooks() {
		int exit = 1;
		do {
			
			System.out.println("");
			System.out.println("Books List");
			System.out.println("Coming Soon");
			System.out.println("");
			
			showMenu();
			
		}while(exit != 0);
	}
	
	public static void showMagazines() {
		int exit = 1;
		do {
			

			System.out.println("");
			System.out.println("Magazines List");
			System.out.println("Coming Soon");
			System.out.println("");
			
			showMenu();
			
		}while(exit != 0);
	}
	
	// Overloading methods
	
	public static void makeReport() {
		
		System.out.println("");
		System.out.println("Generating Report, watch for .txt file");
		
		// creating a txt file 
		Report report = new Report();
		report.setNameFile("report");
		report.setTitle("AW Movie Report");
		report.setExtension("txt");
		
		ArrayList<Movie> movies = Movie.makeMoviesList();
		String content = "";
		for(int i = 0; i < movies.size(); i++) {
			content += "\n Movie: " + movies.get(i).getTitle() + " - Genre: " + movies.get(i).getGenre();
		}
				
		report.setContent(content);
		report.makeReport();
	}
	
	// override method -> unused
	public static void makeReport(Date date) {
		
	}
	
}
