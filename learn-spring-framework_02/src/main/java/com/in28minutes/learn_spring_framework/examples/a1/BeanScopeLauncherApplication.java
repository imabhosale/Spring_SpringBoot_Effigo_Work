package com.in28minutes.learn_spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{
	
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class ProtoTypeClass{
	
}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)) {
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));

			System.out.println(context.getBean(ProtoTypeClass.class));
			System.out.println(context.getBean(ProtoTypeClass.class));
			System.out.println(context.getBean(ProtoTypeClass.class));

		}
	}

}
