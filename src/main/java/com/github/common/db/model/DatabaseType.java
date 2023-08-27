package com.github.common.db.model;

public enum DatabaseType {
    POSTGRES("PostgreSQL"),
    MYSQL("MySQL");

    private final String displayName;

    DatabaseType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
