import java.util.Scanner;


/**
 * Classe principal do prototipo do jogo de corrida
 * 
 * @author (Osvaldo) 
 * @version (20/06/2022)
 */
public class Jogo
{
    public static void main(String[] args)
    {
        System.out.println("Prototipo do jogo de corrida");
        
        Carro carro;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("digite o nome do carro");
        String nome = entrada.next();
        
        carro = new Carro(nome);
        
        System.out.println("Carro foi criado");
        System.out.println("Nome: " + carro.getNome() + " e velocidade: " + carro.getVelocidade());
        
        carro.acelerar();
        System.out.println("Nome: " + carro.getNome() + " e velocidade: " + carro.getVelocidade());
        
        carro.acelerar();
        System.out.println("Nome: " + carro.getNome() + " e velocidade: " + carro.getVelocidade());
        
        carro.reduzir();
        System.out.println("Nome: " + carro.getNome() + " e velocidade: " + carro.getVelocidade());
    }
}
