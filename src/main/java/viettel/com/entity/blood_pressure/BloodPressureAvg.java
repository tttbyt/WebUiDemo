package viettel.com.entity.blood_pressure;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("blood_pressure_avg")
public class BloodPressureAvg {
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	private Date day;
	@Column
	private String daytime;
	@Column
	private double high_avg = 0;
	@Column
	private double low_avg = 0;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	public double getHigh_avg() {
		return high_avg;
	}

	public void setHigh_avg(double high_avg) {
		this.high_avg = high_avg;
	}

	public double getLow_avg() {
		return low_avg;
	}

	public void setLow_avg(double low_avg) {
		this.low_avg = low_avg;
	}

	public BloodPressureAvg() {

	}
}
