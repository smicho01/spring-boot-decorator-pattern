package org.severinu.decorator.decorators;

import lombok.extern.slf4j.Slf4j;
import org.severinu.decorator.datasource.DataSource;

import java.util.List;

@Slf4j
public class LoggingDecorator implements DataSource  {

    private final DataSource wrappee;

    public LoggingDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public List<String> readData() {
        log.info("Fetching data...");
        List<String> data = wrappee.readData();
        log.info("Data fetched: " + data);
        return data;
    }
}
