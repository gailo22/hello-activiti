package com.gailo22.activiti.spring;

import org.activiti.engine.delegate.DelegateExecution;

public class HelloService {

	public void sayHello(final DelegateExecution execution) {
		System.out.println("say hello:  " + execution.getVariable("name"));
	}

}
