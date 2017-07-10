package org.wanwanframework.coco.core;

import static org.junit.Assert.assertTrue;

import java.util.List;

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

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
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
		Log.log("jdbcTemplate:" + jdbcTemplate);

		String sql = "CREATE TABLE USER " + 
		"(ID 			INT	PRIMARY KEY	NOT NULL," + 
		" USERNAME	TEXT    		NOT NULL," + 
		" PASSWORD	TEXT    		NOT NULL)";
		jdbcTemplate.execute(sql);
	}
	
	@Test
	public void testInsert() {
		String sql = "insert into USER (ID, USERNAME, PASSWORD) values (1, 'vv', '123456')";
		jdbcTemplate.execute(sql);
	}
	
	@Test
	public void testQuery() {
		List<?> map = jdbcTemplate.queryForList(
				"select * from USER where username ='vv'");
		Log.log(map);
	}
}
