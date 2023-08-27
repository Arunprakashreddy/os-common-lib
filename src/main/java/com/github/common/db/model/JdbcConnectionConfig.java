package com.github.common.db.model;

public class JdbcConnectionConfig {
    private String Url;
    private String password;
    private String username;
    private DatabaseType databaseType;
    private String databaseName;

    public String getUrl(){
        return Url;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername() {
        return username;
    }

    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public JdbcConnectionConfig(JdbcConnectionConfigBuilder builder){
        this.databaseName = builder.databaseName;
        this.databaseType = builder.databaseType;
        this.Url = builder.Url;
        this.password= builder.password;
        this.username = builder.username;
    }

    public static class JdbcConnectionConfigBuilder{
        private String Url;
        private String password;
        private String username;
        private DatabaseType databaseType = DatabaseType.POSTGRES;
        private String databaseName = "public";

        public JdbcConnectionConfigBuilder(String url, String password, String username){
            this.Url = url;
            this.password = password;
            this.username =username;
        }

        public JdbcConnectionConfigBuilder setDatabaseName(String databaseName) {
            this.databaseName = databaseName;
            return this;
        }

        public JdbcConnectionConfigBuilder setDatabaseType(DatabaseType databaseType) {
            this.databaseType = databaseType;
            return this;
        }

        public JdbcConnectionConfig build(){
            return new JdbcConnectionConfig(this);
        }
    }

    @Override
    public String toString() {
        return "JdbcConnectionConfig{" +
                "Url='" + Url + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", databaseType=" + databaseType +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }
}
