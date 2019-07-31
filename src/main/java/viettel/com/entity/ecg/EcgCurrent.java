package viettel.com.entity.ecg;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("ecg_current")
public class EcgCurrent {
	@PrimaryKey
	private UUID id;
	@Column
	private Date time;
	@Column
	private List<Double> current_value;

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

	public List<Double> getCurrent_value() {
		return current_value;
	}

	public void setCurrent_value(List<Double> current_value) {
		this.current_value = current_value;
	}

	public EcgCurrent() {

	}

}
