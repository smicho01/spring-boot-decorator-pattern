package org.severinu.decorator.decorators;

import org.severinu.decorator.datasource.DataSource;

import java.util.List;

public class ValidationDecorator implements DataSource  {

    private final DataSource wrapee;

    public ValidationDecorator(DataSource wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public List<String> readData() {
        List<String> data = wrapee.readData();
        validate(data);
        return data;
    }

    private void validate(List<String> data) {
        if( data == null || data.isEmpty()) {
            throw new RuntimeException("Data is invalid: list is null or empty");
        }
        // some other sophisticated validation logic here
    }
}
