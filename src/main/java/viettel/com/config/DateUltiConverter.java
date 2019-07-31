package viettel.com.config;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateUltiConverter implements Converter<Date, Timestamp> {

	@Override
	public Timestamp convert(Date source) {
		// TODO Auto-generated method stub
		return new Timestamp(source.getTime());
	}
}
