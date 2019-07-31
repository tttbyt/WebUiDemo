package viettel.com.entity.spo2;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("spo2_current")
public class Spo2Current {
	@PrimaryKey
	private UUID id;
	@Column
	private Date time;
	@Column
	private double spo2_current;

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

	public double getSpo2_current() {
		return spo2_current;
	}

	public void setSpo2_current(double spo2_current) {
		this.spo2_current = spo2_current;
	}

	public Spo2Current() {

	}
}
