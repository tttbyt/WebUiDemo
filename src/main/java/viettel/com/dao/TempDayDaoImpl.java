package viettel.com.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viettel.com.entity.TempatureDay;
import viettel.com.repository.MyCassandraTemplate;

@Repository
public class TempDayDaoImpl implements TempDayDAO {

	@Autowired
	private MyCassandraTemplate myCassandraTemplate;

	@Override
	public TempatureDay createNewTempatureDay(TempatureDay newTempDay) {
		return myCassandraTemplate.create(newTempDay);
	}

	@Override
	public TempatureDay getTempByDay(Timestamp time) {
		return null;//myCassandraTemplate.findById(time, TempatureDay.class);
	}

	@Override
	public TempatureDay updateTempDay(TempatureDay tempDay) {
		return myCassandraTemplate.update(tempDay, TempatureDay.class);
	}

	@Override
	public void deleteTempatureDay(Timestamp time) {
		//myCassandraTemplate.deleteById(time, TempatureDay.class);
	}

	@Override
	public List<TempatureDay> getTempatureDays(int number, String partion) {
		return myCassandraTemplate.findAllByNumber(partion, "temp_avg_day",number, TempatureDay.class);
	}
	
	public List<TempatureDay> getAllTempatureDays() {
		return myCassandraTemplate.findAll("temp_avg_day", TempatureDay.class);
	}
}
