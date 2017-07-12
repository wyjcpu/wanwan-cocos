package org.wanwanframework.coco.core;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wanwanframwork.file.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/context-datasource.xml" })
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testDataSource() {
		assertTrue(dataSource != null);
		Log.log("druidDataSource:" + dataSource);
	}
	
	@Test
	public void testJdbcTemplate() {
		assertTrue(jdbcTemplate != null);
		Log.log("jdbcTemplate:" + jdbcTemplate);
		Date r = jdbcTemplate.queryForObject("select sysdate from dual", Date.class);
		Log.log(r);
	}
}
