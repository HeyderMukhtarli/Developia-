package ders20;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/java16",
                        "root", "1234");
        //String sql = "Select * from students";
        String sqlInsert = "insert into students (name , surname, age) values ('x', 'y', 50)";
        //Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();

        statement1.executeUpdate(sqlInsert);

        //ResultSet resultSet = statement.executeQuery(sql);

//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(1) + " -> " +
//                    resultSet.getString(2));
//        }

    }
}
