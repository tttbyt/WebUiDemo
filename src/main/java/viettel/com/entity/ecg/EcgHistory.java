package viettel.com.entity.ecg;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("ecg_history")
public class EcgHistory {
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	private Timestamp time;
	@Column
	private List<Double> list_value;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public List<Double> getList_value() {
		return list_value;
	}

	public void setList_value(List<Double> list_value) {
		this.list_value = list_value;
	}

	public EcgHistory() {

	}
}
