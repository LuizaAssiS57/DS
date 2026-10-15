package diversao22;
// JOptionPane permite mostrar caixas de entrada, avisos e confirmações.
import javax.swing.JOptionPane;
// IOException representa falhas de acesso, leitura ou gravação de arquivos.
import java.io.IOException;
// UTF-8 define como os caracteres do texto serão armazenados e lidos.
import java.nio.charset.StandardCharsets;
// Files oferece operações como criar, escrever, ler, renomear e excluir.
import java.nio.file.Files;
// Path representa o caminho de um arquivo ou diretório.
import java.nio.file.Path;
// Paths ajuda a construir um objeto Path a partir de um nome.
import java.nio.file.Paths;
// FileTime representa a data e a hora de alteração de um arquivo.
import java.nio.file.attribute.FileTime;
// Estas classes formatam e representam datas.
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Gerenciador de arquivos por caixas de diálogo.
 * Todas as operações são feitas dentro da pasta LABORATORIO.
 */
public class GerenciadorArquivos {
    // Pasta fixa do sistema: transforma o nome em caminho absoluto e normalizado.
    // Exemplo: C:\projetos\GerenciadorArquivos\LABORATORIO (no Windows).
    private static final Path PASTA = Paths.get("LABORATORIO").toAbsolutePath().normalize();

    // main é o ponto de entrada do programa.
    public static void main(String[] args) {
        // A atividade exige que LABORATORIO já exista. Se não existir, encerra.
        if (!Files.isDirectory(PASTA)) {
            JOptionPane.showMessageDialog(null,
                "A pasta LABORATORIO não existe.\nCrie a pasta em: " + PASTA,
                "Pasta não encontrada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Repete o menu indefinidamente, até a pessoa escolher Sair.
        while (true) {
            String escolha = JOptionPane.showInputDialog(null,
                "GERENCIADOR DE ARQUIVOS\n\n" +
                "1 - Criar arquivo\n" +
                "2 - Escrever no arquivo\n" +
                "3 - Ler arquivo\n" +
                "4 - Renomear arquivo\n" +
                "5 - Excluir arquivo\n" +
                "6 - Mostrar informações do arquivo\n" +
                "7 - Sair\n" +
                "8 - Tornar arquivo somente leitura (desafio)\n\n" +
                "Digite a opção:");

            // Clicar em Cancelar produz null. continue exibe o menu novamente.
            if (escolha == null) continue;

            // trim remove espaços antes/depois da opção informada.
            // switch escolhe o método correspondente à opção.
            switch (escolha.trim()) {
                case "1": criar(); break;
                case "2": escrever(); break;
                case "3": ler(); break;
                case "4": renomear(); break;
                case "5": excluir(); break;
                case "6": informacoes(); break;
                case "7":
                    JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                    return; // Encerra o método main e, portanto, o programa.
                case "8": somenteLeitura(); break;
                default: mensagem("Opção inválida.");
            }
        }
    }

    // Retorna null se o usuário cancelar ou informar um nome inválido.
    // Pede o nome do arquivo e devolve seu caminho completo dentro de LABORATORIO.
    // Se a pessoa cancelar ou digitar algo inválido, devolve null.
    private static Path solicitarArquivo(String pergunta) {
        String nome = JOptionPane.showInputDialog(null, pergunta);
        if (nome == null) return null;
        nome = nome.trim(); // Remove espaços extras nas pontas do nome.
        // Aceita apenas nome de arquivo, sem barras ou caminhos externos.
        if (nome.isEmpty() || nome.equals(".") || nome.equals("..") ||
            nome.contains("/") || nome.contains("\\") || nome.contains(":")) {
            mensagem("Nome inválido. Informe somente o nome do arquivo, com extensão.");
            return null;
        }
        // resolve acrescenta o nome à pasta; normalize simplifica o caminho.
        Path arquivo = PASTA.resolve(nome).normalize();
        // Confirma que o pai do arquivo continua sendo a pasta permitida.
        if (!arquivo.getParent().equals(PASTA)) {
            mensagem("O arquivo deve ficar dentro de LABORATORIO.");
            return null;
        }
        return arquivo;
    }

    // Confere se o caminho aponta para um arquivo comum, não uma pasta.
    // true = existe; false = não existe ou não é arquivo comum.
    private static boolean existe(Path arquivo) {
        if (!Files.isRegularFile(arquivo)) {
            mensagem("O arquivo não existe: " + arquivo.getFileName());
            return false;
        }
        return true;
    }

    // OPÇÃO 1: cria um arquivo vazio, desde que não exista outro com o nome.
    private static void criar() {
        Path arquivo = solicitarArquivo("Nome do novo arquivo (ex.: atividade.txt):");
        if (arquivo == null) return;
        if (Files.exists(arquivo)) {
            mensagem("Já existe um arquivo com esse nome.");
            return;
        }
        try {
            Files.createFile(arquivo); // Cria o arquivo fisicamente no disco.
            mensagem("Arquivo criado com sucesso!\n" + arquivo);
        } catch (IOException | SecurityException e) { // Trata erros de E/S ou acesso.
            erro(e);
        }
    }

    // OPÇÃO 2: solicita texto e substitui o conteúdo atual do arquivo.
    private static void escrever() {
        Path arquivo = solicitarArquivo("Nome do arquivo que receberá o texto:");
        if (arquivo == null || !existe(arquivo)) return;
        String texto = JOptionPane.showInputDialog(null, "Digite o texto a gravar:");
        if (texto == null) return;
        try {
            // Substitui o conteúdo anterior pelo texto informado.
            // getBytes converte o texto em bytes UTF-8 para gravação.
            Files.write(arquivo, texto.getBytes(StandardCharsets.UTF_8));
            mensagem("Conteúdo gravado com sucesso!");
        } catch (IOException | SecurityException e) { // Trata erros de E/S ou acesso.
            erro(e);
        }
    }

    // OPÇÃO 3: lê todos os bytes e os transforma em texto UTF-8.
    private static void ler() {
        Path arquivo = solicitarArquivo("Nome do arquivo a ser lido:");
        if (arquivo == null || !existe(arquivo)) return;
        try {
            String texto = new String(Files.readAllBytes(arquivo), StandardCharsets.UTF_8);
            // readAllBytes lê o arquivo inteiro; new String converte os bytes em texto.
            mensagem("Conteúdo de " + arquivo.getFileName() + ":\n\n" + texto);
        } catch (IOException | SecurityException e) { // Trata erros de E/S ou acesso.
            erro(e);
        }
    }

    // OPÇÃO 4: valida o nome atual e o novo antes de trocar o nome.
    private static void renomear() {
        Path atual = solicitarArquivo("Nome atual do arquivo:");
        if (atual == null || !existe(atual)) return;
        Path novo = solicitarArquivo("Novo nome do arquivo:");
        if (novo == null) return;
        if (Files.exists(novo)) {
            mensagem("O novo nome já está sendo utilizado.");
            return;
        }
        try {
            Files.move(atual, novo); // Move para o novo caminho, dentro da mesma pasta.
            mensagem("Arquivo renomeado com sucesso!");
        } catch (IOException | SecurityException e) { // Trata erros de E/S ou acesso.
            erro(e);
        }
    }

    // OPÇÃO 5: só exclui depois da confirmação explícita.
    private static void excluir() {
        Path arquivo = solicitarArquivo("Nome do arquivo a excluir:");
        if (arquivo == null || !existe(arquivo)) return;
        int resposta = JOptionPane.showConfirmDialog(null,
            "Deseja realmente excluir " + arquivo.getFileName() + "?",
            "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
        // Se escolher Não ou fechar a janela, volta ao menu sem apagar.
        if (resposta != JOptionPane.YES_OPTION) return;
        try {
            Files.delete(arquivo); // Apaga o arquivo do disco.
            mensagem("Arquivo excluído com sucesso!");
        } catch (IOException | SecurityException e) { // Trata erros de E/S ou acesso.
            erro(e);
        }
    }

    // OPÇÃO 6: consulta metadados (informações) do arquivo no disco.
    private static void informacoes() {
        Path arquivo = solicitarArquivo("Nome do arquivo para consulta:");
        if (arquivo == null || !existe(arquivo)) return;
        try {
            String nome = arquivo.getFileName().toString();
            // Procura o último ponto para identificar a possível extensão.
            int ponto = nome.lastIndexOf('.');
            String extensao = ponto > 0 && ponto < nome.length() - 1
                ? nome.substring(ponto + 1) : "Sem extensão";
            // Obtém a última alteração e formata a data para dia/mês/ano hora.
            FileTime modificacao = Files.getLastModifiedTime(arquivo);
            String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                .format(new Date(modificacao.toMillis()));
            // size informa o tamanho em bytes; isReadable/isWritable/isExecutable
            // consultam as permissões efetivas vistas pelo Java.
            mensagem("INFORMAÇÕES DO ARQUIVO\n\n" +
                "Nome: " + nome + "\n" +
                "Extensão: " + extensao + "\n" +
                "Tamanho: " + Files.size(arquivo) + " bytes\n" +
                "Caminho: " + arquivo.toAbsolutePath() + "\n" +
                "Leitura: " + simNao(Files.isReadable(arquivo)) + "\n" +
                "Gravação: " + simNao(Files.isWritable(arquivo)) + "\n" +
                "Execução: " + simNao(Files.isExecutable(arquivo)) + "\n" +
                "Última modificação: " + data);
        } catch (IOException | SecurityException e) { // Trata erros de E/S ou acesso.
            erro(e);
        }
    }

    // OPÇÃO 8 (desafio): tenta desativar a gravação no arquivo.
    // A eficácia depende do sistema operacional e das permissões do usuário.
    private static void somenteLeitura() {
        Path arquivo = solicitarArquivo("Nome do arquivo para tornar somente leitura:");
        if (arquivo == null || !existe(arquivo)) return;
        // toFile converte Path em File; setWritable(false, false) pede
        // a remoção da permissão de escrita (não apenas para o proprietário).
        // Retornar true não garante que toda conta deixe de conseguir escrever.
        boolean alterou = arquivo.toFile().setWritable(false, false);
        if (alterou) {
            mensagem("Pedido de somente leitura aplicado.\n" +
                "Consulte as informações para verificar a permissão.");
        } else {
            mensagem("Não foi possível alterar a permissão neste sistema.");
        }
    }

    // Converte um valor booleano em uma resposta legível na tela.
    private static String simNao(boolean valor) {
        return valor ? "Sim" : "Não";
    }

    // Evita repetir showMessageDialog em vários pontos do código.
    private static void mensagem(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    // Mostra a descrição do problema, sem encerrar todo o sistema.
    private static void erro(Exception e) {
        JOptionPane.showMessageDialog(null,
            "Não foi possível concluir a operação:\n" + e.getMessage(),
            "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
