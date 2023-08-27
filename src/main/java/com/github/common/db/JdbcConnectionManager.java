package com.github.common.db;

import com.github.common.db.model.JdbcConnectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionManager {

    private static Logger logger = LoggerFactory.getLogger(JdbcConnectionManager.class);


    public Connection createConnection(JdbcConnectionConfig jdbcConnectionConfig) throws SQLException {
        logger.debug("creating connection ... "+jdbcConnectionConfig);
        return DriverManager.getConnection(jdbcConnectionConfig.getUrl()+"/"+jdbcConnectionConfig.getDatabaseName(),
                jdbcConnectionConfig.getUsername(),jdbcConnectionConfig.getPassword());
    }

    public void destroy(Connection connection){
        try {
            connection.close();
        } catch (SQLException ex) {
            logger.debug("destroying connection failed due to error "+ex.getMessage());
        }
    }
}
