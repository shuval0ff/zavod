package com.example.zavod;

import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class SignUpTest {

    @org.junit.Test
    public void test() throws SQLException {

        Users user = new Users();
        user.setUserName(randString());
        user.setPassword(randString());
        user.setFirstName(randString());
        user.setLastName(randString());
        user.setGender("Мужской");
        user.setLocation(randString());

        new Db().signUpUser(user);
        ResultSet response = new Db().getUser(user);

        response.next();
        String responseUsername = response.getString(4);
        String responsePassword = response.getString(5);

        Assert.assertEquals(responseUsername, user.getUserName());
        Assert.assertEquals(responsePassword, user.getPassword());

    }

    public String randString() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}