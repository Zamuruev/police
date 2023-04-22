package piu.fast_project;

import java.sql.*;

public class MySQLConnection {

    // Экземпляр класса для Singleton
    private static MySQLConnection instance = null;

    private Connection connection;

    private MySQLConnection() {
        // Установка соединения с базой данных MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/pistol";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MySQLConnection getInstance() {
        // Получение единственного экземпляра класса
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        // Получение объекта Connection
        return connection;
    }
}
