import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JFrame {
    private User user;
    public Profile(String u) throws SQLException {
       user = new User(u);
       
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(100, 100));
        p.setBackground(Color.RED);

        JLabel f = new JLabel(user.getFirstName());
        JLabel l = new JLabel(user.getLastName());
        JLabel us = new JLabel(user.getUsername());
        JLabel fo = new JLabel(String.valueOf(user.getFollowers()));

        p.add(f);
        p.add(l);
        p.add(us);
        p.add(fo);

        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.NORTH);
        setTab();
    
        this.setVisible(true);
    }


    public void setTab() throws SQLException{
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(100, 100));
        p.setBackground(Color.BLUE);
        this.add(p, BorderLayout.WEST);
    }
}
