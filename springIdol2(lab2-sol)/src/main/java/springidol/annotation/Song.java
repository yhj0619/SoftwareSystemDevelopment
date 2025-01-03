package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("someone")
public class Song {
  private String title;
  private String artist;

  public Song() { }
  
  @Autowired
  public Song(@Value("Someone Like You") String title, 
		  @Value("Adele") String artist) {
	this.title = title;
	this.artist = artist;
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
