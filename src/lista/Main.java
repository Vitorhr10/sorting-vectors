/*
 * Projeto.: Lista Duplamente Ligada
 * Autor...: Vitor
 * Classe..: SFila
 * Objetivo: Projeto Fila Duplamente Ligada
 */
package lista;

public class Main {

    public static void listagem_simultanea(LdeNumeros x, LdeNumeros y, int nx, int ny) {
        int flagc = 0;
        int p = 0;
        String axant, axpro, ayant, aypro;

        NohNumeros ax = x.primeiro;
        NohNumeros ay = y.primeiro;

        do {
            p++;

            if (flagc == 0) {
                System.out.println();
                System.out.format("|         |                 LISTA %1d                 |                 LISTA %1d                 |\n", nx, ny);
                System.out.format("|         |          %11d Elementos          |          %11d Elementos          |\n", x.tamanho, y.tamanho);
                System.out.println("| Posicao |    Anterior |      Número |     Próximo |    Anterior |      Número |     Próximo |");
                System.out.println("| ------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |");
                System.out.println("|         |                                         |                                         |");
                flagc = 1;
            }

            axant = "***********";
            axpro = "***********";
            ayant = "***********";
            aypro = "***********";

            if (ax != null) {
                if (ax.getAnterior() != null) {
                    axant = ax.getAnterior().getNumero().toString();
                } else {
                    axant = "*** IOF ***";
                }
                if (ax.getProximo() != null) {
                    axpro = ax.getProximo().getNumero().toString();
                } else {
                    axpro = "*** EOF ***";
                }
                if (ay != null) {
                    if (ay.getAnterior() != null) {
                        ayant = ay.getAnterior().getNumero().toString();
                    } else {
                        ayant = "*** IOF ***";
                    }
                    if (ay.getProximo() != null) {
                        aypro = ay.getProximo().getNumero().toString();
                    } else {
                        aypro = "*** EOF ***";
                    }
                    System.out.format("| %7d | %11s | %11d | %11s | %11s | %11d | %11s |\n",
                            p, axant, ax.getNumero(), axpro,
                            ayant, ay.getNumero(), aypro);
                } else {
                    System.out.format("| %7d | %11s | %11d | %11s | *********** | *********** | *********** |\n",
                            p, axant, ax.getNumero(), axpro);
                }
            } else {
                if (ay != null) {
                    if (ay.getAnterior() != null) {
                        ayant = ay.getAnterior().getNumero().toString();
                    } else {
                        ayant = "*** IOF ***";
                    }
                    if (ay.getProximo() != null) {
                        aypro = ay.getProximo().getNumero().toString();
                    } else {
                        aypro = "*** EOF ***";
                    }
                    System.out.format("| %7d | *********** | *********** | *********** | %11s | %11d | %11s |\n",
                            p, ayant, ay.getNumero(), aypro);
                } else {
                    System.out.format("| %7d | *********** | *********** | *********** | *********** | *********** | *********** |\n", p);
                }
            }

            if (ax != null) {
                ax = ax.getProximo();
            }
            if (ay != null) {
                ay = ay.getProximo();
            }

        } while ((ax != null) || (ay != null));
    }

    public static void main(String[] args) {
        LdeNumeros lista1 = new LdeNumeros();
        LdeNumeros lista2 = new LdeNumeros();
        LdeNumeros lista3 = new LdeNumeros();
        LdeNumeros listax = new LdeNumeros();

        int posicao = 0;
        int pos1 = 0;
        int pos2 = 0;
        int qtd = 0;
        int qual_lista = 0;

        String conteudo = " ";

        lista1.tamanho = lista1.xarq_abre_arquivo("Lista 1");

        lista2.tamanho = lista2.xarq_abre_arquivo("Lista 2");

        lista3.tamanho = lista3.xarq_abre_arquivo("Lista 3");

        int opc = Msg.opcao_principal();

        while (opc != 0) {
            if ((opc != 10) && (opc != 11)) {
                qual_lista = Msg.opcao_lista("trabalho");

                switch (qual_lista) {
                    case 1: {
                        listax = lista1;
                        break;
                    }
                    case 2: {
                        listax = lista2;
                        break;
                    }
                    case 3: {
                        listax = lista3;
                        break;
                    }
                }
            }

            switch (opc) {
                case 1: // Inserção

                    posicao = Msg.solicita_posicao();

                    while (posicao < 1 || posicao > (listax.tamanho + 1)) {
                        Msg.msg("Posição inválida, escolha entre [1:" + listax.tamanho + 1 + "]");
                        posicao = Msg.solicita_posicao();
                    }
                    listax.inserir_posicao(posicao);
                    break;

                case 2: // Remoção
                    Msg.limpatela();

                    if (listax.vazia()) {
                        Msg.msg("A lista está vazia, remoção não processada!");
                    } else {
                        posicao = Msg.solicita_posicao();

                        while (posicao < 1 || posicao > listax.tamanho) {
                            Msg.msg("Posição inválida, escolha entre [1:" + listax.tamanho + "]");
                            posicao = Msg.solicita_posicao();
                        }
                        listax.remover_posicao(posicao);
                    }
                    Msg.enter();
                    break;

                case 3:
                    Msg.limpatela();

                    if (listax.tamanho == 0) {
                        Msg.msg("A lista está vazia, consulta não processada!");
                        Msg.enter();
                    } else {
                        opc = Msg.opcao_consulta();

                        Msg.limpatela();

                        switch (opc) {
                            case 1:
                                listax.consultar_geral();
                                break;

                            case 2:
                                posicao = Msg.solicita_posicao();

                                while (posicao < 1 || posicao > listax.tamanho) {
                                    Msg.msg("Posição inválida, escolha entre [1:" + listax.tamanho + "]");
                                    posicao = Msg.solicita_posicao();
                                }

                                listax.consultar_posicao(posicao);

                                Msg.enter();
                                break;

                            case 3:
                                conteudo = Msg.solicita_conteudo();

                                if (conteudo.isEmpty()) {
                                    Msg.msg("Consulta nao realizada!");
                                } else {
                                    listax.consultar_conteudo(conteudo);
                                }
                                Msg.enter();
                                break;

                            default:
                                Msg.limpatela();
                                Msg.msg("Opção inválida, retornando...");
                                Msg.enter();
                        }
                    }
                    break;

                case 4:
                    Msg.limpatela();

                    if (listax.vazia()) {
                        Msg.msg("A lista está vazia, inicialização não processada!");
                    } else {
                        listax.inicializar();
                    }
                    Msg.enter();
                    break;

                case 5:
                    Msg.limpatela();

                    if (listax.tamanho == 0) {
                        Msg.msg("O tamanho não foi calculado, a lista está vazia!");
                    } else {
                        Msg.msg(">> O tamanho da lista é: [" + listax.tamanho + "]\n\n");
                    }
                    Msg.enter();
                    break;

                case 6:
                    Msg.limpatela();

                    if (listax.tamanho == 0) {
                        Msg.msg("A lista está vazia, não há como trocar elementos de lugar!");
                    } else {
                        if (listax.tamanho == 1) {
                            Msg.msg("A lista possui apenas um elemento, não há como trocar de lugar!");
                        } else {
                            Msg.msg("Escolha a posicão de origem: ");
                            pos1 = Msg.solicita_posicao();

                            while (pos1 < 0 || pos1 > listax.tamanho) {
                                Msg.msg("Posição de origem inválida, corrija: ");
                                pos1 = Msg.solicita_posicao();
                            }

                            if (pos1 == 0) {
                                Msg.msg("Você desistiu da troca de lugar, voltando para o menu principal.");
                            } else {
                                Msg.msg("Escolha a posicão de destino: ");
                                pos2 = Msg.solicita_posicao();

                                while ((pos2 < 0 || pos2 > listax.tamanho) || (pos2 == pos1 && pos2 != 0)) {
                                    Msg.msg("Posição inválida! Escolha a posicão de destino: ");
                                    pos2 = Msg.solicita_posicao();
                                }

                                if (pos2 == 0) {
                                    Msg.msg("Você desistiu da troca de lugar, voltando para o menu principal.");
                                } else {
                                    listax.troca_de_lugar(pos1, pos2);
                                }
                            }
                        }
                    }
                    Msg.enter();
                    break;

                case 7:
                    Msg.limpatela();

                    if (listax.tamanho == 0) {
                        Msg.msg("A lista está vazia, não há como trocar prioridade de elemento!");
                    } else {
                        if (listax.tamanho == 1) {
                            Msg.msg("A lista possui apenas um elemento, não há como trocar de prioridade!");
                        } else {
                            Msg.msg("Escolha a posicão de origem: ");
                            pos1 = Msg.solicita_posicao();

                            while (pos1 < 0 || pos1 > listax.tamanho) {
                                Msg.msg("Posição de origem inválida, corrija: ");
                                pos1 = Msg.solicita_posicao();
                            }

                            if (pos1 == 0) {
                                Msg.msg("Você desistiu da troca de prioridade, voltando para o menu principal.");
                            } else {
                                Msg.msg("Escolha a posicão de destino: ");
                                pos2 = Msg.solicita_posicao();

                                while ((pos2 < 0 || pos2 > listax.tamanho) || (pos2 == pos1 && pos2 != 0)) {
                                    Msg.msg("Posição inválida! Escolha a posicão de destino: ");
                                    pos2 = Msg.solicita_posicao();
                                }

                                if (pos2 == 0) {
                                    Msg.msg("Você desistiu da troca de prioridade, voltando para o menu principal.");
                                } else {
                                    listax.troca_de_prioridade(pos1, pos2);
                                }
                            }
                        }
                    }
                    Msg.enter();
                    break;

                case 8:

                    qtd = Msg.solicita_quantidade();
                    listax.gera_numeros(qtd);

                    break;

                case 9:

                    if (listax.vazia()) {
                        Msg.msg("Lista vazia!");
                    } else {
                        opc = Msg.opcao_ordenacao();

                        switch (opc) {
                            case 1:

                                listax.ordena_bubble_sort_aluno();
                                break;

                            case 2:

                                listax.ordena_selection_sort();
                                break;

                            case 3:

                                listax.ordena_insertion_sort();
                                break;

                            case 4:

                                listax.ordena_quick_sort();
                                break;

                            case 5:

                                listax.ordena_merge_sort();
                                break;

                            case 6:

                                listax.ordena_heap_sort();
                                break;

                            case 7:

                                listax.ordena_shell_sort();
                                break;

                            case 8:

                                listax.ordena_radix_sort();
                                break;

                            case 9:

                                listax.ordena_bucket_sort();
                                break;

                            case 10:

                                listax.ordena_bubble_sort_dreco();
                                break;

                        }
                    }
                    Msg.enter();
                    break;

                case 10:
                    pos1 = Msg.opcao_lista("coluna 1");

                    pos2 = Msg.opcao_lista("coluna 2");

                    while (pos1 == pos2) {
                        Msg.msg("As listas não podem ser iguais, escolha outra: ");
                        pos2 = Msg.opcao_lista("coluna 2");
                    }

                    if (pos1 == 1) {
                        if (pos2 == 2) {
                            listagem_simultanea(lista1, lista2, 1, 2);
                        } else {
                            listagem_simultanea(lista1, lista3, 1, 3);
                        }
                    } else {
                        if (pos1 == 2) {
                            if (pos2 == 1) {
                                listagem_simultanea(lista2, lista1, 2, 1);
                            } else {
                                listagem_simultanea(lista2, lista3, 2, 3);
                            }
                        } else {
                            if (pos2 == 1) {
                                listagem_simultanea(lista3, lista1, 3, 1);
                            } else {
                                listagem_simultanea(lista3, lista2, 3, 2);
                            }
                        }
                    }
                    Msg.enter();
                    break;

                case 11:
                    pos1 = Msg.opcao_lista("destino");

                    pos2 = Msg.opcao_lista("origem");

                    while (pos1 == pos2) {
                        Msg.msg("As listas não podem ser iguais, escolha outra: ");
                        pos2 = Msg.opcao_lista("origem");
                    }

                    if (pos1 == 1) {
                        if (pos2 == 2) {
                            Msg.msg("Copiando lista2 para a lista1.");
                            lista1 = lista1.copia_lista(lista2);
                        } else {
                            lista1 = lista1.copia_lista(lista3);
                        }
                    } else {
                        if (pos1 == 2) {
                            if (pos2 == 1) {
                                Msg.msg("Copiando lista1 para a lista2.");
                                lista2 = lista2.copia_lista(lista1);
                            } else {
                                lista2 = lista2.copia_lista(lista3);
                            }
                        } else {
                            if (pos2 == 1) {
                                lista3 = lista3.copia_lista(lista1);
                            } else {
                                lista3 = lista3.copia_lista(lista2);
                            }
                        }
                    }
                    Msg.enter();
                    break;

                case 12:

                    lista1.tamanho = lista1.xarq_abre_arquivo("Lista 1");

                    break;
                case 0:

                    break;

                default:
                    Msg.limpatela();
                    Msg.msg("Opção inválida, retornando...");
                    Msg.enter();
            }

            switch (qual_lista) {
                case 1: {
                    lista1 = listax;
                    break;
                }
                case 2: {
                    lista2 = listax;
                    break;
                }
                case 3: {
                    lista3 = listax;
                    break;
                }
            }

            opc = Msg.opcao_principal();
        }

        Msg.limpatela();

        if (lista1.primeiro == null) {
            Msg.msg("Lista 1 vazia - não haverá gravação de arquivo.");
        } else {
            Msg.msg("Atenção! Verificando gravação da lista 1");

            if (lista1.tamanho == 0) {
                Msg.msg(">>> O programa encerrou com a lista vazia!\n\n");
            } else {
                Msg.msg("Antes de encerrar, mostraremos a lista 1 atual:\n");
                lista1.consultar_geral();
                lista1.xarq_salvar_arquivo("Lista 1");
            }
        }

        Msg.enter();
        Msg.limpatela();

        if (lista2.primeiro == null) {
            Msg.msg("Lista 2 vazia - não haverá gravação de arquivo.");
        } else {
            Msg.msg("Atenção! Verificando gravação da lista 2");

            if (lista2.tamanho == 0) {
                Msg.msg(">>> O programa encerrou com a lista vazia!\n\n");
            } else {
                Msg.msg("Antes de encerrar, mostraremos a lista 1 atual:\n");
                lista2.consultar_geral();
                lista2.xarq_salvar_arquivo("Lista 2");
            }
        }

        Msg.enter();
        Msg.limpatela();

        if (lista3.primeiro == null) {
            Msg.msg("Lista 3 vazia - não haverá gravação de arquivo.");
        } else {
            Msg.msg("Atenção! Verificando gravação da lista 3");

            if (lista3.tamanho == 0) {
                Msg.msg(">>> O programa encerrou com a lista vazia!\n\n");
            } else {
                Msg.msg("Antes de encerrar, mostraremos a lista 3 atual:\n");
                lista3.consultar_geral();
                lista3.xarq_salvar_arquivo("Lista 3");
            }
        }

        Msg.enter();
    }
}
