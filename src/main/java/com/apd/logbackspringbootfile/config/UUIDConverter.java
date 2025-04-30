package com.apd.logbackspringbootfile.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import java.util.UUID;

public class UUIDConverter extends ClassicConverter {

    private static final ThreadLocal<String> transactionId = ThreadLocal.withInitial(
            () -> UUID.randomUUID().toString().replace("-", ""));

    @Override
    public String convert(ILoggingEvent event) {
        return transactionId.get();
    }

    // Method to generate a new UUID for the next task
    public static void generateNewUUID() {
        transactionId.set(UUID.randomUUID().toString().replace("-", ""));
    }

    // Static method for getting the current transaction ID
    public static String getTransactionId() {
        return transactionId.get();
    }

    public void unload() {
        transactionId.remove(); // Compliant
    }
}
