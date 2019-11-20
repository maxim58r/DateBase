package main.java;

import java.sql.*;

public class TestDB {
    /*private final static String URLFIXED = "jdbc:mysql://localhost:3306/mydbtest" +
            "?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";*/
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=UTC";
    private final static String USERNAME = "DBroot";
    private final static String PASSWORD = "***********";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

//            statement.execute("INSERT INTO users(name, age, email, password) VALUES('Michael', 34, 'dred@mail.ru', 'qwerty');");//добавить новую запись в таблицу users
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");//выполнить команду
//            int res = statement.executeUpdate("UPDATE users SET name='Elen' WHERE id=4;");//изменить запись под id=4 на Elen
//            int res = statement.executeUpdate("UPDATE users SET name='Glen' WHERE id=5;");//изменить запись под id=5 на Glen
//            statement.addBatch("INSERT INTO users(name, age, email, password) VALUES('Yuri', 19, 'rex@yandex.ru', 'DogSun');");//добавить новую запись в таблицу users
//            statement.addBatch("INSERT INTO users(name, age, email, password) VALUES('Mitchel', 14, 'mitch@gmail.com', 'fgtruk');");//добавить новую запись в таблицу users
//            statement.addBatch("INSERT INTO users(name, age, email, password) VALUES('Jim', 21, 'jim@mail.ru', 'Mtefdldl');");//добавить новую запись в таблицу users
//            statement.executeBatch();//ваполнить все statement.addBatch запросы
//            statement.clearBatch();//стереть все statement.addBatch запросы

            statement.getConnection();//получение соединение с базой данных
            statement.close();//закрыть соединение с базой данных, не обязательно если поместили в try/catch(Connection & Statement)
            boolean status = statement.isClosed();
            System.out.println(status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
