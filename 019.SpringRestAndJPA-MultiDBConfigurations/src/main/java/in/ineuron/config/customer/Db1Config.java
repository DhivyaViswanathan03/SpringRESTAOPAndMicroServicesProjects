package in.ineuron.config.customer;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db1EntityManager",
                       transactionManagerRef = "db1TransactionManager",
                       basePackages  = "in.ineuron.repo.customer")
public class Db1Config {
	
	@ConfigurationProperties(prefix = "db1.datasource")
	@Bean
	@Primary
	public DataSource db1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean db1EntityManager(EntityManagerFactoryBuilder emf) {
		HashMap<String,Object> properties=new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

	return emf.dataSource(db1DataSource())
			.packages("in.ineuron.config.model.customer")
			.properties(properties)
			.persistenceUnit("divs")
			.build();
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager db1TransactionManager(@Qualifier("db1EntityManager") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
