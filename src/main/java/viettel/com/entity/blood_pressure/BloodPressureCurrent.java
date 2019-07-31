package viettel.com.entity.blood_pressure;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("blood_pressure_current")
public class BloodPressureCurrent {
	@PrimaryKey
	private UUID id;
	@Column
	private Date time;
	@Column
	private double high_value;
	@Column
	private double low_value;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getHigh_value() {
		return high_value;
	}

	public void setHigh_value(double high_value) {
		this.high_value = high_value;
	}

	public double getLow_value() {
		return low_value;
	}

	public void setLow_value(double low_value) {
		this.low_value = low_value;
	}

	public BloodPressureCurrent() {

	}
}
