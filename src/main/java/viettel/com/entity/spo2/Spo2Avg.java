package viettel.com.entity.spo2;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("spo2_avg")
public class Spo2Avg {
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	private Date day;
	@Column
	private String daytime;
	@Column
	private double spo2_avg = 0;
	@Column
	private double spo2_min = 0;
	@Column
	private double spo2_max = 0;

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

	public double getSpo2_avg() {
		return spo2_avg;
	}

	public void setSpo2_avg(double spo2_avg) {
		this.spo2_avg = spo2_avg;
	}

	public double getSpo2_min() {
		return spo2_min;
	}

	public void setSpo2_min(double spo2_min) {
		this.spo2_min = spo2_min;
	}

	public double getSpo2_max() {
		return spo2_max;
	}

	public void setSpo2_max(double spo2_max) {
		this.spo2_max = spo2_max;
	}

	public Spo2Avg() {

	}

}
