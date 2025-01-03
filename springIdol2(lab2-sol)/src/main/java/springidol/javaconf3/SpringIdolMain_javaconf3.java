package springidol.javaconf3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import springidol.Encore;
import springidol.TalentCompetition;

public class SpringIdolMain_javaconf3 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConf3.class, SpringConf4.class);

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();		
		Encore encore = ctx.getBean("encore", Encore.class);
		encore.execute();

		ctx.close();
	}
}
