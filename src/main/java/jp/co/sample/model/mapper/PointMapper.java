package jp.co.sample.model.mapper;

import java.util.List;

import jp.co.sample.model.Point;

public interface PointMapper {
	List<Point> selectAll();
	Point selectByUserId(Integer user_id);
	void insert(Point point);
	void update(Point point);
}
