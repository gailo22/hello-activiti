package com.gailo22.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SimpleProcessTest {

	@Test
	public void startBookOrder() {
		final ProcessEngine processEngine = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration()
				.buildProcessEngine(); 

		final RuntimeService runtimeService = processEngine.getRuntimeService(); 
		final RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment()
		.addClasspathResource("hello/hello.simple.bpmn20.xml")
		.deploy();

		final ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
"simpleprocess");
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " " 
				+ processInstance.getProcessDefinitionId());
	}

}
