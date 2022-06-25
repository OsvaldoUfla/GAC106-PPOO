
/**
 * Classe conta do projeto conta bancaria  
 * exercicio pratico da 1º lista de exercicios 
 * implementado no vscode com esta copia no bluej para depuraçao
 * @author Osvaldo 
 * @version (25-06-2022
 */
public class Conta {
    //Atributos da conta
    private double saldo;
    private double limite;

    //Construtor sem parametros
    Conta()
    {
        this(0.0 , 0.0);
    }

    //Construtor passando parametros
    Conta(double saldo, double limite)
    {
        this.saldo = saldo;
        this.limite = limite;
    }

    //Consulta o saldo
    public double getSaldo()
    { 
       return saldo;
    }

    //Saque
    public boolean saque(double valor)
    {
        //Se o valor a ser sacado é menor ou igual ao saldo mais o limite
        //o saque é realizado e o valor é deduzido do saldo da conta
        if(valor <= (saldo + limite))
        {
            saldo = saldo - valor;
            return true;
        }
        else 
        {
            return false;
        }
        
        
    }

    public void deposito(double valor)
    {
       saldo = saldo + valor;
    }
    
    
}
