package viettel.com.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import viettel.com.dao.TempDayDAO;
import viettel.com.entity.TempatureDay;

@Service
public class TempdayServiceImpl implements TempdayService {

	@Autowired
	private TempDayDAO tempDayDAO;

	public TempdayServiceImpl() {
		super();
	}

	@Override
	public TempatureDay getTempdaybyId(Timestamp time) {
		return tempDayDAO.getTempByDay(time);
	}

	@Override
	public TempatureDay updateTempatureDay(TempatureDay tempDay) {
		return tempDayDAO.updateTempDay(tempDay);
	}

	@Override
	public void deleteTempatureDay(Timestamp time) {
		tempDayDAO.deleteTempatureDay(time);
	}

	@Override
	public List<TempatureDay> getAllTempatureDay() {
		return tempDayDAO.getAllTempatureDays();
	}

	@Override
	public List<TempatureDay> getTempatureDays(int number, String partion) {
		// TODO Auto-generated method stub
		return tempDayDAO.getTempatureDays(number, partion);
	}

}
