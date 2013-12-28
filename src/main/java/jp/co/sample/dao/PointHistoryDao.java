package jp.co.sample.dao;

import java.util.List;

import jp.co.sample.model.Point;
import jp.co.sample.model.PointHistory;
import jp.co.sample.model.mapper.PointHistoryMapper;
import jp.co.sample.model.mapper.PointMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PointHistoryDao {
	private SqlSessionFactory sessionFactory;

	public PointHistoryDao() {
		sessionFactory = DaoUtil.getSqlSessionFactory();
	}

	public List<PointHistory> selectByUserId(Integer user_id) {
		SqlSession session = sessionFactory.openSession();
		PointHistoryMapper mapper = session.getMapper(PointHistoryMapper.class);
		List<PointHistory> list = mapper.selectByUserId(user_id);
		session.close();

		return list;
	}

	public void insert(Integer id, Integer user_id, Integer point) {
		SqlSession session = sessionFactory.openSession();
		PointHistoryMapper mapper = session.getMapper(PointHistoryMapper.class);
		PointHistory obj = new PointHistory();
		obj.setId(id);
		obj.setUser_id(user_id);
		obj.setPoint(point);
		mapper.insert(obj);
		session.commit();
		session.close();
	}
}
