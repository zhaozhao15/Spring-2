package com.zz.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP �� helloWorld
 * 1. ���� jar ��
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 * spring-aspects-4.0.0.RELEASE.jar
 * 
 * 2. �� Spring �������ļ��м��� aop �������ռ䡣 
 * 
 * 3. ����ע��ķ�ʽ��ʹ�� AOP
 * 3.1 �������ļ��������Զ�ɨ��İ�: <context:component-scan base-package="com.zz.spring.aop.impl"></context:component-scan>
 * 		
 * 3.2 ����ʹ AspjectJ ע�������õ�����: <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 * Ϊƥ������Զ����ɶ�̬�������. 
 * 
 * 4. ��д������: 
 * 4.1 һ��һ��� Java ��
 * 4.2 ���������Ҫ����ʵ�ֵĹ���. 
 *
 * 5. ��������
 * �Ѻ��й�ע��Ĵ���������������
 * 5.1 ��������� IOC �е� bean: ʵ������� @Component ע��
 * 5.2 ������һ������: ��� @Aspect
 * 5.3 ����֪ͨ: ��������빦�ܶ�Ӧ�ķ���. 
 * 5.3.1 ǰ��֪ͨ: @Before("execution(public int com.zz.spring.aop.impl.ArithmeticCalculator.*(int, int))")
 * @Before ��ʾ��Ŀ�귽��ִ��֮ǰִ�� @Before ��ǵķ����ķ�����. 
 * @Before ��������������ʽ: 
 * 
 * 6. ��֪ͨ�з�������ϸ��: ������֪ͨ��������� JoinPoint ���͵Ĳ���, ���п��Է��ʵ�������ǩ���ͷ����Ĳ���. 
 * 
 * 7. @After ��ʾ����֪ͨ: �ڷ���ִ��֮��ִ�еĴ���. 
 */

//�����������Ϊһ�����棺������Ҫ�Ѹ������IOC�����У�������Ϊһ������
//ͨ����� @Aspect ע������һ�� bean ��һ������!
@Aspect
@Component
public class LoggingAspect {
	
	//�����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	@Before("execution(public int com.zz.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	//����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣����ִ�е�֪ͨ
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("execution(* com.zz.spring.aop.impl.*.*(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
}
