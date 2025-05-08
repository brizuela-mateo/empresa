package config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

    @Configuration
    public class DataSourceConfig {

        @Value("${spring.datasource.url:jdbc:mysql://localhost:3306/empresa}")
        private String jdbcUrl;

        @Value("${spring.datasource.username}")
        private String username;

        @Value("${spring.datasource.password}")
        private String password;

        @Value("${spring.datasource.driver-class-name}")
        private String driverClassName;

        @Bean(name = "data")
        public DataSource dataSource() {

            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(jdbcUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setDriverClassName(driverClassName);

            // Configuración adicional de HikariCP
            dataSource.setMaximumPoolSize(10);
            dataSource.setMinimumIdle(5);
            dataSource.setIdleTimeout(30000);
            dataSource.setPoolName("MiPoolDeConexiones");

            return dataSource;
        }

        @Bean//(name = "jdbctemplate")
        public JdbcTemplate jdbcTemplate(@Qualifier("data") DataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }

        @Bean
        public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }
    }

