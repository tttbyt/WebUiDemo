package viettel.com.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import viettel.com.WebConstant;
import viettel.com.entity.ecg.EcgCurrent;

@Repository
public class CurrentEcgDao {
	
	@Autowired
	private CassandraOperations cassandraConnecttion;

	public EcgCurrent getCurrent(String uUID) {
		return cassandraConnecttion.selectOne(QueryBuilder.select().from(WebConstant.ECG_CURRENT_TABLE)
				.where(QueryBuilder.eq("id", UUID.fromString(uUID))), EcgCurrent.class);
	}
}
