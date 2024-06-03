import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private int followers;
    private int following;

    public User(String u) throws SQLException{
        Server s = new Server();
        ArrayList<Object> i = s.constructUser(u);
        firstName = (String)(i.get(0));
        lastName = (String)i.get(1);
        username = (String)i.get(2);
        followers = (int)i.get(3);
    }
    

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getUsername() { return username; }

    public int getFollowers() { return followers; }
}
