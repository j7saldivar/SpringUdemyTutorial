package com.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/spring/aop/beans.xml");
		
		Camera camera = (Camera)context.getBean("camera");
		camera.snap();
		context.close();
	}

}
