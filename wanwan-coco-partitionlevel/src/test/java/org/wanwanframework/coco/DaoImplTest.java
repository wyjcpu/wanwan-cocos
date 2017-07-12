package org.wanwanframework.coco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wanwanframework.coco.partition.persistent.DataIdDao;
import org.wanwanframwork.file.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/context-mybatis.xml" })
public class DaoImplTest {

	@Autowired
	DataIdDao dao;
	
	@Test
	public void testDao() {
		long id = dao.getDataId();
		Log.log(id);
	}
}
