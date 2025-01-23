package com.in28minutes.learn_spring_framework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;import org.w3c.dom.ls.LSOutput;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	SomeDependency someDependency;
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency=someDependency;
		System.out.println("All dependencies are ready !");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("Cleanup");
	}
}

@Component
class SomeDependency {

	public void getReady() {
		System.out.println("some logic using that dependency");		
	}

}

@Configuration
@ComponentScan
public class PrepostAnotaionContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PrepostAnotaionContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		}
	}

}
