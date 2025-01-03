package springidol.javaconf2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import springidol.Encore;
import springidol.TalentCompetition;

public class SpringIdolMain_javaconf2 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConf1.class, SpringConf2.class);

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();		
		Encore encore = ctx.getBean("encore", Encore.class);
		encore.execute();

		ctx.close();
	}
}
