package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pp2_membership";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static MySqlConnection instance;
    private Connection connection;

    // Constructor private untuk pola Singleton
    private MySqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Gagal membuat koneksi ke database!");
            e.printStackTrace();
        }
    }

    // Metode untuk mendapatkan instance Singleton
    public static MySqlConnection getInstance() {
        if (instance == null) {
            synchronized (MySqlConnection.class) {
                if (instance == null) {
                    instance = new MySqlConnection();
                }
            }
        }
        return instance;
    }

    // Metode untuk mendapatkan koneksi
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan koneksi ke database!");
            e.printStackTrace();
        }
        return connection;
    }
}
