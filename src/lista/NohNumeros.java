/* Projeto...: Lista Duplamente Ligada
 * Autor.....: Vitor
 * Biblioteca: NohNumeros
 * Classe....: NohNumeros
 * Objetivo..: Criação do nó (elemento) que será utilizado nos projetos
 */
package lista;

public class NohNumeros
{
    // Objetivo: atributo de determinação do objeto para servir de referência
    //           no armazenamento dos dados de um elemento da lista
    //
    private Integer numero;
    
    // Objetivo: atributo de determinação do objeto para expressar a ligação
    //           do elemento para um outro elemento da lista
    //
    private NohNumeros proximo;
    
    // Objetivo: atributo de determinação do objeto para expressar a ligação
    //           do elemento para um outro elemento da lista
    //
    private NohNumeros anterior;

    // Objetivo: método para registrar o preenchimento do atributo número
    //            
    //
    public void setNumero(Integer numero)
    {
        this.numero = numero;
    }

    // Objetivo: método para retornar o atributo número
    //            
    //
    public Integer getNumero()
    {
        return this.numero;
    }

    // Objetivo: método para registrar o preenchimento do atributo
    //           de ligação de um elemento da lista a outro elemento
    //
    public void setAnterior(NohNumeros anterior)
    {
        this.anterior = anterior;
    }

    // Objetivo: método para registrar o preenchimento do atributo
    //           de ligação de um elemento da lista a outro elemento
    //
    public void setProximo(NohNumeros proximo)
    {
        this.proximo = proximo;
    }

    // Objetivo: método para buscar informações sobre o atributo de
    //           ligação do elemento atual a um outro da lista
    //
    public NohNumeros getProximo()
    {
        return proximo;
    }

    // Objetivo: método para buscar informações sobre o atributo de
    //           ligação do elemento atual a um outro da lista
    //
    public NohNumeros getAnterior()
    {
        return anterior;
    }

    // Objetivo: método para mostrar os dados de um elemento
    //
    //
    public void mostra_noh (int posicao)
    {
        if ((posicao == 1) || (posicao == 0))
        {
            System.out.println();
            System.out.println("| Posicao |    Anterior |      Número |     Próximo |");
            System.out.println("| ------- | ----------- | ----------- | ----------- |");

            if (posicao == 0)
            {
                System.out.println("| Atenção! Removendo o elemento secionado! |");
                System.out.println("| ------- | ----------- | ----------- | ----------- |");
            }
        }
        if (this.getProximo() == null)
        {
            if (this.getAnterior() == null)
            {
                System.out.format ("| %7d |        null | %11d |        null |",
                posicao, this.getNumero());
            }
            else
            {
                System.out.format ("| %7d | %11d | %11d |        null |",
                posicao, this.getAnterior().getNumero(), this.getNumero());
            }
            System.out.println();
        }
        else
        {
            if (this.getAnterior() == null)
            {
                System.out.format ("| %7d |        null | %11d | %11d |",
                    posicao, this.getNumero(), this.getProximo().getNumero());
            }
            else
            {
                System.out.format ("| %7d | %11d | %11d | %11d |",
                    posicao, this.getAnterior().getNumero(), this.getNumero(), this.getProximo().getNumero());
            }
            System.out.println();
        }
    }

    // Objetivo: método de apoio da construção do NOH e que registra o
    //           preenchimento dos dados e da ligação de um elemento da lista
    //
    public NohNumeros (NohNumeros anterior, Integer numero, NohNumeros proximo)
    {
        this.anterior = anterior;
        this.numero = numero;
        this.proximo = proximo;
    }
    
    // Objetivo: método responsável pela construção de objetos desta classe
    //
    public NohNumeros()
    {
        this.anterior = null;
        this.numero = 0;
        this.proximo = null;
    }
}
