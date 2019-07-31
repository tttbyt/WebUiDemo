package viettel.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import viettel.com.WebConstant;
import viettel.com.dao.AvgDao;

@Service("avgHrService")
public class AvgHeartRateService implements AvgService{

	@Autowired
	@Qualifier("avgHeartRateDao")
	private AvgDao dao;
	
	@Override
	public <T> List<T> getByDays(int number, String uuid) {
		// TODO Auto-generated method stub
		return dao.getByDays(number, uuid, WebConstant.HR_AVG_TABLE);
	}

}
