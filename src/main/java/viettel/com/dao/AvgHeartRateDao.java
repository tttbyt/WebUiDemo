package viettel.com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viettel.com.entity.heart_rate.HeartRateAvg;
import viettel.com.repository.MyCassandraTemplate;

@Repository("avgHeartRateDao")
public class AvgHeartRateDao implements AvgDao {
	
	@Autowired
	private MyCassandraTemplate myCassandraTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<HeartRateAvg> getByDays(int number, String uuid, String tableName) {
		// TODO Auto-generated method stub
		return myCassandraTemplate.findAllByNumber(uuid, tableName, number, HeartRateAvg.class);
	}

}
