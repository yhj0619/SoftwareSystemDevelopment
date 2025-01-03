package springidol;

public class Singer implements Performer {
	private String name;
	private Song song;

	public Singer() {
	}

	public Singer(String name) {
		this.name = name;
	}

	public Singer(String name, Song song) {
		this.song = song;
		this.name = name;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println(this.name + " is singing a song \"" + this.song.getTitle() + "\""
							+ " by " + this.song.getArtist());
	}
}
