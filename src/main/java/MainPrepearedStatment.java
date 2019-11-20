package main.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class MainPrepearedStatment {
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=UTC";//адрес сервера
    private final static String USERNAME = "root";
    private final static String PASSWORD = "********";

    //    private final static String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";//добавление записей в таблицу dish
    private final static String GET_ALL = "SELECT * FROM mydbtest.dish";//показать все записи в таблце mydbtest.dish
    private final static String DELETE = "DELETE FROM mydbtest.dish WHERE id=?";//удаление запиписи в таблице mydbtest.dish под id=?

    public static void main(String[] args) throws SQLException {

        PreparedStatement preparedStatement = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)){//подключение к серверу


            preparedStatement = connection.prepareStatement(DELETE);//выполнение команды на удаление
            preparedStatement.setInt(1, 1);//удаление первой записи в таблице
            preparedStatement.executeUpdate();// выполнить обновление

            preparedStatement = connection.prepareStatement(GET_ALL);//выполнение команды показать все записи в таблце mydbtest.dish

//            preparedStatement = connection.prepareStatement(INSERT_NEW);//выполнение команды на добавление
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "Inserted title");
//            preparedStatement.setString(3, "Inserted desc");
//            preparedStatement.setFloat(4, 0.2f);
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7, new FileInputStream("javaCapture.svg"));
//            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.executeQuery();// выполнить запрос
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date created = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("id: " + id
                        + "\ntitle: " + title
                        + "\ndescription: " + description
                        + "\nrating: " + rating
                        + "\npublished: " + published
                        + "\ncreated: " + created
                        + "\nicon: " + icon.length);
            }
//        } catch (SQLException | FileNotFoundException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
