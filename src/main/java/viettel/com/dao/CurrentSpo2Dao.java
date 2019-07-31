package viettel.com.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import viettel.com.WebConstant;
import viettel.com.entity.spo2.Spo2Current;

@Repository
public class CurrentSpo2Dao {

	@Autowired
	private CassandraOperations cassandraConnecttion;

	public Spo2Current getCurrentSpo2(String uUID) {
		return cassandraConnecttion.selectOne(QueryBuilder.select().from(WebConstant.SPO2_CURRENT_TABLE).where(QueryBuilder.eq("id", UUID.fromString(uUID))), Spo2Current.class);
	}
}
