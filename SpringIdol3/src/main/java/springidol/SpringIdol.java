package springidol;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringIdol implements TalentCompetition {
	@Autowired
	private Performer[] performers;
	
	public SpringIdol() {}
	
	public Performer[] getPerformers() {
		return this.performers;
	}

	public void setPerformers(Performer[] performers) {
		this.performers = performers;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < performers.length; i++) {
			System.out.print("Performance #" + (i+1));
			Performer performer = performers[i];
			if (performer.getBeanName() != null)
				System.out.print(" by " + performer.getBeanName());
			System.out.println();
			performer.perform();
			System.out.println("-----------------------");
		}
	}
}
