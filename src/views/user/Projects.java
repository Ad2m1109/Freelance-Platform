package views.user;
import java.awt.*;
import javax.swing.*;
import views.MainView;
public class Projects extends JPanel {
    @SuppressWarnings("unused")
    public Projects() {
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("Freelancer Projects", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        header.add(title);

        // Body
        JPanel body = new JPanel();
        JLabel nameLabel = new JLabel("Projects Page");
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
