package viettel.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import viettel.com.dao.CurrentEcgDao;
import viettel.com.entity.ecg.EcgCurrent;

@Service("CurrentECGService")
public class CurrentEcgService implements CurrentInterface{

	@Autowired
	private CurrentEcgDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public EcgCurrent getCurrent(String uUID) {
		//check uuid exist or not
		return dao.getCurrent(uUID);
	}
}
