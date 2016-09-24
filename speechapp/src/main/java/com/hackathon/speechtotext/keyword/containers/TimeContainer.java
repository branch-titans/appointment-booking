package com.hackathon.speechtotext.keyword.containers;

/**
 * Created by sathih on 23-09-2016.
 */
public enum TimeContainer {
    nine(9),
    ten(10),
    eleven(11),
    twelve(12),
    one(1),
    two(2),
    three(3),
    four(4),
    five(5);

    private int time_num;

    TimeContainer(int i) {
        this.time_num = i;
    }

    public int getTime_num() {
        return time_num;
    }
}
