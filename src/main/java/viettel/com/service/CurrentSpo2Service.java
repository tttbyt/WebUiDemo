package viettel.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import viettel.com.dao.CurrentSpo2Dao;
import viettel.com.entity.spo2.Spo2Current;

@Service("CurrentSpo2Service")
public class CurrentSpo2Service implements CurrentInterface{

	@Autowired
	private CurrentSpo2Dao spo2Dao;

	@SuppressWarnings("unchecked")
	@Override
	public Spo2Current getCurrent(String uUID) {
		//check uuid exist or not
		return spo2Dao.getCurrentSpo2(uUID);
	}
}
