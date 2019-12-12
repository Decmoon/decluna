package com.decmoon.decluna.storage.status;

/**
 * Status code
 *
 * @author decmoon
 */
public enum Status {

    OKAY("data", "okay"),
    NO("data", "no");


    private String key;
    private String value;

    Status(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
