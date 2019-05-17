package com.zz.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1. ����Spring��IOC����
		ApplicationContext ac = new ClassPathXmlApplicationContext("zzapplicationContext.xml");
		
		//2. ��IOC�����л�ȡbean��ʵ��
		ArithmeticCalculator arithmeticCalculator = ac.getBean(ArithmeticCalculator.class);
		
		//3.ʹ��bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result:"+result);
		
		result = arithmeticCalculator.add(12, 6);
		System.out.println("result:"+result);
	}
}
