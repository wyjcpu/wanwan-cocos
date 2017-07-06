package org.wanwanframework.coco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wanwanframework.coco.partition.controller.PartitionController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-servlet.xml" })
public class MvcTest {
	
	@Autowired
	private PartitionController controller;
	
	@Test
	public void testSession() throws Exception {
		System.out.println("controller:" + controller.getId());
	}
}
