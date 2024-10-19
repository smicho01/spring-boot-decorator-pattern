package org.severinu.decorator.decorators;

import org.severinu.decorator.datasource.DataSource;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class EncryptionDecorator implements DataSource  {
    private final DataSource wrappee;

    public EncryptionDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public List<String> readData() {
        List<String> data = wrappee.readData();
        return data.stream()
                .map(this::encrypt)
                .collect(Collectors.toList());
    }

    private String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}
