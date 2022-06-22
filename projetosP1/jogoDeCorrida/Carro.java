
/**
 * Classe que representa um carro no jogo de corrida
 * 
 * @author (Osvaldo Rodrigues De Faria Junior) 
 * @version (20/06/2022)
 */
public class Carro
{
    // ATENÇAO : Esta  classe fere principios de OO que ainda serao vistos!!
    private String nome;
    private int velocidade;

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
    public String getNome()
    {
                return nome;
    }
    
    /**
     * Retorna a velocidade do carro.
     */
    public int getVelocidade()
    {
                return velocidade;
    }
    
    /**
     * Acelera o carro.
     */
    public void acelerar()
    {
        velocidade = velocidade + 10;
    }
    
    /**
     * Desacelera o carro.
     */
    public void reduzir()
    {
        velocidade = velocidade - 10;
    }
    
    /**
     * 
     */
    
}
