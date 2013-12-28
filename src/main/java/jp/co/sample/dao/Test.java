package jp.co.sample.dao;

import jp.co.sample.model.Point;

public class Test {
	public static void main(String[] args) {

		Integer user_id = 4;
		Point point = new PointDao().selectByUserId(user_id);
		System.out.println("result ===>" + point);
		if (point != null) {
			new PointDao().update(user_id, user_id, 10);
			point = new PointDao().selectByUserId(user_id);
			System.out.println("upadte ===>" + point.getUser_id());
			System.out.println("point ===>" + point.getPoint());
		} else {
			new PointDao().insert(user_id, user_id, 10);
			point = new PointDao().selectByUserId(user_id);
			System.out.println("insert ===>" + point.getUser_id());
			System.out.println("point ===>" + point.getPoint());
		}
	}
}
