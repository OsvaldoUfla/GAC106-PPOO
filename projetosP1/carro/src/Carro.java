/**
 * Classe que representa um carro no jogo de corrida
 * 
 * @author (Osvaldo Rodrigues De Faria Junior) 
 * @version 2.0
 */
public class Carro
{
    private String nome;
    private int velocidade;

    /**
     *Construtor cria um carro com o nome passado.
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
    public void acelerar(int valor)
    {
        velocidade = velocidade + valor;
    }
    
    /**
     * Desacelera o carro.
     */
    public boolean reduzir(int valor)
    {
        if((velocidade - valor) > 0)
        {
            velocidade = velocidade - valor;
            return true;
        }
        else
        {
            velocidade = 0;
            return false ;
        }
    }
}