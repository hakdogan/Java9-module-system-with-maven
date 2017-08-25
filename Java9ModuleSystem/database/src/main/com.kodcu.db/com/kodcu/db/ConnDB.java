package com.kodcu.db;

import java.sql.*;
import java.util.Objects;
import com.kodcu.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.h2.tools.DeleteDbFiles;

/*
 * Created by hakdogan on 24/08/2017
 */
public class ConnDB {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_NAME = "test";
    private static final String DB_CONNECTION_STRING = "jdbc:h2:~/" + DB_NAME;
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    private static ConnDB instance = null;
    private static Object lock = new Object();
    private static Connection CONNECTION;

    private static final Logger logger  = LogManager.getLogger(ConnDB.class);

    public static ConnDB instance(){

        if(Objects.isNull(instance)){
            synchronized (lock){
                if(Objects.isNull(instance))
                    instance = new ConnDB();
            }
        }

        logger.info("ConnDB instance being returned.");
        return instance;
    }

    /**
     *
     * @return
     */
    public Connection getDBConnection() {

        if(Objects.isNull(CONNECTION)){

            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage());
            }

            try {
                return DriverManager.getConnection(DB_CONNECTION_STRING, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                logger.error(e.getMessage());

            }
        }

        return CONNECTION;
    }

    /**
     *
     * @param user
     * @throws SQLException
     */
    public void insertWithStatement(User user) throws SQLException {

        DeleteDbFiles.execute("~", DB_NAME, true);
        Connection connection = getDBConnection();
        Statement stmt;

        try {

            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            createTable(stmt);
            stmt.execute("INSERT INTO PERSON(id, firstname, lastname, profession, age) VALUES(null, '"
                    + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getProfession() + "', " + user.getAge() + ")");

            ResultSet rs = stmt.executeQuery("select * from PERSON");
            logger.info("H2 Database inserted through Statement");

            while (rs.next()) {
                logger.info("Id: " + rs.getInt("id") + " First Name: " + rs.getString("firstname")
                        + " Last Name: " + rs.getString("lastname") + " Profession: " + rs.getString("profession")
                        + " Age: " + rs.getInt("age"));
            }

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            connection.close();
        }
    }

    /**
     *
     * @param stmt
     */
    private void createTable(Statement stmt){

        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS PERSON(id int not null auto_increment primary key, firstname varchar(255), lastname varchar(255), " +
                    "profession varchar(255), age int)");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

}