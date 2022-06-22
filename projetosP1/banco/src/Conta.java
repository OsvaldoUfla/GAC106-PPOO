/**
 * Classe conta de um banco
 * 
 * autor Osvaldo, data 22-06-2022 
 */



public class Conta {
    //Atributos da conta
    private double saldo;
    private double limite;
    private double limiteUtilizado;

    //Construtor
    Conta()
    {
        this(0.0 , 0.0);
    }

    //Construtor
    Conta(double saldo, double limite)
    {
        this.saldo = saldo;
        this.limite = limite;
        limiteUtilizado = 0;
    }

    //Consulta o saldo
    public String getSaldo()
    {
       String mensagem = saldo;
       return mensagem;
    }

    //Método private para controle do limite

    //Saque
    public String saque(double valor)
    {
        String tSaldo;
        if(valor <= saldo)
        {
            saldo = saldo - valor;
            tSaldo = "Saque realizado com sucesso.";
        }
        else if(valor <= (saldo + (limite - limiteUtilizado)))
        {
            limiteUtilizado = (valor - saldo);
            saldo = saldo - valor;
            tSaldo = "Saque realizado com sucesso, limite foi utilizado.";
        }
        else 
        {
            tSaldo = "Saque não realizado, saldo e limite insuficiente.";
        }

        return tSaldo;
        
    }

    public String deposito(double valor)
    {
        String tDeposito;
        if(saldo >= 0)
        {
            saldo = saldo + valor;
            tDeposito = "Deposito realizado com sucesso.";
        }
        else if()
        {
            double n =
        }
        return tDeposito;
    }
    
    
}
