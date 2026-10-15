package diversao22;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

    // A pasta LABORATORIO precisa existir antes da execução.
    private static final File LABORATORIO =
            new File("LABORATORIO").toPath().toAbsolutePath().normalize().toFile();

    public static void main(String[] args) {

        if (!LABORATORIO.isDirectory()) {
            JOptionPane.showMessageDialog(
                    null,
                    "A pasta LABORATORIO não existe.\n"
                    + "Crie essa pasta antes de executar o programa.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        boolean executando = true;

        while (executando) {
            String menu = "ESCOLHA UMA OPÇÃO:\n"
                    + "1 - CRIAR ARQUIVO\n"
                    + "2 - ESCREVER NO ARQUIVO\n"
                    + "3 - LER ARQUIVO\n"
                    + "4 - RENOMEAR ARQUIVO\n"
                    + "5 - EXCLUIR ARQUIVO\n"
                    + "6 - MOSTRAR INFORMAÇÕES DO ARQUIVO\n"
                    + "7 - PROTEGER ARQUIVO (SOMENTE LEITURA)\n"
                    + "8 - SAIR";

            String op = JOptionPane.showInputDialog(null, menu, "GERENCIADOR DE ARQUIVOS",JOptionPane.QUESTION_MESSAGE
            );

            // Cancelar o menu retorna ao menu principal.
            if (op == null) {
                continue;
            }

            switch (op.trim()) {
                case "1":
                    criarArquivo();
                    break;
                case "2":
                    escreverArquivo();
                    break;
                case "3":
                    lerArquivo();
                    break;
                case "4":
                    renomearArquivo();
                    break;
                case "5":
                    excluirArquivo();
                    break;
                case "6":
                    mostrarInformacoes();
                    break;
                case "7":
                    protegerArquivo();
                    break;
                case "8":
                    JOptionPane.showMessageDialog(null, "SAINDO...");
                    executando = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!","Aviso", JOptionPane.WARNING_MESSAGE
                    );
                    break;
            }
        }
    }

    /*
     * Valida o nome e garante que o arquivo fique dentro de LABORATORIO.
     */
    private static File solicitarArquivo(String mensagem) {
        String nome = JOptionPane.showInputDialog(null, mensagem, "GERENCIADOR DE ARQUIVOS",JOptionPane.QUESTION_MESSAGE
        );

        if (nome == null) {
            return null;
        }

        nome = nome.trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NOME DO ARQUIVO INVÁLIDO!"
            );
            return null;
        }

        // Não aceita caminhos ou subpastas.
        if (nome.contains("/") || nome.contains("\\") || nome.equals(".") || nome.equals("..")) {
            JOptionPane.showMessageDialog(null,"Informe somente o nome do arquivo, por exemplo: atividade.txt.");
            return null;
        }

        Path pasta = LABORATORIO.toPath().toAbsolutePath().normalize();
        Path caminho = pasta.resolve(nome).normalize();

        if (!pasta.equals(caminho.getParent())) {
            JOptionPane.showMessageDialog(null, "CAMINHO INVÁLIDO!");
            return null;
        }

        return caminho.toFile();
    }

    private static void criarArquivo() {
        File arquivo = solicitarArquivo("NOME DO ARQUIVO COM EXTENSÃO (ex: atividade.txt):");

        if (arquivo == null) {
            return;
        }

        if (arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O ARQUIVO JÁ EXISTE!");
            return;
        }

        try {
            if (arquivo.createNewFile()) {
                JOptionPane.showMessageDialog(null,"ARQUIVO CRIADO COM SUCESSO EM LABORATORIO!");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO AO CRIAR ARQUIVO!");
            }
        } catch (IOException e) {
            mostrarErro("ERRO AO CRIAR ARQUIVO", e);
        }
    }

    private static void escreverArquivo() {
        File arquivo = solicitarArquivo(
                "NOME DO ARQUIVO PARA ESCREVER:"
        );

        if (arquivo == null) {
            return;
        }

        if (!arquivo.isFile()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ARQUIVO NÃO ENCONTRADO OU CAMINHO INVÁLIDO!"
            );
            return;
        }

        if (!arquivo.canWrite()) {
            JOptionPane.showMessageDialog(
                    null,
                    "O ARQUIVO ESTÁ PROTEGIDO CONTRA GRAVAÇÃO!"
            );
            return;
        }

        String texto = JOptionPane.showInputDialog(
                null, "DIGITE O TEXTO A SER GRAVADO:",
                "ESCREVER NO ARQUIVO",
                JOptionPane.QUESTION_MESSAGE
        );

        if (texto == null) {
            return;
        }

        // Acrescenta o texto ao final do arquivo.
        try {
            Files.writeString(
                    arquivo.toPath(),
                    texto + System.lineSeparator(),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND
            );

            JOptionPane.showMessageDialog(
                    null, "TEXTO GRAVADO COM SUCESSO!"
            );
        } catch (IOException e) {
            mostrarErro("ERRO AO ESCREVER NO ARQUIVO", e);
        }
    }

    private static void lerArquivo() {
        File arquivo = solicitarArquivo(
                "NOME DO ARQUIVO PARA LER:"
        );

        if (arquivo == null) {
            return;
        }

        if (!arquivo.isFile()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ARQUIVO NÃO ENCONTRADO OU CAMINHO INVÁLIDO!"
            );
            return;
        }

        StringBuilder conteudo = new StringBuilder();

        try (Scanner leitor = new Scanner(
                arquivo, StandardCharsets.UTF_8)) {

            while (leitor.hasNextLine()) {
                conteudo.append(leitor.nextLine())
                        .append(System.lineSeparator());
            }

            if (conteudo.length() == 0) {
                JOptionPane.showMessageDialog(
                        null, "O ARQUIVO ESTÁ VAZIO!"
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "CONTEÚDO DO ARQUIVO:\n\n" + conteudo,
                        "LER ARQUIVO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (IOException e) {
            mostrarErro("ERRO AO LER ARQUIVO", e);
        }
    }

    private static void renomearArquivo() {
        File atual = solicitarArquivo(
                "NOME ATUAL DO ARQUIVO:"
        );

        if (atual == null) {
            return;
        }

        if (!atual.isFile()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ARQUIVO NÃO ENCONTRADO OU CAMINHO INVÁLIDO!"
            );
            return;
        }

        File novo = solicitarArquivo(
                "NOVO NOME DO ARQUIVO:"
        );

        if (novo == null) {
            return;
        }

        if (novo.exists()) {
            JOptionPane.showMessageDialog(
                    null,
                    "JÁ EXISTE UM ARQUIVO COM ESTE NOVO NOME!"
            );
            return;
        }

        try {
            Files.move(atual.toPath(), novo.toPath());

            JOptionPane.showMessageDialog(
                    null, "ARQUIVO RENOMEADO COM SUCESSO!"
            );
        } catch (IOException e) {
            mostrarErro("FALHA AO RENOMEAR ARQUIVO", e);
        }
    }

    private static void excluirArquivo() {
        File arquivo = solicitarArquivo(
                "NOME DO ARQUIVO A EXCLUIR:"
        );

        if (arquivo == null) {
            return;
        }

        if (!arquivo.isFile()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ARQUIVO NÃO ENCONTRADO OU CAMINHO INVÁLIDO!"
            );
            return;
        }

        int confirma = JOptionPane.showConfirmDialog(
                null,
                "TEM CERTEZA QUE DESEJA EXCLUIR O ARQUIVO '"
                        + arquivo.getName() + "'?",
                "CONFIRMAÇÃO DE EXCLUSÃO",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirma != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    null, "EXCLUSÃO CANCELADA!"
            );
            return;
        }

        try {
            Files.delete(arquivo.toPath());

            JOptionPane.showMessageDialog(
                    null, "ARQUIVO EXCLUÍDO COM SUCESSO!"
            );
        } catch (IOException e) {
            mostrarErro("FALHA AO EXCLUIR O ARQUIVO", e);
        }
    }

    private static void mostrarInformacoes() {
        File arquivo = solicitarArquivo(
                "NOME DO ARQUIVO PARA CONSULTAR:"
        );

        if (arquivo == null) {
            return;
        }

        if (!arquivo.isFile()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ARQUIVO NÃO ENCONTRADO OU CAMINHO INVÁLIDO!"
            );
            return;
        }

        String nome = arquivo.getName();
        String extensao;
        int idx = nome.lastIndexOf('.');

        if (idx > 0 && idx < nome.length() - 1) {
            extensao = nome.substring(idx + 1);
        } else {
            extensao = "Sem extensão";
        }

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String ultimaModificacao =
                sdf.format(new Date(arquivo.lastModified()));

        String info = "INFORMAÇÕES DO ARQUIVO:\n\n"
                + "NOME: " + nome + "\n"
                + "EXTENSÃO: " + extensao + "\n"
                + "TAMANHO: " + arquivo.length() + " bytes\n"
                + "CAMINHO: " + arquivo.getAbsolutePath() + "\n"
                + "LEITURA: "
                + (arquivo.canRead() ? "SIM" : "NÃO") + "\n"
                + "GRAVAÇÃO: "
                + (arquivo.canWrite() ? "SIM" : "NÃO") + "\n"
                + "EXECUÇÃO: "
                + (arquivo.canExecute() ? "SIM" : "NÃO") + "\n"
                + "ÚLTIMA MODIFICAÇÃO: " + ultimaModificacao;

        JOptionPane.showMessageDialog(
                null, info,
                "INFORMAÇÕES DO ARQUIVO",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private static void protegerArquivo() {
        File arquivo = solicitarArquivo(
                "NOME DO ARQUIVO PARA PROTEGER:"
        );

        if (arquivo == null) {
            return;
        }

        if (!arquivo.isFile()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ARQUIVO NÃO ENCONTRADO OU CAMINHO INVÁLIDO!"
            );
            return;
        }

        boolean alterado = arquivo.setReadOnly();

        if (alterado && !arquivo.canWrite()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ARQUIVO DEFINIDO COMO SOMENTE LEITURA!\n"
                    + "Consulte a opção 6 para verificar a gravação."
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "NÃO FOI POSSÍVEL CONFIRMAR A PROTEÇÃO DO ARQUIVO."
            );
        }
    }

    private static void mostrarErro(
            String mensagem, Exception e) {

        JOptionPane.showMessageDialog(
                null,
                mensagem + ":\n" + e.getMessage(),
                "ERRO",
                JOptionPane.ERROR_MESSAGE
        );
    }
}