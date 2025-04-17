package views;
import java.awt.*;
import javax.swing.*;
public class findPassword extends JFrame{
    public findPassword() {

    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

//header:
    JPanel header = new JPanel();
    header.setLayout(new FlowLayout(FlowLayout.RIGHT));
    JButton logoutButton = new JButton("Logout");
    logoutButton.addActionListener(e -> {
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            new MainView().setVisible(true);
            dispose();
        }
    });
    header.add(logoutButton);

//body
    JPanel body = new JPanel();
    body.setLayout(new BorderLayout());

//footer
    JPanel footer = new JPanel();

    add(header, BorderLayout.NORTH);
    add(body, BorderLayout.CENTER);
    add(footer, BorderLayout.SOUTH);
}
}
  
