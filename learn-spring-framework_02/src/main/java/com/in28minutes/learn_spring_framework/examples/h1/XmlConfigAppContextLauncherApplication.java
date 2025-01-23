package com.in28minutes.learn_spring_framework.examples.h1;

import java.util.Arrays;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learn_spring_framework.game.GameRunner;

@Configuration
@ComponentScan
public class XmlConfigAppContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = 
				new ClassPathXmlApplicationContext("ContextConfiguration.xml")) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
				
			context.getBean(GameRunner.class).run();			
			
		}
	}

}
