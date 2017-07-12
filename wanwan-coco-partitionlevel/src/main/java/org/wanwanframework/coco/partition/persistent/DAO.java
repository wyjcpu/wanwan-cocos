package org.wanwanframework.coco.partition.persistent;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

//import cn.iot.m2m.bisserver.common.DAOException;
//import cn.iot.m2m.bisserver.common.support.OurSearchBean;
//import cn.iot.m2m.bisserver.common.support.Page;
/**
 * Created by IntelliJ IDEA.
 * User: liuguo
 * Date: 12-2-9
 * Time: 上午10:46
 * <p/>
 * MyBatis对数据库操作CRUD通用操作类
 * <p/>
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class DAO<T> extends AstractSqlSessionDaoSupport {

    private final Logger logger = LoggerFactory.getLogger(DAO.class);

    /**
     * 保存新增的对象
     *
     * @param key
     * @param object
     */
    public void save(String key, Object object) {
        try {
            Assert.notNull(object, "object saved is not null.");
            getSqlSession().insert(key, object);
            logger.debug("save key: {}, object: {}", key, object);
        } catch (DataAccessException e) {
            logger.error("save error", e);
        }
    }

    /**
     * 按照ID删除对象
     *
     * @param key
     * @param id
     */
    public void delete(String key, Serializable id) {
        try {
            logger.debug("delete key: {}, id: {}", key, id);
            getSqlSession().delete(key, id);
        } catch (DataAccessException e) {
            logger.error("delete by id error", e);
        }
    }

    /**
     * 删除对象
     *
     * @param key
     * @param object
     */
    public void delete(String key, Object object) {
        try {
            logger.debug("delete key: {}, object: {}", key, object);
            getSqlSession().delete(key, object);
        } catch (DataAccessException e) {
            logger.error("delete error", e);

        }
    }

    /**
     * 按照条件删除对象
     *
     * @param key
     * @param conditionMap
     */
    public void delete(final String key, final Map<String, Object> conditionMap) {
        try {
        	logger.debug("delete key:{} conditionMap:{}", key, conditionMap);
            getSqlSession().delete(key, conditionMap);
        } catch (DataAccessException e) {
            logger.error("delete error", e);

        }
    }

    /**
     * 更新对象
     *
     * @param key
     * @param object
     */
    public void update(String key, Object object) {
        try {
            logger.debug("update key: {}, object: {}", key, object);
            getSqlSession().update(key, object);
        } catch (DataAccessException e) {
            logger.error("update error", e);

        }
    }

    /**
     * 获取某一个对象
     *
     * @param key
     * @param param
     * @return
     */

	public T get(final String key, final Object param) {
        logger.debug("get key:{} param:{}", key, param);
        try {
            return (T) getSqlSession().selectOne(key, param);
        } catch (DataAccessException e) {
            logger.error("get error：", e);

        }
		return null;
    }

    /**
     * 获取某一个对象
     *
     * @param key
     * @param paramMap
     * @return
     */
    public T get(final String key, final Map<String, Object> paramMap) {
        logger.debug("get key:{} paramMap:{}", key, paramMap);
        try {
            return (T) getSqlSession().selectOne(key, paramMap);
        } catch (DataAccessException e) {
            logger.error("get error", e);

        }
		return null;
    }

    /**
     * 获取某一个对象
     * <p/>
     *
     * @param key
     * @return
     */
    public T get(String key) {
        try {
            logger.debug("getList key{}", key);
            return (T) getSqlSession().selectOne(key);
        } catch (DataAccessException e) {
            logger.error("getList get key error", e);

        }
		return null;
    }

    /**
     * 使用select count(1)的方式判断对象的属性值在数据库内是否唯一.
     * <p/>
     * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
     * <p/>
     *
     * @param key
     * @param propertyName
     * @param newValue
     * @param oldValue
     * @return
     */
    public boolean checkPropertyValueUnique(
            final String key, final String propertyName, final Object newValue, final Object oldValue) {
        if (newValue == null || newValue.equals(oldValue)) {
            return true;
        }
        Long object = null;
        try {
            Map<String, Object> proprtyMap = new HashMap<>();
            proprtyMap.put(propertyName, newValue);
            object = (Long) getSqlSession().selectOne(key, proprtyMap);
        } catch (DataAccessException e) {
            logger.error("checkPropertyValueUnique error", e);

        }
        return object == 0L;
    }

    /**
     * 不支持分页
     * <p/>
     * 查询所有的对象，建议在查询的数据量比较少的时候可以使用该方法
     *
     * @param key
     * @return
     */
    public List<T> getList(String key) {
        try {
            logger.debug("getList key{}", key);
            return getSqlSession().selectList(key);
        } catch (DataAccessException e) {
            logger.error("getList error is :", e);

        }
		return null;
    }

    /**
     * 使用序列化之后的bean查询列表
     *
     * @param key
     * @param serializable
     * @return
     */
    public List<T> getList(String key, Serializable serializable) {
        try {
            logger.debug("getList key{},serializable{}", key, serializable);
            return getSqlSession().selectList(key, serializable);
        } catch (DataAccessException e) {
            logger.error("getList error", e);

        }
		return null;
    }

    /**
     * 不支持分页
     * <p/>
     * 按照查询条件查询数据，建议在查询的数据量比较少的时候可以使用该方法
     *
     * @param key
     * @param param
     * @return
     */
    public List<T> getList(String key, final Object param) {
        logger.debug("getList key{},param{}", key, param);
        try {
            return getSqlSession().selectList(key, param);
        } catch (DataAccessException e) {
            logger.error("getList error", e);

        }
		return null;
    }

    /**
     * @param key
     * @param paramMap
     * @return
     */
    public List<T> getList(String key, final Map<String, Object> paramMap) {
        logger.debug("getList key{},paramMap{}", key, paramMap);
        try {
            return getSqlSession().selectList(key, paramMap);
        } catch (DataAccessException e) {
            logger.error("getList error {}", e);

        }
		return null;
    }

    /**
     *
     * 根据查询条件获取数据库中数据量
     *
     * @author wangmin
     * @see [类、类#方法、类#成员]
     * @param key
     * @param params
     * @return
     */
    public long getTotalCount(final String key, final Object... params) {
        try {
            Map<String, Object> paramMap = fillConditionMap(params);
            logger.debug("getList key {},paramMap {}", key, paramMap);
            return (Long) getSqlSession().selectOne(key, paramMap);
        } catch (DataAccessException e) {
            logger.error("getTotalCount error", e);

        }
		return 0;
    }

    /**
     *
     * 根据查询条件获取数据库中数据量
     *
     * @author chengtao
     * @see [类、类#方法、类#成员]
     * @param key
     * @param paramMap
     * @return
     */
    public long getCount(final String key, final Map<?,?> paramMap) {
        try {
            logger.debug("getList key {},paramMap {}", key, paramMap);
            return (Long) getSqlSession().selectOne(key, paramMap);
        } catch (DataAccessException e) {
            logger.error("getCount error", e);

        }
		return 0;
    }

//    /**
//     * 根据参数获取总记录数
//     *
//     * @param
//     * @return
//     * @author 曾宪盛
//     * @UserStory
//     */
//    protected long getTotalCount(String key, OurSearchBean searchBean) {
//        return (Long) getSqlSession().selectOne(key, searchBean);
//    }

    /**
     * 默认使用的分页查询方法
     *
     * @param countKey
     * @param pageKey
     * @param searchBean
     * @return
     */
//    public Page<T> findPage(final String countKey, final String pageKey, final OurSearchBean searchBean) {
//        Page page = null;
//        try {
//            page = searchBean.getPage();
//            //获取总记录数
//            long totalCount = getTotalCount(countKey, searchBean);
//            List<T> resultList = new ArrayList<>();
//            if(totalCount > 0) {
//                resultList = getSqlSession().selectList(pageKey, searchBean);
//            }
//            page.setCurrentPageResult(resultList);
//            page.setTotalCount(totalCount);
//
//        } catch (DataAccessException e) {
////            logger.error("findPage error:", e.getMessage());
////            throw new DAOException(e);
//        }
//        return page;
//    }
    /**
     * 封装普通查询条件
     *
     * @param
     * @return
     */
    private Map<String, Object> fillConditionMap(final Object[] params) {
        Map<String, Object> paramMap = new HashMap<>();
        int index = 0;
        for (Object param : params) {
            paramMap.put(Integer.toString(index++), param);
        }
        return paramMap;
    }

    /**
     * 封装普通查询条件供其子类使用
     *
     * @param params
     * @return
     */
    protected Map<String, Object> fillConditionMapByObjects(Object... params) {
        return fillConditionMap(params);
    }

    /**
     * 获取序列值 主要用于序列号前面追加时间戳的格式 例如：yyyyMMdd+seqID ，
     * <p/>
     * 如果直接获取序列编码可以使用方法 @see getSeqValueByName()，省去定义Mapper中的SQL
     *
     * @param key
     * @return 序列值
     */
    public String getSeqValue(String key) {
        logger.error("getSeqValue key:{}", key);
        try {
            return (String) getSqlSession().selectOne(key);
        } catch (DataAccessException e) {
            logger.error("getSeqValue error:{}", e);

        }
		return null;
    }


    protected void closeDatabaseSource(Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.error("resultset close error", e);
        } finally {
            closeStatement(st);
        }
    }

    private void closeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            logger.error("statement close error", e);
        }
    }
}
