package viettel.com.entity.heart_rate;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("heart_rate_avg")
public class HeartRateAvg {
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	private Date day;
	@Column
	private String daytime;
	@Column
	private double heart_rate_avg = 0;
	@Column
	private double heart_rate_min = 0;
	@Column
	private double heart_rate_max = 0;

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

	public double getHeart_rate_avg() {
		return heart_rate_avg;
	}

	public void setHeart_rate_avg(double heart_rate_avg) {
		this.heart_rate_avg = heart_rate_avg;
	}

	public double getHeart_rate_min() {
		return heart_rate_min;
	}

	public void setHeart_rate_min(double heart_rate_min) {
		this.heart_rate_min = heart_rate_min;
	}

	public double getHeart_rate_max() {
		return heart_rate_max;
	}

	public void setHeart_rate_max(double heart_rate_max) {
		this.heart_rate_max = heart_rate_max;
	}

	public HeartRateAvg() {
	}

}
