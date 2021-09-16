package api.java.javaweb.config.Pcourse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
public class HikariDataSource {
    Logger logger = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    public DataSource getDataSource(
            @Value("${jdbc.driverClassName}") String driverClassName,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.user}") String user,
            @Value("${jdbc.pass}") String pass
    ) {

        logger.info("DBConfig :: Loading DataSource", driverClassName);

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(pass);
        DataSource retval = dataSourceBuilder.build();
        logger.info("DBConfig :: Loading DataSource", retval);

        return retval;
    }
}
