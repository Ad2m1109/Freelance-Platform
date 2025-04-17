package views.user;
import java.awt.*;
import javax.swing.*;
import views.MainView;
public class HomePage extends JFrame {
    @SuppressWarnings("unused")
    public HomePage() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

// Header:
        JPanel header = new JPanel();
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                new MainView().setVisible(true);
                dispose();
            }
        });

        header.setLayout(new FlowLayout(FlowLayout.RIGHT));
        header.add(logoutButton);

// Body
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        //nav bar
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Profile", new profile());
        tabbedPane.addTab("Projects", new Projects());
        tabbedPane.addTab("Settings", new Settings());
        tabbedPane.addTab("Notifications", new Notifications());
        body.add(tabbedPane, BorderLayout.CENTER);
        
// Footer:
        JPanel footer = new JPanel();
        

        // Add panels to the frame
        add(header, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }   
}
