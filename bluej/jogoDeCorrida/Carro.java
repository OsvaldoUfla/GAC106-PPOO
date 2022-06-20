
/**
 * Classe que representa um carro no jogo de corrida
 * 
 * @author (Osvaldo Rodrigues De Faria Junior) 
 * @version (20/06/2022)
 */
public class Carro
{
    // ATENÇAO : Esta  classe fere principios de OO que ainda serao vistos!!
    String nome;
    int velocidade;

    /**
     * Cria um carro com o nome passado.
     */
    public Carro(String umNome)
    {
        nome = umNome;
        velocidade = 0;
    }

    /**
     * Retorna o nome do carro.
     */
    String getNome()
    {
                return nome;
    }
    
    /**
     * Retorna a velocidade do carro.
     */
    int getVelocidade()
    {
                return velocidade;
    }
    
    /**
     * Acelera o carro.
     */
    void acelerar()
    {
        velocidade = velocidade + 10;
    }
    
    /**
     * Desacelera o carro.
     */
    void reduzir()
    {
        velocidade = velocidade - 10;
    }
    
    /**
     * 
     */
    
}
