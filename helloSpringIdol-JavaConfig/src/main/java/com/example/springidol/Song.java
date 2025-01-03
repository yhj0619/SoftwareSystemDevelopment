package com.example.springidol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Song {
	@Value("${lena.song.title}")
	private String title;
	
	@Value("${lena.song.artist}")
	private String artist;

	public Song() {
	}

	public Song(String title) {
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
}
