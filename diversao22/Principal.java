package diversao22;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        
        File laboratorio = new File("LABORATORIO");
        // .exists() e .mkdirs() são métodos da classe File que verificam a existência de um diretório e criam diretórios, respectivamente. (informação tirada do google)
        if (!laboratorio.exists()) {
            laboratorio.mkdirs();
        }

        boolean executando = true;

        while (executando) {
            String menu = "ESCOLHA UMA OPÇÃO:\n" +
                          "1 - CRIAR ARQUIVO\n" +
                          "2 - ESCREVER NO ARQUIVO\n" +
                          "3 - LER ARQUIVO\n" +
                          "4 - RENOMEAR ARQUIVO\n" +
                          "5 - EXCLUIR ARQUIVO\n" +
                          "6 - MOSTRAR INFORMAÇÕES DO ARQUIVO\n" +
                          "7 - PROTEGER ARQUIVO (SOMENTE LEITURA)\n" +
                          "8 - SAIR";

            String op = JOptionPane.showInputDialog(null, menu, "GERENCIADOR DE ARQUIVOS", JOptionPane.QUESTION_MESSAGE);

            if (op == null) {
                JOptionPane.showMessageDialog(null, "OPERAÇÃO CANCELADA");
                break;
            }

            // coloquei o .trim() dentro do switch para evitar espaços em branco e erros de digitação e não ter que repetir nos outros casos.
            switch (op.trim()) {
                case "1":
                    String criar = JOptionPane.showInputDialog(null, "NOME DO ARQUIVO COM EXTENSÃO (ex: atividade.txt):", "CRIAR ARQUIVO", JOptionPane.QUESTION_MESSAGE);

                    if (criar == null || criar.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NOME DO ARQUIVO INVÁLIDO OU OPERAÇÃO CANCELADA!");
                    } else {
                        File arquivo = new File("LABORATORIO", criar.trim());
                        if (arquivo.exists()) {
                            JOptionPane.showMessageDialog(null, "O ARQUIVO JÁ EXISTE!");
                        } else {
                            try {
                                if (arquivo.createNewFile()) {
                                    JOptionPane.showMessageDialog(null, "ARQUIVO CRIADO COM SUCESSO EM LABORATORIO!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "ERRO AO CRIAR ARQUIVO!");
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "ERRO DE E/S: " + e.getMessage());
                            }
                        }
                    }
                    break;

                case "2":
                    String escrever = JOptionPane.showInputDialog(null, "NOME DO ARQUIVO PARA ESCREVER:", "ESCREVER NO ARQUIVO", JOptionPane.QUESTION_MESSAGE);

                    if (escrever == null || escrever.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NOME DO ARQUIVO INVÁLIDO OU OPERAÇÃO CANCELADA!");
                    } else {
                        File arquivo = new File("LABORATORIO", escrever.trim());
                        if (!arquivo.exists()) {
                            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO!");
                        } else if (!arquivo.canWrite()) {
                            JOptionPane.showMessageDialog(null, "O ARQUIVO ESTÁ PROTEGIDO CONTRA GRAVAÇÃO!");
                        } else {
                            String texto = JOptionPane.showInputDialog(null, "DIGITE O TEXTO A SER GRAVADO:", "ESCREVER NO ARQUIVO", JOptionPane.QUESTION_MESSAGE);
                            if (texto != null) {
                                try (FileWriter writer = new FileWriter(arquivo, true)) {
                                    writer.write(texto + "\n");
                                    JOptionPane.showMessageDialog(null, "TEXTO GRAVADO COM SUCESSO!");
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "ERRO AO ESCREVER: " + e.getMessage());
                                }
                            }
                        }
                    }
                    break;

                case "3":
                    String ler = JOptionPane.showInputDialog(null, "NOME DO ARQUIVO PARA LER:", "LER ARQUIVO", JOptionPane.QUESTION_MESSAGE);

                    if (ler == null || ler.trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "NOME DO ARQUIVO INVÁLIDO!");
                    } else {
                        File arquivo = new File("LABORATORIO", ler.trim());
                        if (!arquivo.exists()) {
                            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO!");
                        } else {
                            try {
                                java.util.Scanner leitor = new java.util.Scanner(arquivo);
                                String conteudo = "";

                                while (leitor.hasNextLine()) {
                                    conteudo += leitor.nextLine() + "\n";
                                }
                                leitor.close();

                                if (conteudo.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "O ARQUIVO ESTÁ VAZIO!");
                                }else {
                                    JOptionPane.showMessageDialog(null, "CONTEÚDO DO ARQUIVO:\n\n" + conteudo);
                                }
                            } catch (FileNotFoundException e) {
                                JOptionPane.showMessageDialog(null, "ERRO AO LER ARQUIVO: " + e.getMessage());
                            }
                        }
                    }
                    }
                    break;

                case "4":
                    String nomeAtual = JOptionPane.showInputDialog(null, "NOME ATUAL DO ARQUIVO:", "RENOMEAR ARQUIVO", JOptionPane.QUESTION_MESSAGE);

                    if (nomeAtual == null || nomeAtual.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NOME INVÁLIDO OU OPERAÇÃO CANCELADA!");
                    } else {
                        File arqAtual = new File("LABORATORIO", nomeAtual.trim());
                        if (!arqAtual.exists()) {
                            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO!");
                        } else {
                            String novoNome = JOptionPane.showInputDialog(null, "NOVO NOME DO ARQUIVO:", "RENOMEAR ARQUIVO", JOptionPane.QUESTION_MESSAGE);
                            if (novoNome == null || novoNome.trim().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "NOVO NOME INVÁLIDO!");
                            } else {
                                File novoArq = new File("LABORATORIO", novoNome.trim());
                                if (novoArq.exists()) {
                                    JOptionPane.showMessageDialog(null, "JÁ EXISTE UM ARQUIVO COM ESTE NOVO NOME!");
                                } else {
                                    if (arqAtual.renameTo(novoArq)) {
                                        JOptionPane.showMessageDialog(null, "ARQUIVO RENOMEADO COM SUCESSO!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "FALHA AO RENOMEAR ARQUIVO!");
                                    }
                                }
                            }
                        }
                    }
                    break;

                case "5":
                    String nomeExcluir = JOptionPane.showInputDialog(null, "NOME DO ARQUIVO A EXCLUIR:", "EXCLUIR ARQUIVO", JOptionPane.QUESTION_MESSAGE);

                    if (nomeExcluir == null || nomeExcluir.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NOME INVÁLIDO OU OPERAÇÃO CANCELADA!");
                    } else {
                        File arquivo = new File("LABORATORIO", nomeExcluir.trim());
                        if (!arquivo.exists()) {
                            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO!");
                        } else {
                            int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA EXCLUIR O ARQUIVO '" + nomeExcluir + "'?", "CONFIRMAÇÃO DE EXCLUSÃO", JOptionPane.YES_NO_OPTION);
                            if (confirma == JOptionPane.YES_OPTION) {
                                if (arquivo.delete()) {
                                    JOptionPane.showMessageDialog(null, "ARQUIVO EXCLUÍDO COM SUCESSO!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "FALHA AO EXCLUIR O ARQUIVO!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "EXCLUSÃO CANCELADA!");
                            }
                        }
                    }
                    break;

                case "6":
                    String nomeInfo = JOptionPane.showInputDialog(null, "NOME DO ARQUIVO PARA CONSULTAR:", "INFORMAÇÕES DO ARQUIVO", JOptionPane.QUESTION_MESSAGE);

                    if (nomeInfo == null || nomeInfo.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NOME INVÁLIDO OU OPERAÇÃO CANCELADA!");
                    } else {
                        File arquivo = new File("LABORATORIO", nomeInfo.trim());
                        if (!arquivo.exists()) {
                            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO!");
                        } else {
                            String nome = arquivo.getName();
                            String extensao = "";
                            int idx = nome.lastIndexOf('.');
                            if (idx > 0 && idx < nome.length() - 1) {
                                extensao = nome.substring(idx + 1);
                            } else {
                                extensao = "Sem extensão";
                            }

                            // SimpleDateFormat é uma classe do pacote java.text que permite formatar datas de acordo com um padrão especificado. No caso, o padrão "dd/MM/yyyy HH:mm:ss" indica que a data será exibida no formato dia/mês/ano horas:minutos:segundos. (informação tirada do google)
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String ultimaModificacao = sdf.format(new Date(arquivo.lastModified()));

                            String info = "INFORMAÇÕES DO ARQUIVO:\n\n" +
                                          "NOME: " + nome + "\n" +
                                          "EXTENSÃO: " + extensao + "\n" +
                                          "TAMANHO: " + arquivo.length() + " bytes\n" +
                                          "CAMINHO: " + arquivo.getAbsolutePath() + "\n" +
                                          "LEITURA: " + (arquivo.canRead() ? "SIM" : "NÃO") + "\n" +
                                          "GRAVAÇÃO: " + (arquivo.canWrite() ? "SIM" : "NÃO") + "\n" +
                                          "EXECUÇÃO: " + (arquivo.canExecute() ? "SIM" : "NÃO") + "\n" +
                                          "ÚLTIMA MODIFICAÇÃO: " + ultimaModificacao;

                            JOptionPane.showMessageDialog(null, info, "INFORMAÇÕES DO ARQUIVO", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;

                case "7":
                    String nomeProteger = JOptionPane.showInputDialog(null, "NOME DO ARQUIVO PARA PROTEGER:", "PROTEÇÃO DE ARQUIVO", JOptionPane.QUESTION_MESSAGE);

                    if (nomeProteger == null || nomeProteger.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NOME INVÁLIDO OU OPERAÇÃO CANCELADA!");
                    } else {
                        File arquivo = new File("LABORATORIO", nomeProteger.trim());
                        if (!arquivo.exists()) {
                            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO!");
                        } else {
                            if (arquivo.setReadOnly()) {
                                JOptionPane.showMessageDialog(null, "ARQUIVO DEFINIDO COMO SOMENTE LEITURA COM SUCESSO!");
                            } else {
                                JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL ALTERAR AS PERMISSÕES DO ARQUIVO!");
                            }
                        }
                    }
                    break;

                case "8":
                    JOptionPane.showMessageDialog(null, "SAINDO...");
                    executando = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
                    break;
            }
        }
    }
}