package springidol.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springidol.TalentCompetition;

public class SpringIdolMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springIdol.xml");

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);

		competition.run();
		ctx.close();
	}
}
