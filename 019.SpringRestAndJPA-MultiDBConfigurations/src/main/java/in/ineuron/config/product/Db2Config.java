package in.ineuron.config.product;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db2EntityManager",
                       transactionManagerRef = "db2TransactionManager",
                       basePackages  = "in.ineuron.repo.product")
public class Db2Config {
	
	@ConfigurationProperties(prefix = "db2.datasource")
	@Bean
	public DataSource db2DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean db2EntityManager(EntityManagerFactoryBuilder emf) {
		HashMap<String,Object> properties=new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

	return emf.dataSource(db2DataSource())
			.packages("in.ineuron.config.model.product")
			.properties(properties)
			.persistenceUnit("divs")
			.build();
	}
	
	@Bean
	public PlatformTransactionManager db2TransactionManager(@Qualifier("db2EntityManager")EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
