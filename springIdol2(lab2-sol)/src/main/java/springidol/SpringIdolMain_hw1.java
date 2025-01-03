package springidol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolMain_hw1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springIdol-hw1.xml");

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();
		
		Encore encore = ctx.getBean("encore", Encore.class);
		encore.execute();
		
		ctx.close(); 
	}
}
