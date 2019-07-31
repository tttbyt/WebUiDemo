package viettel.com.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import viettel.com.WebConstant;
import viettel.com.entity.heart_rate.HeartRateCurrent;

@Repository
public class CurrentHeartRateDao {

	@Autowired
	private CassandraOperations cassandraConnecttion;

	public HeartRateCurrent getCurrent(String uUID) {
		return cassandraConnecttion.selectOne(QueryBuilder.select().from(WebConstant.HR_CURRENT_TABLE).where(QueryBuilder.eq("id", UUID.fromString(uUID))), HeartRateCurrent.class);
	}
}
