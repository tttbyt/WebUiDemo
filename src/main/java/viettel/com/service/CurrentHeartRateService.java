package viettel.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import viettel.com.dao.CurrentHeartRateDao;
import viettel.com.entity.heart_rate.HeartRateCurrent;

@Service("CurrentHrService")
public class CurrentHeartRateService implements CurrentInterface{

	@Autowired
	private CurrentHeartRateDao hrDao;

	@SuppressWarnings("unchecked")
	@Override
	public HeartRateCurrent getCurrent(String uUID) {
		//check uuid exist or not
		return hrDao.getCurrent(uUID);
	}
}
