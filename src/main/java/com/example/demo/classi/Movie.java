package com.example.demo.classi;

public class Movie {
	
	private Integer id;
	private String titolo;
	public Movie(Integer id, String titolo) {
		
		this.id = id;
		this.titolo = titolo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", titolo=" + titolo + "]";
	}
	
	
	
}
