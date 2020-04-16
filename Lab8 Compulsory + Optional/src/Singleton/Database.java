package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*Create the singleton class Database that manages a connection to the database.*/
public class Database {
    /*https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html*/
    private static Connection connection = null;
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String user = "florentina";
    private static final String password = "sql";

    private Database() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Connection getConnection() {
        return connection;
    }
    public static void rollback() throws SQLException, ClassNotFoundException {
        Statement statement = getConnection().createStatement();
        statement.executeQuery("DELETE * FROM artists");
        statement.executeQuery("DELETE * FROM albums");
    }
    public static void commit() throws SQLException{ connection.commit(); }
    public static void closeConnection() throws SQLException{ connection.close(); }
}
