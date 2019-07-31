package viettel.com.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;

@Repository
public class MyCassandraTemplate {

	@Autowired
	private CassandraOperations cassandraConnecttion;

	public MyCassandraTemplate() {
		System.out.println("MyCassandraTemplate()");
	}

	/**
	 * Creating the entity.
	 * 
	 * @param entity
	 * @return {@link Object}
	 */
	public <T> T create(T entity) {
		return cassandraConnecttion.insert(entity);
	}

	/**
	 * Creating the list of entities.
	 * 
	 * @param entity
	 */
	public <T> void createList(List<T> entities) {
		cassandraConnecttion.insert(entities);
	}

	/**
	 * Updating the entity.
	 * 
	 * @param entity
	 * @param claz
	 * @return T
	 */
	public <T> T update(T entity) {
		return (T) cassandraConnecttion.update(entity);
	}

	/**
	 * Updating the list of entities.
	 * 
	 * @param entity
	 * @param claz
	 * @return T
	 */
	public <T> void updateList(List<T> entities) {
		cassandraConnecttion.update(entities);
	}

	/**
	 * Updating the entity.
	 * 
	 * @param entity
	 * @param claz
	 * @return T
	 */
	public <T> T update(T entity, Class<T> claz) {
		return (T) cassandraConnecttion.update(entity);
	}

	/**
	 * Get the Entity using Id.
	 * 
	 * @param id
	 * @param claz
	 * @return T
	 */
	/*
	 * public <T> T findById(Object id, Class<T> claz) { return
	 * cassandraTemplate.selectOneById(claz, id); }
	 */

	/**
	 * Delete the Entity using Id.
	 * 
	 * @param id
	 * @param claz
	 */

	public <T> void deleteById(Object id, Class<T> claz) {
		cassandraConnecttion.deleteById(id, claz);
	}

	/**
	 * Delete the Entity using object.
	 * 
	 * @param entity
	 */
	public void delete(Object entity) {
		cassandraConnecttion.delete(entity);
	}

	/**
	 * Deleting the list of entities
	 * 
	 * @param entities
	 */
	public <T> void delete(List<T> entities) {
		cassandraConnecttion.delete(entities);
	}

	/**
	 * Deleting the all entities.
	 * 
	 * @param claz
	 */
	public <T> void deleteAll(Class<T> claz) {
		cassandraConnecttion.delete(claz);
	}

	/**
	 * Getting the all entities.
	 * 
	 * @param claz
	 * @return List of entities
	 */

	public <T> List<T> findAll(String tablename, Class<T> claz) {
		return (List<T>) cassandraConnecttion.select(QueryBuilder.select().from(tablename), claz);
	}

	/**
	 * Getting the all entity values using specific id's data.
	 * 
	 * @param ids
	 * @param claz
	 * @return
	 */

	/*
	 * public <T> List<T> findAll(List<Object> ids, Class<T> claz) { return
	 * cassandraTemplate.selectBySimpleIds(claz, ids); }
	 */

	/**
	 * Getting the count of records.
	 * 
	 * @param claz
	 * @return the count value.
	 */
	public <T> long getCount(Class<T> claz) {
		return cassandraConnecttion.count(claz);
	}

	public <T> List<T> findAllByNumber(String partionkey, String tablename, int number, Class<T> claz) {

		return (List<T>) cassandraConnecttion
				.select(QueryBuilder.select().from(tablename).where(QueryBuilder.eq("id", UUID.fromString(partionkey)))
						.limit(number).orderBy(QueryBuilder.desc("day")), claz);
	}

	/**
	 * Checking the object exists or not.
	 * 
	 * @param id
	 * @param claz
	 * @return true if the object exists in the database otherwise it will return
	 *         false.
	 */

	public <T> boolean exists(Object id, Class<T> claz) {
		return cassandraConnecttion.exists(id, claz);
	}

}
