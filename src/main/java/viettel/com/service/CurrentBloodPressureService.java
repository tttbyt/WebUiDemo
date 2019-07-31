package viettel.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import viettel.com.dao.CurrentBloodPressureDao;
import viettel.com.entity.blood_pressure.BloodPressureCurrent;

@Service("CurrentBpService")
public class CurrentBloodPressureService implements CurrentInterface {

	@Autowired
	private CurrentBloodPressureDao bpDao;

	@SuppressWarnings("unchecked")
	@Override
	public BloodPressureCurrent getCurrent(String uUID) {
		// check uuid exist or not
		return bpDao.getCurrent(uUID);
	}

}
