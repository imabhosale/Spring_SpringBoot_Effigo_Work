package com.in28minutes.learn_spring_framework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@Configuration
public class RealWorldSpringContextLauncherApp {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApp.class)) {
			RealWorldSpringContextLauncherApp service = context.getBean(RealWorldSpringContextLauncherApp.class);
		//	System.out.println(service.findMax());

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
