package viettel.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import viettel.com.dao.CurrentTempDao;
import viettel.com.entity.CurrentTempature;

@Service
public class CurrentTempService implements CurrentInterface{

	@Autowired
	private CurrentTempDao currentTempDAO;

	@SuppressWarnings("unchecked")
	@Override
	public CurrentTempature getCurrent(String uUID) {
		//check uuid exist or not
		return currentTempDAO.getCurrent(uUID);
	}
}
