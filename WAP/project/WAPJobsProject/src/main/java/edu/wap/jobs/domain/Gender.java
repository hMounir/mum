package edu.wap.jobs.domain;

public enum Gender {

    MALE("M"),
    FEMALE("F");

    private String value;

    private Gender(String value) {
        this.value = value;
    }
}
