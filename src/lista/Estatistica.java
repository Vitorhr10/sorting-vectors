/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lista;

/**
 *
 * @author vitor
 */
public class Estatistica
{
    int interacoes = 0;
    int condicoes = 0;
    int trocas = 0;
   
    long tExec = 0;

    public long tempoInicio ()
    {
        long tempoInicial = System.currentTimeMillis();
        return tempoInicial;
    }
    public long tempoFinal ()
    {
        long tempoFinal = System.currentTimeMillis();
        return tempoFinal;
    }
    public void mostrar(int elementos, long ti, long tf)
    {
        long dt = tf - ti;
        
        System.out.println();
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.println("|       Elementos |      Interações |       Condições |          Trocas |     Tempo inic  |     Tempo final |        Execução |");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.format ("| %15d | %15d | %15d | %15d | %15d | %15d | %15d |",
                elementos, this.interacoes, this.condicoes, this.trocas, ti, tf, dt);
        System.out.println();
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }
}
