package view;

import controle.ProdutoControle;
import modelo.Produto;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaProduto extends JFrame {

    private final ProdutoControle controle = new ProdutoControle();

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtCategoria;
    private JTextField txtPreco;
    private JTextField txtQuantidade;

    private JButton btnCadastrar;
    private JButton btnBuscar;
    private JButton btnAlterar;
    private JButton btnExcluir;
    private JButton btnListar;
    private JButton btnLimpar;

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public TelaProduto() {
        setTitle("Gerenciamento de Produtos");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        criarInterface();
        configurarEventos();
        atualizarTabela();
    }

    private void criarInterface() {
        JLabel titulo = new JLabel("GERENCIAMENTO DE PRODUTOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(30, 60, 100));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        add(titulo, BorderLayout.NORTH);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        add(painelPrincipal, BorderLayout.CENTER);

        JPanel painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setBorder(BorderFactory.createTitledBorder("Dados do Produto"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        painelCadastro.add(new JLabel("ID:"), gbc);
        txtId = new JTextField(15);
        gbc.gridx = 1;
        painelCadastro.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        painelCadastro.add(new JLabel("Nome:"), gbc);
        txtNome = new JTextField(25);
        gbc.gridx = 1;
        painelCadastro.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        painelCadastro.add(new JLabel("Categoria:"), gbc);
        txtCategoria = new JTextField(25);
        gbc.gridx = 1;
        painelCadastro.add(txtCategoria, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        painelCadastro.add(new JLabel("Preço:"), gbc);
        txtPreco = new JTextField(15);
        gbc.gridx = 1;
        painelCadastro.add(txtPreco, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        painelCadastro.add(new JLabel("Quantidade:"), gbc);
        txtQuantidade = new JTextField(15);
        gbc.gridx = 1;
        painelCadastro.add(txtQuantidade, gbc);

        painelPrincipal.add(painelCadastro, BorderLayout.NORTH);

        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Nome", "Categoria", "Preço", "Quantidade"}, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabela = new JTable(modeloTabela);
        tabela.setRowHeight(25);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBorder(BorderFactory.createTitledBorder("Produtos Cadastrados"));

        painelPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout());

        btnCadastrar = new JButton("Cadastrar");
        btnBuscar = new JButton("Buscar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnListar = new JButton("Listar");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnLimpar);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        btnCadastrar.addActionListener(e -> cadastrar());
        btnBuscar.addActionListener(e -> buscar());
        btnAlterar.addActionListener(e -> alterar());
        btnExcluir.addActionListener(e -> excluir());
        btnListar.addActionListener(e -> atualizarTabela());
        btnLimpar.addActionListener(e -> limparCampos());

        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() != -1) {
                int linha = tabela.convertRowIndexToModel(tabela.getSelectedRow());
                txtId.setText(modeloTabela.getValueAt(linha, 0).toString());
                txtNome.setText(modeloTabela.getValueAt(linha, 1).toString());
                txtCategoria.setText(modeloTabela.getValueAt(linha, 2).toString());
                txtPreco.setText(modeloTabela.getValueAt(linha, 3).toString());
                txtQuantidade.setText(modeloTabela.getValueAt(linha, 4).toString());
            }
        });
    }

    private void cadastrar() {
        try {
            int id = lerId();
            String nome = lerNome();
            String categoria = lerCategoria();
            double preco = lerPreco();
            int quantidade = lerQuantidade();

            if (controle.buscar(id) != null) {
                mostrarMensagem("ID já cadastrado!");
                return;
            }

            controle.cadastrar(id, nome, categoria, preco, quantidade);
            mostrarMensagem("Produto cadastrado com sucesso!");
            atualizarTabela();
            limparCampos();

        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        }
    }

    private void buscar() {
        try {
            int id = lerId();
            Produto produto = controle.buscar(id);

            if (produto != null) {
                txtNome.setText(produto.getNome());
                txtCategoria.setText(produto.getCategoria());
                txtPreco.setText(String.valueOf(produto.getPreco()));
                txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
                mostrarMensagem("Produto encontrado!");
            } else {
                mostrarMensagem("Produto não encontrado!");
            }
        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        }
    }

    private void alterar() {
        try {
            int id = lerId();
            String nome = lerNome();
            String categoria = lerCategoria();
            double preco = lerPreco();
            int quantidade = lerQuantidade();

            boolean alterado = controle.alterar(id, nome, categoria, preco, quantidade);

            if (alterado) {
                mostrarMensagem("Produto alterado com sucesso!");
                atualizarTabela();
                limparCampos();
            } else {
                mostrarMensagem("Produto não encontrado!");
            }
        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        }
    }

    private void excluir() {
        try {
            int id = lerId();
            Produto produto = controle.buscar(id);

            if (produto == null) {
                mostrarMensagem("Produto não encontrado!");
                return;
            }

            int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o produto?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                boolean removido = controle.remover(id);
                if (removido) {
                    mostrarMensagem("Produto excluído com sucesso!");
                    atualizarTabela();
                    limparCampos();
                }
            }
        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        }
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Produto produto : controle.listar()) {
            modeloTabela.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getCategoria(),
                    produto.getPreco(),
                    produto.getQuantidade()
            });
        }
    }

    private void limparCampos() {
        tabela.clearSelection();
        txtId.setText("");
        txtNome.setText("");
        txtCategoria.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
        txtId.requestFocusInWindow();
    }

    private int lerId() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            if (id <= 0) throw new NumberFormatException();
            return id;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Informe um ID inteiro positivo!");
        }
    }

    private String lerNome() {
        String nome = txtNome.getText().trim();
        if (nome.isEmpty()) throw new IllegalArgumentException("Informe o nome do produto!");
        return nome;
    }

    private String lerCategoria() {
        String categoria = txtCategoria.getText().trim();
        if (categoria.isEmpty()) throw new IllegalArgumentException("Informe a categoria do produto!");
        return categoria;
    }

    private double lerPreco() {
        try {
            double preco = Double.parseDouble(txtPreco.getText().trim().replace(",", "."));
            if (preco < 0) throw new NumberFormatException();
            return preco;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Informe um preço válido!");
        }
    }

    private int lerQuantidade() {
        try {
            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            if (quantidade < 0) throw new NumberFormatException();
            return quantidade;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Informe uma quantidade válida!");
        }
    }

    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}