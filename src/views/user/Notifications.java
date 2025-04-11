package views.user;
import java.awt.*;
import javax.swing.*;
import views.MainView;
public class Notifications extends JFrame {
    @SuppressWarnings("unused")
    public Notifications() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Header
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("User Notifications", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        // Nav bar
        navbar navBar = new navbar(this);
        header.add(title);
        header.add(navBar);

        // Body
        JPanel body = new JPanel();
        // Footer
        JPanel footer = new JPanel();
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            // Add logout functionality here
            this.dispose();
            new MainView().setVisible(true); // Redirect to MainView
        });
        footer.add(logoutButton);

        // Add components to the frame
        add(header, BorderLayout.NORTH);
    }
}
