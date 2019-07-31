package viettel.com.entity.heart_rate;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("heart_rate_avg")
public class HeartRateCurrent {
	@PrimaryKey
	private UUID id;
	@Column
	private Date time;
	@Column
	private double current_heart_rate;

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

	public double getCurrent_heart_rate() {
		return current_heart_rate;
	}

	public void setCurrent_heart_rate(double current_heart_rate) {
		this.current_heart_rate = current_heart_rate;
	}

	public HeartRateCurrent() {
	}
}
