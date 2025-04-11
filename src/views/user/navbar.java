package views.user;
import java.awt.*;
import javax.swing.*;
public class navbar extends JPanel{
    @SuppressWarnings("unused")
    public navbar(JFrame parent) {
        setLayout(new GridLayout(1, 3));
        JButton homeButton = new JButton("Home");
        JButton profileButton = new JButton("Profile");
        JButton NotificationsButton = new JButton("Notifications");
        add(homeButton);
        add(profileButton);
        add(NotificationsButton);
        homeButton.addActionListener(e -> {
            parent.dispose();
            new HomePage().setVisible(true);
        });
        profileButton.addActionListener(e -> {
            parent.dispose();
            new profile().setVisible(true);
        });
        NotificationsButton.addActionListener(e -> {
            parent.dispose();
            new Notifications().setVisible(true);
        });
    }
}
