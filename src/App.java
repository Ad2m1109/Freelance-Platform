import views.MainView;
import utils.DBConnector;
public class App {
    public static void main(String[] args) {
        // Initialize database connection
        DBConnector.init();
        
        // Start the application
        new MainView().setVisible(true);
    }
}