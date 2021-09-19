package io.espinoleandroo.java.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.espinoleandroo.java.springboot.bean.MyBean;
import io.espinoleandroo.java.springboot.bean.MyBeanWithDependency;
import io.espinoleandroo.java.springboot.bean.MyBeanWithProperties;
import io.espinoleandroo.java.springboot.component.ComponentDependency;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency beanWithDependency;
	private MyBeanWithProperties beanWithProperties;
	
	public Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency beanWithDependency, MyBeanWithProperties beanWithProperties) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.beanWithDependency = beanWithDependency;
		this.beanWithProperties = beanWithProperties;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		componentDependency.saludar();
		myBean.print();
		beanWithDependency.printWithDependency();
		System.out.println(beanWithProperties.function());
	}

}