package com.example.zavod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db extends Data {
    Connection dbConnection;

    public Db() {
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + this.dbHost + ":" + this.dbPort + "/" + this.dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = DriverManager.getConnection(connectionString, this.dbUser, this.dbPass);
        return this.dbConnection;
    }

    public void signUpUser(Users users) {
        String insert = "INSERT INTO users(firstname,lastname,login,password,location,gender)VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(insert);
            prSt.setString(1, users.getFirstName());
            prSt.setString(2, users.getLastName());
            prSt.setString(3, users.getUserName());
            prSt.setString(4, users.getPassword());
            prSt.setString(5, users.getLocation());
            prSt.setString(6, users.getGender());
            prSt.executeUpdate();
        } catch (SQLException var4) {
            var4.printStackTrace();
        } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
        }

    }

    public ResultSet getUser(Users users) {
        ResultSet resSet = null;
        String select = "SELECT * FROM users WHERE login=? AND password=?";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            prSt.setString(1, users.getUserName());
            prSt.setString(2, users.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException var5) {
            var5.printStackTrace();
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        }

        return resSet;
    }
}
