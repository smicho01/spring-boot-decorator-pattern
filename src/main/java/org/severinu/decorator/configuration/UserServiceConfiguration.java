package org.severinu.decorator.configuration;

import org.severinu.decorator.datasource.DataSource;
import org.severinu.decorator.decorators.EncryptionDecorator;
import org.severinu.decorator.decorators.LoggingDecorator;
import org.severinu.decorator.decorators.ValidationDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfiguration {

    private final DataSource inMemoryDataSource;

    public UserServiceConfiguration(DataSource inMemoryDataSource) {
        this.inMemoryDataSource = inMemoryDataSource;
    }

    @Bean
    public DataSource decoratedDataSource() {
        // Chaining decorators
        DataSource dataSource = new ValidationDecorator(inMemoryDataSource);
        dataSource = new LoggingDecorator(dataSource);
        dataSource = new EncryptionDecorator(dataSource);
        return dataSource;
    }

    @Bean
    public DataSource plainDataSource() {
        return inMemoryDataSource;
    }
}
