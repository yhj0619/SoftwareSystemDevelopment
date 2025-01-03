package springidol;

public class Singer implements Performer {
	private String name;
	private Song song;
	private Instrument instrument;
	
	public Singer() {}

	public Singer(String name, Song song) {
		this.name = name;
		this.song = song;
	}

	public Singer(String name, Song song, Instrument instr) {
		this.name = name;
		this.song = song;
		this.instrument = instr;
	}
	
	public Song getSong() {
		return song;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + " is singing a song \"" + song.getTitle() 
								+ "\" by " + song.getArtist());
		if (this.instrument != null) {
			System.out.print("while playing " + instrument.getClass().getSimpleName() + " ");
			instrument.play();
		}
	}
}
