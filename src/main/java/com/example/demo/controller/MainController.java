package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.classi.Movie;
import com.example.demo.classi.Song;

@Controller
public class MainController {

	@GetMapping("/")
	public String root(Model model) {
		
		model.addAttribute("nome", "antonio");
		
		return "rootView";
		
	}
	
	@GetMapping("/movies")
	public String movies(Model model) {
		
		String film = null;
		
		int count = 1;
		
		for (Movie filmString : getBestMovies()) {
			
			if(count == 1) {
				film = filmString.getTitolo() + ",";
				count++;
			}else if(count != getBestMovies().size()) {

				film += filmString.getTitolo() + ",";
				count++;
				
			}else {
				film += filmString.getTitolo();
				count++;
			}
			
		}
		
		model.addAttribute("film", film);
		
		
		return "movieIndex";
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
		
	String song = null;
		
		int count = 1;
		
		for (Song songString : getBestSongs()) {
			
			if(count == 1) {
				song = songString.getTitolo() + ",";
				count++;
			}else if(count != getBestSongs().size()) {

				song += songString.getTitolo() + ",";
				count++;
				
			}else {
				song += songString.getTitolo();
				count++;
			}
			
		}
		
		model.addAttribute("song", song);
		
		
		return "songIndex";
	}
	
	
	
	private List<Movie> getBestMovies() {
		
		List<Movie> film = new ArrayList<>();
		
		for (int i = 1; i < 4; i++) {
			
			Movie m = new Movie(i, "film" + i);
			
			film.add(m);
			
		}
			
			return film;
		
	}
	
	private List<Song> getBestSongs() {
		
		List<Song> song = new ArrayList<>();
		
		for (int i = 1; i < 4; i++) {
			
			Song s = new Song(i, "canzone" + i);
			
			song.add(s);
			
		}
			
			return song;
		
	}
	
	
	@GetMapping("/movies/{id}")
	public String moviesId(Model model,@PathVariable("id") int id) {
		
		Movie movie = getBestMovies().get(id - 1);
		
		model.addAttribute("film", movie);
		
		return "movieId";
		
	}
	
	@GetMapping("/songs/{id}")
	public String songsId(Model model,@PathVariable("id") int id) {
		
		Song song = getBestSongs().get(id - 1);
		
		model.addAttribute("song", song);
		
		return "songId";
		
	}
	
	
	
	
	
	
}
