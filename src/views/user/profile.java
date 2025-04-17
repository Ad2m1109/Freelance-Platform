package views.user;
import java.awt.*;
import javax.swing.*;
public class profile extends JPanel{
    public profile() {
        setSize(800, 600);
        setLayout(new BorderLayout());

// Header:
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(2, 1));
        JLabel title = new JLabel("welcome adem youssfi", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        header.add(title);

// Body
        JPanel body = new JPanel();
        JLabel nameLabel = new JLabel("profile");
        body.add(nameLabel);
        
        
        
// Footer:
        JPanel footer = new JPanel();

        // Add panels to the frame
        add(header, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }  
    public static void main(String[] args) {
        new profile().setVisible(true);  
    }      
}
