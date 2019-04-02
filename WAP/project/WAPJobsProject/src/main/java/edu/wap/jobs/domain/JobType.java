package edu.wap.jobs.domain;

public enum JobType {

    FULL_TIME(1),
    PART_TIME(2),
    REMOTE(3);

    private int id;

    private JobType( int id) {
        this.id = id;
    }
}
