package com.spring.task.management.system.enums;

public enum Status {
    DONE("DONE"),
    IN_PROGRESS("IN_PROGRESS");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
