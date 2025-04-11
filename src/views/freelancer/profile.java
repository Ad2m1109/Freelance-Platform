package views.freelancer;
import java.awt.*;
import javax.swing.*;
public class profile extends JFrame{
    @SuppressWarnings("unused")
    public profile() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

// Header:
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(2, 1));
        JLabel title = new JLabel("Freelancer Home Page", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        //nav bar
        navbar navBar = new navbar(this);
        
        header.add(title);
        header.add(navBar);

// Body
        JPanel body = new JPanel();
      
// Footer:
        JPanel footer = new JPanel();

        // Add panels to the frame
        add(header, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }   
    
}
