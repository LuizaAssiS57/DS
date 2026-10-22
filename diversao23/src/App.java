import javax.swing.SwingUtilities;

import view.ClienteView;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            ClienteView janela = new ClienteView();
            janela.setVisible(true);
        });
    }
}
