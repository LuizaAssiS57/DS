package caixadedialogo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {
        ArrayList<String> produtos = new ArrayList<>();

        boolean executando = true;

        while (executando) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha uma opção:\n" + "1 - Cadastrar produto\n" + "2 - Listar produtos\n" + "3 - Sair", "Menu Principal", JOptionPane.QUESTION_MESSAGE);
            if (opcao == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada");
                break;
            }

            switch (opcao) {
                case "1":
                    String produto = JOptionPane.showInputDialog(null, "Digite o nome do produto: ", "Cadastro de produto", JOptionPane.QUESTION_MESSAGE);
                    if (produto == null || produto.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
                    }else{
                        produtos.add(produto);
                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    }
                    break;
                case "2":
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum produto não cadastrado!");
                    }else{
                        String lista = "Produtos cadastrados\n\n";

                        for (int i = 0; i < produtos.size(); i++) {
                            lista += (i + 1) + " - " + produtos.get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, lista, "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    executando = false;
                    break;
            
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}
