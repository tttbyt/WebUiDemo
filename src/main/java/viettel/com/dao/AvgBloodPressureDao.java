package viettel.com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viettel.com.entity.blood_pressure.BloodPressureAvg;
import viettel.com.repository.MyCassandraTemplate;

@Repository("avgBloodPressureDao")
public class AvgBloodPressureDao implements AvgDao {
	
	@Autowired
	private MyCassandraTemplate myCassandraTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<BloodPressureAvg> getByDays(int number, String uuid, String tableName) {
		// TODO Auto-generated method stub
		return myCassandraTemplate.findAllByNumber(uuid, tableName, number, BloodPressureAvg.class);
	}

}
