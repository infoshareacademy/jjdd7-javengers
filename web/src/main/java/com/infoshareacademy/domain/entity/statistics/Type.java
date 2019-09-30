package com.infoshareacademy.domain.entity.statistics;

public enum Type {
    SINGLE_VIEW (1),
    CHECKED_CATEGORY (2);

    private final int type;

    Type(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
