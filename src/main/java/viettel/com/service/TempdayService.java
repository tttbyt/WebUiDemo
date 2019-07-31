package viettel.com.service;

import java.sql.Timestamp;
import java.util.List;

import viettel.com.entity.TempatureDay;

public interface TempdayService {

	public TempatureDay getTempdaybyId(Timestamp time);

	public TempatureDay updateTempatureDay(TempatureDay tempDay);

	public void deleteTempatureDay(Timestamp time);

	public List<TempatureDay> getAllTempatureDay();

	public List<TempatureDay> getTempatureDays(int number, String partion);

}
