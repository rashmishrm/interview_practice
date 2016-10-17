package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class GreedyScheduling {

	public static List<Movie> schedule(List<Movie> movies){
		 List<Movie> scheduled= new ArrayList<Movie>();
		
		 movies.sort(new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.end.compareTo(o2.end);
			}
			 
			 
		});
		 
		 System.out.println(movies);
		 scheduled.add(movies.get(0));
		 Movie previous = movies.get(0);
		 for(int i=1;i<movies.size();i++){
			 if(movies.get(i).start.compareTo(previous.end)>=0){
				 scheduled.add(movies.get(i));
				 previous=movies.get(i);
			 }
			 
			 
		 }
		 
		 
		 
		 return scheduled;
		
	}
	
	
	public static void main(String[] args) {
		List<Movie> movies= new ArrayList<Movie>();
		movies.add(new Movie(new Date("21/01/2016 10:00:00"), new Date("21/01/2016 10:45:00") , "A"));
		movies.add(new Movie(new Date("21/01/2016 10:30:00"), new Date("21/01/2016 11:45:00") , "B"));
		movies.add(new Movie(new Date("21/01/2016 12:00:00"), new Date("21/01/2016 12:45:00") , "C"));

		
		System.out.println(schedule(movies));
	}
	
}

class Movie{
	public Date start;
	public Date end;
	public String name;
	public Movie(Date start, Date end, String name) {
		super();
		this.start = start;
		this.end = end;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
}
