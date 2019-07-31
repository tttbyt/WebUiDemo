package viettel.com.dao;

import java.sql.Timestamp;
import java.util.List;

import viettel.com.entity.TempatureDay;

public interface TempDayDAO {
	public TempatureDay createNewTempatureDay(TempatureDay newTempDay);

	public TempatureDay getTempByDay(Timestamp time);

	public TempatureDay updateTempDay(TempatureDay tempDay);

	public void deleteTempatureDay(Timestamp time);

	public List<TempatureDay> getTempatureDays(int number, String partion);

	public List<TempatureDay> getAllTempatureDays();

}
