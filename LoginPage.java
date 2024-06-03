import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Flow;
import java.util.zip.GZIPOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class LoginPage extends JFrame implements ActionListener {
    JTextField userUsernameField = new JTextField("username");
    JPasswordField userPasswordField = new JPasswordField("password");
    JButton submitFieldsButton = new JButton();
    JButton signUpButton = new JButton();
    JPanel container;

    public LoginPage()  {
        setSize(450, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        getContentPane().setBackground(Color.WHITE);
        formatFields(); 
 
       
        setVisible(true);
    }

    private void formatFields() {
        userUsernameField.setPreferredSize(new Dimension(200, 25));
        userPasswordField.setPreferredSize(new Dimension(200, 25));
        submitFieldsButton.setText("Log In");
        signUpButton.setText("Sign Up");
        submitFieldsButton.addActionListener(this);
        signUpButton.addActionListener(this);
        
        
        container = new JPanel();
        BoxLayout box = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setBorder(new EmptyBorder(new Insets(100, 50, 50, 50)));
        container.setPreferredSize(new Dimension(300, 350));
        container.setBackground(Color.LIGHT_GRAY);

        container.add(userUsernameField);
        container.add(Box.createRigidArea(new Dimension(300, 0)));
        container.add(userPasswordField);
        container.add(submitFieldsButton);
        container.add(signUpButton);

        add(container);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(submitFieldsButton)) {
            try{
                logIn();
            }
            catch(SQLException err) {
                
            }
        }

        if(e.getSource().equals(signUpButton)) {
            new SignUp();
            this.dispose();
        }
    }


    private void logIn() throws SQLException {
        final String USER_NAME = userUsernameField.getText();
        final String USER_PASSWORD = String.valueOf(userPasswordField.getPassword());
        Server s = new Server();
        if(s.userExist(USER_NAME)) {
            if(s.validateUser(USER_NAME, USER_PASSWORD)) {
                
                new Profile(USER_NAME);
                dispose();

            }
            else {
                 System.out.println("wrong password");
            }
        } else {
            System.out.println("No no exist");
        }
        
    }

    
}
