package viettel.com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viettel.com.entity.spo2.Spo2Avg;
import viettel.com.repository.MyCassandraTemplate;

@Repository("avgSpo2Dao")
public class AvgSpo2Dao implements AvgDao {
	
	@Autowired
	private MyCassandraTemplate myCassandraTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Spo2Avg> getByDays(int number, String uuid, String tableName) {
		// TODO Auto-generated method stub
		return myCassandraTemplate.findAllByNumber(uuid, tableName, number, Spo2Avg.class);
	}

}
