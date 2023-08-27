package com.github;

import com.github.common.db.JdbcConnectionManager;
import com.github.common.db.model.DatabaseType;
import com.github.common.db.model.JdbcConnectionConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{

    private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );
        JdbcConnectionManager jdbcConnectionManager =new JdbcConnectionManager();
        JdbcConnectionConfig jdbcConnectionConfig = new JdbcConnectionConfig
                .JdbcConnectionConfigBuilder("jdbc:mysql://localhost:3306","student","student")
                .setDatabaseName("demo")
                .setDatabaseType(DatabaseType.MYSQL)
                .build();
        System.out.println(jdbcConnectionConfig);

        Connection connection=jdbcConnectionManager.createConnection(jdbcConnectionConfig);
        logger.debug("is connection alive : "+ !connection.isClosed());

        jdbcConnectionManager.destroy(connection);
        logger.debug("is connection alive : "+ !connection.isClosed());

    }
}
