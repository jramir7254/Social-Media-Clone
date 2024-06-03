import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame implements ActionListener {
    JTextField newUserFirstNameField = new JTextField();
    JTextField newUserLastNameField = new JTextField();
    JTextField newUserUsernameField = new JTextField();
    JTextField newUserEmailField = new JTextField();
    JTextField newUserPhoneNumberField = new JTextField();
    JTextField newUserBirthdayField = new JTextField();
    JTextField newUserPassworField = new JTextField();
    JButton signUpButton = new JButton("Sign Up");
    JButton goBackButton = new JButton("Go Back");

    public SignUp() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        addFields();
        setVisible(true);
    }

    public void addFields() {
        newUserFirstNameField.setPreferredSize(new Dimension(500, 25));
        newUserLastNameField.setPreferredSize(new Dimension(500, 25));
        newUserUsernameField.setPreferredSize(new Dimension(500, 25));
        newUserEmailField.setPreferredSize(new Dimension(500, 25));
        newUserPhoneNumberField.setPreferredSize(new Dimension(500, 25));
        newUserBirthdayField.setPreferredSize(new Dimension(500, 25));
        newUserPassworField.setPreferredSize(new Dimension(500, 25));

        goBackButton.addActionListener(e -> {
            new LoginPage();
            dispose();
        });


        JPanel p = new JPanel();
        BoxLayout b = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setPreferredSize(new Dimension(600, 550));
        p.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));

        p.add(newUserFirstNameField);
        p.add(newUserLastNameField);
        p.add(newUserUsernameField);
        p.add(newUserEmailField);
        p.add(newUserPhoneNumberField);
        p.add(newUserBirthdayField);
        p.add(newUserPassworField);
        p.add(signUpButton);
        p.add(goBackButton);

        add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
