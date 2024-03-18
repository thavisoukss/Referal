package com.ldbbank.referal.DBConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean(name = "sms")
    @ConfigurationProperties(prefix = "spring.smsalert")
    public DataSource SMSJdbcTemplate() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "SMSJdbcTemplate")
    public JdbcTemplate SMSDatasource(@Qualifier("sms") DataSource SMSJdbcTemplate) {
        return new JdbcTemplate(SMSJdbcTemplate);
    }


    @Bean(name = "corebank")
    @ConfigurationProperties(prefix = "spring.corebank")
    public DataSource CoreBankDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "CoreBankJdbcTemplate")
    public JdbcTemplate CoreBankJdbcTemplate(@Qualifier("corebank") DataSource CoreBankJdbcTemplate) {
        return new JdbcTemplate(CoreBankJdbcTemplate);

    }

    @Bean(name = "ebank")
    @ConfigurationProperties(prefix = "spring.ebank")
    public DataSource EBankDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "EBankJdbcTemplate")
    public JdbcTemplate EBankJdbcTemplate(@Qualifier("ebank") DataSource EBankJdbcTemplate) {
        return new JdbcTemplate(EBankJdbcTemplate);

    }

    @Bean(name = "atm")
    @ConfigurationProperties(prefix = "spring.atm")
    public DataSource ATMDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ATMJdbcTemplate")
    public JdbcTemplate ATMJdbcTemplate(@Qualifier("atm") DataSource ATMJdbcTemplate) {
        return new JdbcTemplate(ATMJdbcTemplate);

    }


}
