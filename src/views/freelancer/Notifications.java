package views.freelancer;
import java.awt.*;
import javax.swing.*;
import views.MainView;
public class Notifications extends JPanel {
    @SuppressWarnings("unused")
    public Notifications() {
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("Freelancer Notifications", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        header.add(title);

        // Body
        JPanel body = new JPanel();
        JLabel nameLabel = new JLabel("Notifications");
        body.add(nameLabel);
        // Footer
        JPanel footer = new JPanel();
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            // Add logout functionality here
            new MainView().setVisible(true); // Redirect to MainView
        });
        footer.add(logoutButton);

        // Add components to the frame
        add(header, BorderLayout.NORTH);
    }
}
