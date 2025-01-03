package springidol.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringIdolMain_annotation {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();
		
		Encore encore = ctx.getBean("encore", Encore.class);
		encore.execute();
		
		ctx.close();
	}
}
