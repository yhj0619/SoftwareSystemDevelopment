package springidol.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {
  @Value("STRUM STRUM STRUM")
  private String sound;
  
  public Guitar() {}
  
  public void play() {
    System.out.println(sound);
  }
}
