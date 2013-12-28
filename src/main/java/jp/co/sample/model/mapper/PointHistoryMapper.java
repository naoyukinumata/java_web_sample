package jp.co.sample.model.mapper;

import java.util.List;

import jp.co.sample.model.PointHistory;

public interface PointHistoryMapper {
	List<PointHistory> selectByUserId(Integer user_id);
	void insert(PointHistory pointHistory);
}
