package com.gailo22.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application-context-test.xml")
public class SpringTest {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Test
	public void simpleProcessTest() {
		final Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Jonh");
		this.runtimeService.startProcessInstanceByKey("simpleSpringProcess", variableMap);
		final Task task = this.taskService.createTaskQuery().singleResult();
		assertEquals("Police confirm", task.getName());
		this.taskService.complete(task.getId());
		assertEquals(0, this.runtimeService.createProcessInstanceQuery().count());
	}
}
