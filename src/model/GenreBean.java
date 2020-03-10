package model;

import java.io.Serializable;

public class GenreBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int genreId;
	private String genreName;
	public GenreBean() {};

	public GenreBean(int genreId,String genreName) {
		this.genreId = genreId;
		this.genreName = genreName;
	}

	//getter setter
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
