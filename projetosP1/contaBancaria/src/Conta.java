/**
 * Classe conta de um banco
 * 
 * autor Osvaldo, data 22-06-2022 
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
    //Deposita o valor na conta.
    public void deposito(double valor)
    {
       saldo = saldo + valor;
    }
    
    
}
