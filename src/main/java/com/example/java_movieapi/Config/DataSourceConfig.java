package com.example.java_movieapi.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@Profile("production")
public class DataSourceConfig {
    @Value("#{systemEnvironment['DATABASE_URL']}")
    String databaseUrl;

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI databaseUri = new URI(databaseUrl);
        String[] creds = databaseUri.getUserInfo().split(":");
        String url = String.format("jdbc:postgresql://%s:%s%s?sslmode=require&user=%s&password=%s",
                databaseUri.getHost(),
                databaseUri.getPort(),
                databaseUri.getPath(),
                creds[0],
                creds[1]);

        BasicDataSource source = new BasicDataSource();
        source.setUrl(url);

        return source;
    }


}
