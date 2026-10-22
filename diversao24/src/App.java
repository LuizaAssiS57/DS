import view.TelaLogin;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            TelaLogin janelaLogin = new TelaLogin();
            janelaLogin.setVisible(true);
        });
    }
}