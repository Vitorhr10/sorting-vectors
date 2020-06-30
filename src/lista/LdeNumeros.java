/*
 * Projeto.: Lista Duplamente Ligada/Encadeada
 * Autor...: Vitor
 * Classe..: LdeNumeros
 * Objetivo: Criação e manutenção dos elementos na lista duplamente encadeada
 */
package lista;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LdeNumeros {

    // Objetivo: atributos de determinação do primeiro e do último elemento da
    //           lista, para que seja realizada a sua gestão
    //
    public NohNumeros primeiro;
    public NohNumeros ultimo;

    // Objetivo: atributo de tamanho da lista
    //           
    //
    public Integer tamanho;

    // Objetivo: método para receber e tratar a digitação de um atributo dados
    //           (do tipo Object) quando de uma inserção ou consulta por conteúdo
    //
    public String digitacao() {
        Scanner s = new Scanner(System.in);
        String dados = " ";

        do {
            Msg.limpatela();

            try {
                Msg.msg("Digite o dado para o elemento - não pode ser vazio: ");
                dados = s.nextLine();
            } catch (Exception e) {
                Msg.msg("Erro de digitação, não deixe a informação vazia:");
            }
        } while (dados.isEmpty());

        return dados;
    }

    // Objetivo: método para receber e tratar a digitação do atributo codigo
    //           quando de uma inserção ou consulta por conteúdo
    //
    public Integer D_Numero() {
        Scanner s = new Scanner(System.in);
        Integer num = 0;
        String texto = "Digite o valor para o número: ";
        Integer erro = 0;

        Msg.limpatela();

        try {
            Msg.msg(texto);
            num = Integer.parseInt(s.nextLine());
        } catch (Exception e) {
            texto = "Erro de digitação, o número é obrigatório: ";
            erro = 1;
        }
        if (erro == 0) {
            texto = "Erro de digitação, o número é obrigatório: ";
        }
        erro = 0;
        Msg.limpatela();

        return num;
    }

    // Objetivo: método para verificar se a lista está vazia (true)
    //           ou não (false)
    //
    public boolean vazia() {
        boolean r = true;

        if (this.primeiro != null) {
            r = false;
        }

        return r;
    }

    // Objetivo: método para trocar dois elementos de lugar
    //           
    //
    public void troca_de_lugar(int pos1, int pos2) {
        int p1, p2, pt = 0;
        NohNumeros tmp1, tmp2 = null;
        NohNumeros pt1a, pt1p, pt2a, pt2p = null;

        if (pos1 > pos2) {
            pt = pos1;
            pos1 = pos2;
            pos2 = pt;
        }

        if (pos1 == 1) {
            tmp1 = this.primeiro;

            // Caso 1 - primeiro com o último
            if (pos2 == this.tamanho) {
                pt1p = this.primeiro.getProximo();
                tmp2 = this.ultimo;
                pt2a = this.ultimo.getAnterior();

                this.primeiro = tmp2;
                this.ultimo = tmp1;

                this.primeiro.setProximo(pt1p);
                this.primeiro.setAnterior(null);
                pt1p.setAnterior(this.primeiro);

                this.ultimo.setAnterior(pt2a);
                this.ultimo.setProximo(null);
                pt2a.setProximo(this.ultimo);
            } else {
                // Caso 2 - primeiro com o segundo

                if (pos2 == 2) {
                    tmp2 = this.primeiro.getProximo();
                    pt2p = this.primeiro.getProximo().getProximo();

                    this.primeiro = tmp2;

                    this.primeiro.setProximo(tmp1);
                    tmp1.setAnterior(this.primeiro);
                    tmp1.setProximo(pt2p);
                    pt2p.setAnterior(tmp1);
                    this.primeiro.setAnterior(null);
                } else {
                    // Caso 3 - primeiro com outros do meio

                    tmp1 = this.primeiro;
                    pt1p = this.primeiro.getProximo();

                    for (p2 = 1, tmp2 = this.primeiro; p2 != pos2; p2++, tmp2 = tmp2.getProximo());

                    pt2a = tmp2.getAnterior();
                    pt2p = tmp2.getProximo();

                    this.primeiro = tmp2;
                    tmp2.setProximo(pt1p);
                    pt1p.setAnterior(this.primeiro);
                    this.primeiro.setAnterior(null);

                    tmp1.setProximo(pt2p);
                    tmp1.setAnterior(pt2a);
                    pt2p.setAnterior(tmp1);
                    pt2a.setProximo(tmp1);
                }
            }
        } else {
            if (pos2 == this.tamanho) {
                // Caso 4 - último com o penúltimo

                tmp2 = this.ultimo;

                if (pos1 == pos2 - 1) {
                    tmp1 = this.ultimo.getAnterior();
                    pt1a = this.ultimo.getAnterior().getAnterior();

                    this.ultimo = tmp1;

                    tmp2.setAnterior(pt1a);
                    pt1a.setProximo(tmp2);
                    tmp2.setProximo(this.ultimo);
                    this.ultimo.setAnterior(tmp2);
                    this.ultimo.setProximo(null);
                } else {
                    // Caso 5 - último com outros do meio

                    pt2a = this.ultimo.getAnterior();

                    for (p1 = 1, tmp1 = this.primeiro; p1 != pos1; p1++, tmp1 = tmp1.getProximo());

                    pt1a = tmp1.getAnterior();
                    pt1p = tmp1.getProximo();

                    this.ultimo = tmp1;
                    tmp1.setAnterior(pt2a);
                    pt2a.setProximo(this.ultimo);
                    this.ultimo.setProximo(null);

                    tmp2.setProximo(pt1p);
                    tmp2.setAnterior(pt1a);
                    pt1p.setAnterior(tmp2);
                    pt1a.setProximo(tmp2);

                }
            } else {
                // Caso 6 - posições intermediárias laterais

                if (pos2 == pos1 + 1) {
                    for (p1 = 1, tmp1 = this.primeiro; p1 != pos1; p1++, tmp1 = tmp1.getProximo());

                    pt1a = tmp1.getAnterior();

                    tmp2 = tmp1.getProximo();
                    pt2p = tmp1.getProximo().getProximo();

                    pt1a.setProximo(tmp2);
                    tmp2.setAnterior(pt1a);
                    tmp2.setProximo(tmp1);
                    tmp1.setAnterior(tmp2);
                    tmp1.setProximo(pt2p);
                    pt2p.setAnterior(tmp1);
                } else {
                    // Caso 7 - posições intermediárias não laterais

                    for (p1 = 1, tmp1 = this.primeiro; p1 != pos1; p1++, tmp1 = tmp1.getProximo());
                    for (p2 = 1, tmp2 = this.primeiro; p2 != pos2; p2++, tmp2 = tmp2.getProximo());

                    pt1a = tmp1.getAnterior();
                    pt1p = tmp1.getProximo();

                    pt2a = tmp2.getAnterior();
                    pt2p = tmp2.getProximo();

                    tmp1.setAnterior(pt2a);
                    pt2a.setProximo(tmp1);
                    tmp1.setProximo(pt2p);
                    pt2p.setAnterior(tmp1);

                    tmp2.setAnterior(pt1a);
                    pt1a.setProximo(tmp2);
                    tmp2.setProximo(pt1p);
                    pt1p.setAnterior(tmp2);
                }
            }
        }
    }

    // Objetivo: método para trocar dois elementos de lugar
    //           
    //
    public void troca_de_prioridade(int pos1, int pos2) {
        int p1, p2, pt = 0;
        NohNumeros tmp1 = null, tmp2 = null;
        NohNumeros tmp1Anterior, tmp1Proximo, tmp2Anterior, tmp2Proximo = null;

        if (pos1 > pos2) {
            pt = pos1;
            pos1 = pos2;
            pos2 = pt;
        }

        if (pos1 == 1) {
            tmp1 = this.primeiro;

            // 1º Caso primeiro com o segundo
            if (pos2 == 2) {

                tmp2 = this.primeiro.getProximo();

                tmp1Proximo = tmp1.getProximo();

                tmp2Proximo = tmp2.getProximo();

                this.primeiro = tmp2;
                this.primeiro.setAnterior(null);
                this.primeiro.setProximo(tmp1);

                tmp1.setAnterior(this.primeiro);
                tmp1.setProximo(tmp2Proximo);

                tmp2Proximo.setAnterior(tmp1);
            } else {
                // 2º Caso primeiro com o ultimo
                if (pos2 == this.tamanho) {

                    tmp2 = this.ultimo;

                    tmp2Anterior = this.ultimo.getAnterior();

                    tmp1Proximo = this.primeiro.getProximo();

                    this.primeiro = tmp2;
                    this.primeiro.setAnterior(null);
                    this.primeiro.setProximo(tmp1Proximo);

                    tmp1Proximo.setAnterior(this.primeiro);

                    this.ultimo = tmp1;
                    this.ultimo.setAnterior(tmp2Anterior);
                    this.ultimo.setProximo(null);

                    tmp2Anterior.setProximo(this.ultimo);
                } else {
                    // 3º Caso primeiro com os do meio
                    for (p2 = 1, tmp2 = this.primeiro; p2 != pos2; p2++, tmp2 = tmp2.getProximo());

                    tmp1Proximo = tmp1.getProximo();

                    tmp2Anterior = tmp2.getAnterior();
                    tmp2Proximo = tmp2.getProximo();

                    this.primeiro = tmp2;
                    this.primeiro.setAnterior(null);
                    this.primeiro.setProximo(tmp1Proximo);

                    tmp2.setAnterior(null);
                    tmp2.setProximo(tmp1Proximo);

                    tmp1Proximo.setAnterior(this.primeiro);

                    tmp1.setAnterior(tmp2Anterior);
                    tmp1.setProximo(tmp2Proximo);

                    tmp2Anterior.setProximo(tmp1);
                    tmp2Proximo.setAnterior(tmp1);
                }
            }
        } else {
            if (pos2 == this.tamanho) {

                tmp2 = this.ultimo;

                // 4º caso ultimo com o penultimo
                if (pos1 == pos2 - 1) {
                    // pegando o penultimo
                    tmp1 = this.ultimo.getAnterior();
                    // pegando o anterior do penultimo
                    tmp1Anterior = tmp1.getAnterior();

                    this.ultimo = tmp1;
                    this.ultimo.setAnterior(tmp2);
                    this.ultimo.setProximo(null);

                    tmp2.setAnterior(tmp1Anterior);
                    tmp2.setProximo(tmp1);

                    tmp1Anterior.setProximo(tmp2);
                } else {
                    // 5º caso ultimo com os demais

                    tmp2Anterior = tmp2.getAnterior();

                    for (p1 = 1, tmp1 = this.primeiro; p1 != pos1; p1++, tmp1 = tmp1.getProximo());

                    tmp1Anterior = tmp1.getAnterior();
                    tmp1Proximo = tmp1.getProximo();

                    this.ultimo = tmp1;
                    this.ultimo.setAnterior(tmp2Anterior);
                    this.ultimo.setProximo(null);

                    tmp2Anterior.setProximo(this.ultimo);

                    tmp2.setAnterior(tmp1Anterior);
                    tmp2.setProximo(tmp1Proximo);

                    tmp1Anterior.setProximo(tmp2);
                    tmp1Proximo.setAnterior(tmp2);
                }
            } else {
                // 6º caso posições intermediárias laterais               
                if (pos2 == pos1 + 1) {

                    for (p1 = 0, tmp1 = this.primeiro; p1 != pos1; p1++, tmp1 = tmp1.getProximo());

                    tmp1Proximo = tmp1.getProximo();

                    tmp2 = tmp1.getAnterior();
                    tmp2Anterior = tmp1.getAnterior().getAnterior();

                    tmp1.setAnterior(tmp2Anterior);
                    tmp1.setProximo(tmp2);

                    tmp1Proximo.setAnterior(tmp2);

                    tmp2.setAnterior(tmp1);
                    tmp2.setProximo(tmp1Proximo);

                    tmp2Anterior.setProximo(tmp1);
                } else {
                    NohNumeros tmpAux = null;
                    // Caso 7 - posições intermediárias não laterais

                    for (p1 = 1, tmp1 = this.primeiro; p1 != pos1; p1++, tmp1 = tmp1.getProximo());
                    for (p2 = 1, tmp2 = this.primeiro; p2 != pos2; p2++, tmp2 = tmp2.getProximo());

                    tmp1Anterior = tmp1.getAnterior();
                    tmp1Proximo = tmp1.getProximo();

                    tmp2Anterior = tmp2.getAnterior();
                    tmp2Proximo = tmp2.getProximo();

                    tmpAux = tmp1;
                    tmp1 = tmp2;
                    tmp1.setAnterior(tmp1Anterior);
                    tmp1.setProximo(tmp1Proximo);

                    tmp1Anterior.setProximo(tmp1);
                    tmp1Proximo.setAnterior(tmp1);

                    tmp2 = tmpAux;
                    tmp2.setAnterior(tmp2Anterior);
                    tmp2.setProximo(tmp2Proximo);

                    tmp2Anterior.setProximo(tmp2);
                    tmp2Proximo.setAnterior(tmp2);

                    tmpAux = null;
                }
            }
        }
    }

// Objetivo: método para inserir um novo elemento numa determinada
//           posição da lista
//
    public void inserir_posicao(int pos) {
        // Este processo considera que a posição chegou validada

        Msg.limpatela();
        Msg.msg("Processando a inserção de um novo elemento por posição na lista");

        NohNumeros novo = new NohNumeros();

        if (novo == null) {
            Msg.msg("Não há espaço disponível para inserção!");
        } else {
            novo.setNumero(this.D_Numero());

            if (pos == 1) {
                if (this.primeiro == null) {
                    this.primeiro = this.ultimo = novo;
                    this.tamanho = 1;
                } else {
                    novo.setProximo(this.primeiro);
                    this.primeiro.setAnterior(novo);
                    this.primeiro = novo;
                    this.tamanho++;
                }
            } else {
                NohNumeros aux = null;
                int p = 0;

                for (aux = this.primeiro, p = 1;
                        aux != null && p != pos;
                        aux = aux.getProximo());

                if (aux == null) {
                    this.ultimo.setProximo(novo);
                    novo.setAnterior(this.ultimo);
                    this.ultimo = novo;
                } else {
                    novo.setProximo(aux);
                    novo.setAnterior(aux.getAnterior());
                    aux.setAnterior(novo);
                }
            }
        }

        Msg.enter();
    }

    // Objetivo: método para remover um elemento de uma determinada
    //           posição da lista
    //
    public void remover_posicao(int pos) {
        // Este processo considera que a posição está validada e correta

        Msg.msg("Processando a remoção por posição!");

        NohNumeros lib = null;

        if (pos == 1) {
            lib = this.primeiro;

            this.primeiro = this.primeiro.getProximo();

            if (this.primeiro == null) {
                this.ultimo = null;
            } else {
                this.primeiro.setAnterior(null);
                lib.setProximo(null);
            }
        } else {
            NohNumeros aux = null;
            int p = 0;

            for (aux = this.primeiro, p = 1;
                    p != pos;
                    aux = aux.getProximo());

            lib = aux;

            if (aux.getProximo() == null) {
                this.ultimo = this.ultimo.getAnterior();
                this.ultimo.setProximo(null);
                lib.setAnterior(null);
            } else {
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
                lib.setProximo(null);
                lib.setAnterior(null);
            }
        }

        lib.mostra_noh(0);
        this.tamanho--;

        System.gc();

        Msg.enter();
    }

    // Objetivo: método para remover todos os elementos que estão
    //           presentes na lista, inicializando-a. Tornando-a vazia.
    //
    public void inicializar() {
        NohNumeros lib = this.primeiro;
        Integer p = 1;

        do {
            this.primeiro = this.primeiro.getProximo();
            lib.setProximo(null);
            lib = this.primeiro;
            p++;
        } while (this.primeiro != null);

        this.ultimo = null;
        this.tamanho = 0;

        System.gc();

    }

    // Objetivo: método para consultar todos os elementos que estão
    //           presentes na lista
    //
    public void consultar_geral() {
        Msg.limpatela();

        NohNumeros aux = null;
        Integer pos = 0;

        for (aux = this.primeiro, pos = 1;
                aux != null;
                aux = aux.getProximo(), pos++) {
            aux.mostra_noh(pos);
        }

        Msg.msg("Total de nós existentes na lista: [" + this.tamanho + "]");

        Msg.enter();
    }

    // Objetivo: método para consultar se uma determinada posição está
    //           presente na lista e, se sim, qual elemento a ocupa
    //
    public void consultar_posicao(int posicao) {
        NohNumeros aux = null;
        int p = 0;

        for (aux = this.primeiro, p = 1;
                aux != null && p != posicao;
                aux = aux.getProximo(), p++) {
        };

        if (aux == null) {
            Msg.msg("Posição não existe na lista");
        } else {
            aux.mostra_noh(p);
        }
    }

    // Objetivo: método para consultar se um determinado elemento está
    //           presente na lista e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo(String conteudo) {
        NohNumeros aux = null;
        Integer p = 0;

        for (aux = this.primeiro, p = 1;
                aux != null && !aux.getNumero().equals(conteudo);
                aux = aux.getProximo(), p++) {
        };

        if (aux == null) {
            Msg.msg("O conteudo [" + conteudo + "] não existe na fila!");
        } else {
            aux.mostra_noh(p);
        }
    }

    // Objetivo: gerar números aleatórios para lista de elementos
    public Integer gera_numeros(Integer quantidade) {
        Msg.msg("Iniciando a geração de números aleatórios para a lista.");

        int numero = 0;
        int gerados = 0;

        if (quantidade <= 0) {
            quantidade = 1000;
        } else {
            quantidade++;
        }

        Random r = new Random();

        for (gerados = 1; gerados < quantidade; gerados++) {
            numero = r.nextInt();

            NohNumeros novo = new NohNumeros(null, numero, null);

            if (this.primeiro == null) {
                this.primeiro = this.ultimo = novo;
            } else {
                this.ultimo.setProximo(novo);
                novo.setAnterior(this.ultimo);
                this.ultimo = novo;
            }
        }

        gerados--;

        this.tamanho = gerados;

        this.consultar_geral();

        return gerados;
    }

    // Objetivo: carregar/salvar dados em arquivos
    public String xarq_escolhe_nome_arquivo(String texto) {
        Scanner s = new Scanner(System.in);
        String dados = " ";

        do {
            Msg.limpatela();

            try {
                Msg.msg("Digite o nome do arquivo para carga da [" + texto + "] ou x para não dar carga - não pode ser vazio: ");
                dados = s.nextLine();
            } catch (Exception e) {
                Msg.msg("Erro de digitação, não deixe a informação vazia:");
            }
        } while (dados.isEmpty());

        return dados;
    }

    public int xarq_tamanho_arquivo(String nome_arquivo) {
        //
        // Esta função lê o arquivo de dados e conta quantos registros ele possui.
        // A quantidade de registros é retornada e poderá ser utilizada como argumento
        // na criação do vetor de trabalho
        //
        int tamanho = 0;
        boolean prossegue = true;

        FileInputStream stream = null;

        try {
            stream = new FileInputStream(nome_arquivo);

            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = null;
            Msg.msg("Arquivo aberto!");
            //
            // Levantamento do tamanho do arquivo em termos de linhas
            //
            try {
                while ((line = reader.readLine()) != null) {
                    tamanho++;
                }

                try {
                    reader.close();
                } catch (IOException ioe) {
                    Msg.msg("Erro no fechamento do arquivo de leitura!");
                }

                try {
                    streamReader.close();
                } catch (IOException ioe) {
                    Msg.msg("Erro no fechamentdo do arquivo de stream reader!");
                }

                try {
                    stream.close();
                } catch (IOException ioe) {
                    Msg.msg("Erro no fechamento do arquivo stream!");
                }
            } catch (IOException ioe) {
                prossegue = false;
                Msg.msg("Arquivo com problemas na leitura!");
            }
        } catch (FileNotFoundException fe) {
            Msg.msg("Arquivo não encontrado!");
            prossegue = false;
        }

        return tamanho;
    }

    public int xarq_abre_arquivo(String texto) {
        //
        // Esta função lê o arquivo de dados e cria um vetor cujo tamanho é a
        // quantidade de registros do arquivo. O vetor, após ser populado, é devolvido
        // como resposta para o processo chamador.
        //
        Msg.msg("---------- Preparação do arquivo de entrada para carga da [" + texto + "] --------");

        String nome_arquivo = this.xarq_escolhe_nome_arquivo(texto);

        int tv = 0;

        if (nome_arquivo.equals("x")) {
            Msg.msg("Não será utilizado arquivo para entrada de dados para a [" + texto + "].");
        } else {
            tv = this.xarq_tamanho_arquivo(nome_arquivo);

            if (tv == 0) {
                tv = 1;
            }

            int i = 0;

            boolean prossegue = true;

            if (prossegue) {
                Msg.msg("Gravando dados na [" + texto + "]......");

                try {
                    FileInputStream stream = null;
                    InputStreamReader streamReader;
                    BufferedReader reader;
                    String line = null;
                    stream = new FileInputStream(nome_arquivo);
                    streamReader = new InputStreamReader(stream);
                    reader = new BufferedReader(streamReader);
                    line = null;
                    ArrayList<String> linha = new ArrayList<String>();

                    if (prossegue) {
                        try {
                            while ((line = reader.readLine()) != null) {
                                NohNumeros novo = new NohNumeros();

                                if (novo == null) {
                                    Msg.msg("Memória indisponível!");
                                } else {
                                    String[] elemento = line.split(";");

                                    Msg.msg("...Carregando Número: [" + line + "] [" + elemento[0] + "]");

                                    novo.setNumero(Integer.valueOf(elemento[0]));

                                    if (this.primeiro == null) {
                                        this.primeiro = this.ultimo = novo;
                                    } else {
                                        this.ultimo.setProximo(novo);
                                        novo.setAnterior(this.ultimo);
                                        this.ultimo = novo;
                                    }
                                }
                                i++;
                                tv++;
                            }
                        } catch (IOException ioe) {
                            prossegue = false;
                            Msg.msg("Arquivo com problemas na leitura!");
                        }

                        try {
                            reader.close();
                        } catch (IOException ioe) {
                            Msg.msg("Erro no fechamento do arquivo de leitura!");
                        }

                        try {
                            streamReader.close();
                        } catch (IOException ioe) {
                            Msg.msg("Erro no fechamentdo do arquivo de stream reader!");
                        }

                        try {
                            stream.close();
                        } catch (IOException ioe) {
                            Msg.msg("Erro no fechamento do arquivo stream!");
                        }
                    } else {
                        tv = 0;
                    }
                } catch (FileNotFoundException fe) {
                    prossegue = false;
                    Msg.msg("Arquivo não encontrado!");
                }
            }

            tv = tv / 2;

            Msg.msg("Tamanho do arquivo utilizado para a [" + texto + "]: [" + tv + "] linhas!");
        }
        Msg.enter();

        return tv;
    }

    public void xarq_salvar_arquivo(String texto) {
        //
        // Esta função recebe um vetor populado e, para cada posição (coluna), grava
        // um registro no arquivo de resposta, cujo nome é informado na função.
        //
        Msg.msg("-------------- Gravando arquivo de saída da [" + texto + "] --------------");

        String nome_arquivo = this.xarq_escolhe_nome_arquivo(texto);

        if (nome_arquivo.contains("x")) {
            Msg.msg("Não será utilizado arquivo para gravação de dados da [" + texto + "].");
        } else {
            FileWriter fileWriter = null;

            try {
                fileWriter = new FileWriter(nome_arquivo);
            } catch (IOException ex) {
                Msg.msg("Erro na gravação!");
            }

            PrintWriter writer = new PrintWriter(fileWriter);

            int i = 0;
            int tv = this.tamanho;
            NohNumeros aux = this.primeiro;

            do {
                writer.write(aux.getNumero() + "\n");
                aux = aux.getProximo();
            } while (aux != null);

            writer.close();

            try {
                fileWriter.close();
                Msg.msg("Arquivo gravado da [" + texto + "] com [" + tv + "] linhas!");
            } catch (IOException ex) {
                Msg.msg("Erro no fechamento do arquivo!");
            }
        }
    }

    // Objetivo: método de ordenação baseado no Bubble Sort
    //
    //
    public void ordena_bubble_sort_dreco() {
        Msg.msg("Bubble Sort.");
        Estatistica e = new Estatistica();

        long ti = e.tempoInicio();

        NohNumeros aux1, aux2, auxt = null;

        int i = 0, j = 0;

        aux1 = this.primeiro;
        i = 1;

        do {
            j = 1;
            aux2 = this.primeiro;
            e.interacoes++;

            do {
                e.interacoes++;
                e.condicoes++;

                if (aux2.getNumero() > aux2.getProximo().getNumero()) {
                    e.trocas++;
                    this.troca_de_lugar(j, j + 1);
                } else {
                    aux2 = aux2.getProximo();
                }

                j++;
            } 
            while (aux2.getProximo() != null);
            
            aux1 = this.primeiro;
            i++;
        } 
        while (i < this.tamanho);

        long tf = e.tempoFinal();
        e.mostrar(this.tamanho, ti, tf);
    }

    // Objetivo: método de ordenação baseado no Bubble Sort
    //
    //
    public void ordena_bubble_sort_aluno() {
        Msg.msg("- BUBBLE SORT");
        Estatistica e = new Estatistica();
        // inicialização padrão
        long ti = e.tempoInicio();

        NohNumeros aux1, aux2, auxt = null;

        int i = 0, j = 0;
        int v = this.tamanho;
        int y = this.tamanho;

        aux1 = this.primeiro;
        i = 1;

        do {
            aux2 = this.primeiro;
            j = 1;
            e.interacoes++;

            do {
                e.interacoes++;
                e.condicoes++;

                if (aux2.getNumero() > aux2.getProximo().getNumero()) {
                    e.trocas++;
                    this.troca_de_lugar(j, j + 1);
                } else {
                    aux2 = aux2.getProximo();
                }
                j++;
                v--;
            } 
            while (v != 1);

            y--;
            v = y;
            aux1 = this.primeiro;
            i++;
        } 
        while (y != 1);

        long tf = e.tempoFinal();
        e.mostrar(this.tamanho, ti, tf);
    }

    // Objetivo: método de ordenação baseado no Bubble Sort
    //
    //
    public void ordena_selection_sort() {
        Msg.msg("- SELECTION SORT");
        Estatistica e = new Estatistica();
        // inicialização padrão
        long ti = e.tempoInicio();

        NohNumeros aux1, aux2, aux3, auxt = null;

        int i = 0, j = 0;
        int menor = 0;
        int v = 0;
        boolean t = false;

        aux1 = this.primeiro;
        aux3 = this.primeiro;
        i = 1;

        do {
            aux2 = this.ultimo;
            j = this.tamanho;
            menor = 1;
            e.interacoes++;
            
            for (v = 1, aux3 = this.primeiro; 
                 v != i; 
                 v++, aux3 = aux3.getProximo());

            do {
                e.interacoes++;
                e.condicoes++;

                if (aux2.getNumero() < aux3.getNumero()) {
                    aux3 = aux2;
                    t = true;
                    menor = j;
                }
                aux2 = aux2.getAnterior();
                j--;
            } 
            while (j != i);
                if (t) {
                    e.trocas++;
                    this.troca_de_prioridade(menor, i);
                }
                i++;
                t = false;
        } 
        while (i < this.tamanho);

        long tf = e.tempoFinal();
        e.mostrar(this.tamanho, ti, tf);
    }

    // Objetivo: método de ordenação baseado no Insertion Sort
    //
    //
    public void ordena_insertion_sort() {
        Msg.msg("- INSERTION SORT ");
        Estatistica e = new Estatistica();
        // inicialização padrão
        long ti = e.tempoInicio();

        NohNumeros aux1, aux2, auxt = null;

        int i = 0, j = 0, v = 0, y = 0;

        aux1 = this.primeiro;
        aux2 = this.primeiro;
        i = 1;
        j = 1;

        do {
            e.interacoes++;

            do {
                e.interacoes++;
                e.condicoes++;

                if (aux2.getNumero() > aux2.getProximo().getNumero()) {
                    e.trocas++;
                    this.troca_de_lugar(j, j + 1);
                    j++;
                    aux2 = aux2.getAnterior();
                    j--;
                    e.condicoes++;
                    if (aux2.getAnterior() != null) {
                        do {
                            e.interacoes++;
                            e.condicoes++;
                            if (aux2.getNumero() < aux2.getAnterior().getNumero()) {
                                e.trocas++;
                                this.troca_de_lugar(j, j-1);
                                j--;
                            } else {
                                j = 1;
                            }
                        } 
                        while (j > 1);
                    }
                } else {
                    aux2 = aux2.getProximo();
                    aux1 = aux1.getProximo();
                    i++; 
                    j++;
                }
            } 
            while (j > 1 && aux2.getProximo() != null);
            aux2 = aux1;
            i++;
            j = i;
        } 
        while (i < this.tamanho);

        long tf = e.tempoFinal();
        e.mostrar(this.tamanho, ti, tf);
    } 

    // Objetivo: método de ordenação baseado no Quick Sort
    //
    //
    public void ordena_quick_sort() {
        Msg.msg("Aguarde implementação do Quick Sort.");
    }

    // Objetivo: método de ordenação baseado no Merge Sort
    //
    //
    public void ordena_merge_sort() {
        Msg.msg("Aguarde implementação do Merge Sort.");
    }

    // Objetivo: método de ornenação baseado no HeapSort
    //
    //
    public void ordena_heap_sort() {
        Msg.msg("Aguarde implementação do HeapSort.");
    }

    // Objetivo: método de ordenação baseado no Shell Sort
    //
    //
    public void ordena_shell_sort() {
        Msg.msg("Aguarde implementação do Shell Sort.");
    }

    // Objetivo: método de ordenação baseado no Radix Sort
    //
    //
    public void ordena_radix_sort() {
        Msg.msg("Aguarde implementação do Radix Sort.");
    }

    // Objetivo: método de ordenação baseado no Bucket Sort
    //
    //
    public void ordena_bucket_sort() {
        Msg.msg("Aguarde implementação do Bucket Sort.");
    }

    // Objetivo: método de ordenação baseado no Bucket Sort
    //
    //
    public LdeNumeros copia_lista(LdeNumeros lista) {
        LdeNumeros lista_resultado = new LdeNumeros();
        NohNumeros aux = null;

        for (aux = lista.primeiro; aux != null; aux = aux.getProximo()) {
            Msg.msg("Gravando..." + aux.getNumero().toString());
            NohNumeros novo = new NohNumeros(null, aux.getNumero(), null);

            if (lista_resultado.primeiro == null) {
                lista_resultado.primeiro = lista_resultado.ultimo = novo;
            } else {
                novo.setAnterior(lista_resultado.ultimo);
                lista_resultado.ultimo.setProximo(novo);
                lista_resultado.ultimo = novo;
            }
        }

        lista_resultado.tamanho = lista.tamanho;

        return lista_resultado;
    }

    // Objetivo: método construtor da lista e que determina que ela
    //           está, inicialmente, vazia
    //
    public LdeNumeros() {
        this.primeiro = this.ultimo = null;
    }
}
