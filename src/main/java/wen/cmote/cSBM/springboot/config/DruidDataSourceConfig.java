package wen.cmote.cSBM.springboot.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.bind.RelaxedBindingNotWritablePropertyException;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configurable
@EnableTransactionManagement
/*
 * Druid的DataResource配置类
 */
public class DruidDataSourceConfig implements EnvironmentAware {
	
	private RelaxedPropertyResolver propertyResolver;

	public void setEnvironment(Environment env) {
		// TODO Auto-generated method stub
		this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
	}

	@Bean
	public DataSource dataSource() {
		System.out.println("注入Druid！！！");
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(propertyResolver.getProperty("url"));
		dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
		dataSource.setUsername(propertyResolver.getProperty("username"));
		dataSource.setPassword(propertyResolver.getProperty("password"));
		dataSource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initial-size")));
		dataSource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("min-idle")));
		dataSource.setMaxWait(Long.valueOf(propertyResolver.getProperty("max-wait")));
		dataSource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("max-active")));
		dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("min-evictable-idle-time-millis")));
		try{
			dataSource.setFilters("stat, wall");
		} catch(SQLException e){
			e.printStackTrace();
		}
		return dataSource();
	}
}
