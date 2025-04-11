package views;
import java.awt.*;
import javax.swing.*;
public class MainView extends JFrame {
    @SuppressWarnings("unused")
    public MainView() {
        setTitle("Main View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//headar:
        JPanel header = new JPanel();
        // Load and resize the image
        ImageIcon icon = new ImageIcon("src/resources/images/logo.png");
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        JLabel logo = new JLabel(resizedIcon);
        header.add(logo);
//body:
        JPanel body = new JPanel();
        JLabel title = new JLabel("Freelancer", SwingConstants.CENTER);
        JLabel subtitle = new JLabel("Welcome to this freelance platform", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        body.setLayout(new BorderLayout());
        body.add(title, BorderLayout.NORTH);
        body.add(subtitle, BorderLayout.CENTER);
        body.setBackground(Color.orange);
//footer:
        JPanel footer = new JPanel();
        JButton b1=new JButton("Login");
        JButton b2=new JButton("Register");
        b1.addActionListener(e -> {
            new LoginView().setVisible(true);
            this.dispose();
        });
        b2.addActionListener(e -> {
            new RegisterView().setVisible(true);
            this.dispose();
        });   
        footer.add(b1);
        footer.add(b2);

//main:
        add(header, "North");
        add(body, "Center");
        add(footer, "South");
        
    }
}
