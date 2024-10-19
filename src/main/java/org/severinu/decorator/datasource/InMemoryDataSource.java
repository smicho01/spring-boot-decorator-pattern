package org.severinu.decorator.datasource;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InMemoryDataSource implements  DataSource {

    private final List<String> users = Arrays.asList("Alice", "Bob", "Charlie", "David");

    @Override
    public List<String> readData() {
        return users;
    }
}
