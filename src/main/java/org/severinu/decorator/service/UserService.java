package org.severinu.decorator.service;

import org.severinu.decorator.datasource.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final DataSource dataSource;

    public UserService(@Qualifier("decoratedDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getAllUsers() {
        return dataSource.readData();
    }
}
