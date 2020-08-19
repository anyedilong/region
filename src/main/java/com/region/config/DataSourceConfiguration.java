package com.region.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.username}")
    private  String userName;
    @Value("${spring.datasource.password}")
    private  String passWord;
    @Value("${spring.datasource.serverName}")
    private  String serverName;
    @Value("${spring.datasource.dataSourceClassName}")
    private  String dataSourceClassName;
    @Value("${spring.datasource.databaseName}")
    private  String databaseName;
    @Value("${spring.datasource.portNumber}")
    private  int portNumber;
    @Value("${spring.datasource.driverType}")
    private  String driverType;
    @Value("${spring.datasource.poolName}")
    private  String poolName;
    @Value("${spring.datasource.maximumPoolSize}")
    private  int maximumPoolSize;
    @Value("${spring.datasource.minimumIdle}")
    private  int minimumIdle;
    @Value("${spring.datasource.maxLifetime}")
    private  int maxLifetime;
    @Value("${spring.datasource.connectionTimeout}")
    private  int connectionTimeout;
    @Value("${spring.datasource.idleTimeout}")
    private  int idleTimeout;
    @Value("${spring.datasource.connectionTestQuery}")
    private  String connectionTestQuery;

  @Bean
  public DataSource  getDataSource(){
      Properties data = new Properties();
      data.put("user",userName);
      data.put("password",passWord);
      data.put("driverType",driverType);
      data.put("portNumber",portNumber);
      data.put("databaseName",databaseName);
      data.put("serverName",serverName);

      Properties config=new Properties();
      config.put("dataSourceClassName", dataSourceClassName);
      config.put("poolName",poolName);
      config.put("maximumPoolSize",maximumPoolSize);
      config.put("minimumIdle",minimumIdle);
      config.put("maxLifetime",maxLifetime);
      config.put("connectionTimeout",connectionTimeout);
      config.put("idleTimeout",idleTimeout);
      config.put("connectionTestQuery",connectionTestQuery);
      config.put("dataSourceProperties",data);
      HikariConfig hc = new HikariConfig(config);
      final HikariDataSource hikariDataSource = new HikariDataSource(hc);
      return  hikariDataSource;
  }



}
