package com.bytemeagain.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanDriver {

	public static void main(String[] args) {
		//Refer to the following link to get various other implementations of ApplicationContext
		//http://docs.spring.io/spring/docs/3.0.x/api/org/springframework/context/ApplicationContext.html
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-bean-config.xml");
 
		Employee obj = (Employee) context.getBean("shashi_employee");
		System.out.println(obj);
	}

}
