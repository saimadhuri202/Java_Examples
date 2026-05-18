package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnection{
    static void loadDriver(){
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    } 
    catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    static Connection getConnection(){
    try {
        loadDriver();
        Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521/FREEPDB1",
            "system",
            "managedb"
        );
        return conn;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
    static void closeConnection(Connection conn){
        try{
            if (conn != null){
                conn.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 