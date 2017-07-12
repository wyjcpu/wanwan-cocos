package org.wanwanframework.coco.partition.persistent.impl;

import org.springframework.stereotype.Component;
import org.wanwanframework.coco.partition.persistent.DAO;
import org.wanwanframework.coco.partition.persistent.DataIdDao;

/**
 * DataIdDao dao = session.getMapper(DataIdDao.class);
 * System.out.println(dao.getDataId());
 * 
 * @author coco
 *
 */
@Component
public class DataIdDaoImpl extends DAO<Long> implements DataIdDao {

	private static final String GET_DATAID = "org.wanwanframework.coco.partition.persistent.DataIdDao.getDataId";

	@Override
	public Long getDataId() {
		return get(GET_DATAID);
	}

}
