package viettel.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import viettel.com.WebConstant;
import viettel.com.dao.AvgDao;

@Service("avgBpService")
public class AvgBloodPressureService implements AvgService{

	@Autowired
	@Qualifier("avgBloodPressureDao")
	private AvgDao dao;
	
	@Override
	public <T> List<T> getByDays(int number, String uuid) {
		// TODO Auto-generated method stub
		return dao.getByDays(number, uuid, WebConstant.BP_AVG_TABLE);
	}

}
