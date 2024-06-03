import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainPage extends JFrame implements ActionListener {
    JButton button;
    ImageIcon m = new ImageIcon("average scottsdale resident.jpg");
    public MainPage() {
    
        
        
        this.setTitle("le Bron james");
        this.setSize(800, 500);
        this.setLocation(new Point(500, 300));
        this.setLocale(Locale.US);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println("clicked");
        }
    }

}
