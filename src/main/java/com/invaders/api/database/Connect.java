package com.invaders.api.database;

import com.invaders.api.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @project py-api
 * @author Patrity - https://github.com/Patrity
 * Created on - 10/30/2020
 */

public class Connect {

    public static Connection make() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Config.DB_HOST, Config.DB_USER, Config.DB_PASS);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

}
