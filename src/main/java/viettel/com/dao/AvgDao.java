package viettel.com.dao;

import java.util.List;

public interface AvgDao {
	public <T> List<T> getByDays(int number, String uuid, String tableName);
}
