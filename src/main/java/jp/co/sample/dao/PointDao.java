package jp.co.sample.dao;

import jp.co.sample.model.Point;
import jp.co.sample.model.mapper.PointMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PointDao {
	private SqlSessionFactory sessionFactory;

	public PointDao() {
		sessionFactory = DaoUtil.getSqlSessionFactory();
	}

	public Point selectByUserId(Integer user_id) {
		SqlSession session = sessionFactory.openSession();
		PointMapper mapper = session.getMapper(PointMapper.class);
		Point point = mapper.selectByUserId(user_id);
		session.close();

		return point;
	}

	public void insert(Integer id, Integer user_id, Integer point) {
		SqlSession session = sessionFactory.openSession();
		PointMapper mapper = session.getMapper(PointMapper.class);
		Point obj = new Point();
		obj.setId(id);
		obj.setUser_id(user_id);
		obj.setPoint(point);
		mapper.insert(obj);
		session.commit();
		session.close();
	}

	public void update(Integer id, Integer user_id, Integer point) {
		SqlSession session = sessionFactory.openSession();
		PointMapper mapper = session.getMapper(PointMapper.class);
		Point obj = new Point();
		obj.setId(id);
		obj.setUser_id(user_id);
		obj.setPoint(point);
		mapper.update(obj);
		session.commit();
		session.close();
	}
}
