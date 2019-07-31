package viettel.com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
@EnableCassandraRepositories(basePackages = "viettel.com.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {
	private static final String KEYSPACE = "cassandra.keyspace";
	private static final String CONTACTPOINTS = "cassandra.contactpoints";
	private static final String PORT = "cassandra.port";
	private static final String USER = "cassandra.user";
	private static final String PASS = "cassandra.password";

	@Autowired
	private Environment environment;

	public CassandraConfig() {
		System.out.println("CassandraUtil()");
	}

	@Override
	protected String getKeyspaceName() {
		// TODO Auto-generated method stub
		return environment.getProperty(KEYSPACE);
	}

	private String getContactPoint() {
		return environment.getProperty(CONTACTPOINTS);
	}

	private int getPortNumber() {
		return Integer.parseInt(environment.getProperty(PORT));
	}

	private String getUserName() {
		return environment.getProperty(USER);
	}

	private String getPassword() {
		return environment.getProperty(PASS);
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(getContactPoint());
		cluster.setPort(getPortNumber());
		cluster.setUsername(getUserName());
		cluster.setPassword(getPassword());
		cluster.setJmxReportingEnabled(false);
		return cluster;
	}

	@Bean
	public CassandraMappingContext mappingContext() {
		return new CassandraMappingContext();
	}

	@Bean
	public CassandraConverter converter() {
		return new MappingCassandraConverter(mappingContext());
	}

	@Bean
	public CassandraSessionFactoryBean session() {
		CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
		cassandraSessionFactoryBean.setCluster(cluster().getObject());
		cassandraSessionFactoryBean.setKeyspaceName(getKeyspaceName());
		cassandraSessionFactoryBean.setConverter(converter());
		cassandraSessionFactoryBean.setSchemaAction(SchemaAction.NONE);
		return cassandraSessionFactoryBean;
	}

	@Bean
	public CassandraOperations cassandraConnecttion() throws Exception {
		return new CassandraTemplate(session().getObject());
	}

	@Override
	public CassandraCustomConversions customConversions() {
		List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
		converters.add(new DateUltiConverter());
		return new CassandraCustomConversions(converters);
	}
}
