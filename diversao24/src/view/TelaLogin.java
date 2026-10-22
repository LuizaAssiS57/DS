package view;

import controle.LoginControle;
import java.awt.*;
import javax.swing.*;

public class TelaLogin extends JFrame {

    private LoginControle controle = new LoginControle();

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;

    public TelaLogin() {
        setTitle("Login no Sistema");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        criarInterface();
        configurarEventos();
    }

    private void criarInterface() {
        JPanel painelCentral = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painelCentral.add(new JLabel("Usuário:"));
        txtUsuario = new JTextField();
        painelCentral.add(txtUsuario);

        painelCentral.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        painelCentral.add(txtSenha);

        add(painelCentral, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel();
        btnEntrar = new JButton("Entrar");
        painelInferior.add(btnEntrar);

        add(painelInferior, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        btnEntrar.addActionListener(e -> autenticar());
    }

    private void autenticar() {
        String usuario = txtUsuario.getText().trim();
        String senha = new String(txtSenha.getPassword());

        if (controle.autenticar(usuario, senha)) {
            TelaProduto telaProduto = new TelaProduto();
            telaProduto.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }
}