/*
 * Projeto.: Lista Duplamente Ligada
 * Autor...: Vitor
 * Classe..: Msg
 * Objetivo: Biblioteca para mensagens de interação com o usuário
 */
package lista;
import java.util.Scanner;

public class Msg
{
    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos
    //
    public static void msg (String mensagem)
    {
        System.out.println(mensagem);
    }

    // Objetivo: simular a limpeza da tela para despoluir a área
    //           de saída (resultados) dos projetos
    //
    public static void limpatela()
    {
        for (int i=0; i<50; i++)
        {
            msg (" ");
        }
        msg ("****** Lista Duplamente Ligada - Tipo FILA! ******");
    }

    // Objetivo: possibilitar uma ação interativa para com o usuário
    //           visando chamar a atenção para algumas mensagens
    //
    public static void enter ()
    {
        Scanner s = new Scanner(System.in);
        msg ("Pressione <enter> para prosseguir");

        String tecla = s.nextLine();

        limpatela();
    }

    // Objetivo: menu padrão para as atividades de inserção/remoção nas
    //           extremidades para os deques
    //
    public static void menu_extremidade()
    {
        limpatela();
        msg("----------- Menu Extremidade -- Escolha sua opcao -----------");
        msg("1. Início");
        msg("2. Final");
        msg("0. Retornar");
        msg("-------------------------------------------------------------");
    }

    // Objetivo: menu padrão para as atividades de consulta
    //           relacionadas às listas
    //
    public static void menu_consulta()
    {
        limpatela();
        msg("------------- Menu Consulta - Escolha sua opcao -------------");
        msg("1. Geral");
        msg("2. Por posição");
        msg("3. Por conteúdo");
        msg("0. Finalizar");
        msg("-------------------------------------------------------------");
    }

    // Objetivo: menu padrão para as atividades de escolha de listas
    //           
    //
    public static void menu_lista()
    {
        limpatela();
        msg("------------ Menu de Listas - Escolha sua opcao -------------");
        msg("1. Lista 1");
        msg("2. Lista 2");
        msg("3. Lista 3");
        msg("0. Finalizar");
        msg("-------------------------------------------------------------");
    }

    // Objetivo: menu padrão para as atividades principais
    //           relacionadas às listas
    //
    public static void menu_principal()
    {
        limpatela();
        msg("------------ Menu Principal -- Escolha sua opção ------------");
        msg(" 1. Inserir                            7. Troca elemento de prioridade");
        msg(" 2. Remover                            8. Gerar lista de números");
        msg(" 3. Consultar                          9. Ordenação");
        msg(" 4. Inicializar                        10. Listar duas listas simultâneamente");
        msg(" 5. Tamanho                            11. Copiar uma lista para outra");
        msg(" 6. Troca elementos de posição         12. Carregar uma lista ja pronta");
        msg(" ");
        msg("                                       0. Finalizar");
        msg("-------------------------------------------------------------");
    }

    // Objetivo: menu padrão para as atividades principais
    //           relacionadas às listas
    //
    public static void menu_ordenacao()
    {
        limpatela();
        msg("------------ Menu Ordenação -- Escolha sua opção ------------");
        msg(" 1. Bubble Sort                6. Heapsort");
        msg(" 2. Selectin Sort              7. Shell Sort");
        msg(" 3. Insertion Sort             8. Radix Sort");
        msg(" 4. Quick Sort                 9. Bucket Sort");
        msg(" 5. Merge Sort                 10. Bubble Sort Dreco");
        msg("");
        msg(" 0. Finalizar");
        msg("-------------------------------------------------------------");
    }

    // Objetivo: função para receber e tratar a opção em relação à extremidade
    //           de atividades de inserção/remoção nos deques
    //
    public static int opcao_extremidade()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_extremidade();
        msg ("Digite a extremidade desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 2) && (erro != 1))
        {
            menu_extremidade();
            msg ("Extremidade inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber e tratar a opção em relação às consultas
    //           
    //
    public static int opcao_consulta()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_consulta();
        msg ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 3) && (erro != 1))
        {
            menu_consulta();
            msg ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber e tratar a opção em relação às consultas
    //           
    //
    public static int opcao_lista(String tipo)
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_lista();
        msg ("Digite a lista desejada para "+tipo+": ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 3) && (erro != 1))
        {
            menu_lista();
            msg ("Lista inválida, corrija para "+tipo+": ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber e tratar a opção em relação ao menu
    //           principal das atividades relacionadas às listas
    //
    public static int opcao_principal()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_principal();
        msg ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 12) && (erro != 1))
        {
            menu_principal();
            msg ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }


    // Objetivo: função para receber e tratar a opção em relação ao menu
    //           principal das atividades relacionadas às listas
    //
    public static int opcao_ordenacao()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_ordenacao();
        msg ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 10) && (erro != 1))
        {
            menu_principal();
            msg ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber o valor de uma posição para
    //           as atividades relacionadas às listas que a requeiram
    //
    public static int solicita_posicao()
    {
        Scanner s = new Scanner(System.in);
        int posicao = 0;

        try
        {
            msg ("Digite a posicao desejada ou zero para retornar: ");
            posicao = s.nextInt();
        }
        catch(Exception e)
        {
            posicao = 0;
        }
        return posicao;
    }

    // Objetivo: função para receber o valor de um conteúdo para
    //           as atividades relacionadas às listas que o requeiram
    //
    public static String solicita_conteudo()
    {
        Scanner s = new Scanner(System.in);
        String conteudo = " ";

        try
        {
            msg("Digite o conteudo a ser pesquisado ou tecle <enter> para retornar: ");
            conteudo = s.next();
        }
        catch(Exception e)
        {
            msg ("Erro de digitação, retornando ao menu principal...");
            conteudo = " ";
        }
        return conteudo;
    }

    // Objetivo: função para receber a quantidade de número randomicos
    //           para serem inseridos como elementos
    //
    public static int solicita_quantidade()
    {
        Scanner s = new Scanner(System.in);
        int quantidade = 0;

        try
        {
            msg ("Digite a quantidade desejada de elementos a gerar na lista ou zero para retornar: ");
            quantidade = s.nextInt();
        }
        catch(Exception e)
        {
            quantidade = 0;
        }
        return quantidade;
    }
}
