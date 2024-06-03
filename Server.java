import java.sql.*;
import java.util.ArrayList;

public class Server {
    static String url = "url goes here";
    static String username = "username goes here";
    static String password = "password goes here";
    

    public Server() {
       // establishConnection();
    }

    public void establishConnection() {
        try(Connection c = DriverManager.getConnection(url, username, password)) {
            System.out.println("connection establieshed");
       
            
        }
        catch(SQLException e) {
            System.out.println("problem establieshing connection");
        }
    }

    public boolean userExist(String name) throws SQLException {
        Connection c = DriverManager.getConnection(url, username, password);
        return userExist(c, name);
    }

    public boolean userExist(Connection c, String name) throws SQLException {
        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users WHERE user_username = \"" + name + "\";");
        resultSet.next();
        boolean exist = resultSet.getInt("count(*)") > 0;
        if(exist) return true;
        return false;
    }

    public boolean validateUser(String u, String p) throws SQLException {
        Connection c = DriverManager.getConnection(url, username, password);
        return validateUser(c, u, p);
    }

    public ArrayList<Object> constructUser(String u)  throws SQLException {
        ArrayList<Object> info = new ArrayList<>();
        Connection c = DriverManager.getConnection(url, username, password);
        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE user_username = \"" + u + "\";");
        
        resultSet.next();
        info.add(resultSet.getString("user_first_name"));
        info.add(resultSet.getString("user_last_name"));
        info.add(resultSet.getString("user_username"));
        info.add(resultSet.getInt("user_followers"));
        return info;
        
    }

    public boolean validateUser(Connection c, String u, String p) throws SQLException {
        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT user_password FROM users WHERE user_username = \"" + u + "\";");
        resultSet.next();
        if(resultSet.getString("user_password").equals(p)) {
            return true;
        }
        return false;
    }
}
