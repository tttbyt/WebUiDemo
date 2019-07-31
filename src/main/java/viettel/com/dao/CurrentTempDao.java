package viettel.com.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import viettel.com.entity.CurrentTempature;

@Repository
public class CurrentTempDao {

	@Autowired
	private CassandraOperations cassandraConnecttion;

	public CurrentTempature getCurrent(String uUID) {
		return cassandraConnecttion.selectOne(QueryBuilder.select().from("current").where(QueryBuilder.eq("id", UUID.fromString(uUID))), CurrentTempature.class);
	}
}
