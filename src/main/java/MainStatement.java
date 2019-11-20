package main.java;

import main.java.DBWorker;
import main.java.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainStatement {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

//        String query = "SELECT * FROM users";
//        String query = "SELECT * FROM users WHERE name='Jim'";
        String query = "SELECT * FROM users WHERE age > 30 AND age < 38";
//        int query = "UPDATE * SET email='elendra@mail.ru', password='Szxcvb543' WHERE id=4;";

        try (Statement statement = worker.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
//           int resultSet = statement.executeUpdate(query);

            while (resultSet.next()) {
                User user = new User();
                
//                user.setId(resultSet.getInt(1));
//                user.setName(resultSet.getString(2));
//                user.setAge(resultSet.getInt(3));
//                user.setEmail(resultSet.getString(4));
//                user.setPassword(resultSet.getString(5));
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
