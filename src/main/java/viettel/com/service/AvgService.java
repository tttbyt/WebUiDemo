package viettel.com.service;

import java.util.List;

public interface AvgService {
	public <T> List<T> getByDays(int number, String uuid);
}
