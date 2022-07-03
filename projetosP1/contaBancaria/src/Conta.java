/**
 * Classe conta de um banco
 * 
 * autor Osvaldo, data 22-06-2022 
 */
public class Conta {
    //Atirbutos da classe conta
    private static int nroDecontas = 1000;
    //Atributos da conta
    private int nroDaconta;
    private double saldo;
    private double limite;
    private Cliente cliente1;
    
    //Construtor passando por parametros o limite e o nome do cliente
    Conta(double limite, Cliente cliente)
    {
        this(0.0,limite, cliente);
    }
    
    //Construtor passando por parametros saldo, limite e o nome do cliente
    Conta(double saldo, double limite, Cliente cliente)
    {
        this.saldo = saldo;
        this.limite = limite;
        this.cliente1 = cliente;
        nroDaconta = nroDecontas;
        nroDecontas++;        
    }

    //Retorna o nome, cpf e o saldo da conta numa String;
    public String getClienteSaldo()
    { 
        return "Cliente :" + cliente1.getNome() + "\n" 
                                            + cliente1.getCpf() + "\n" 
                                             + "Saldo : " + saldo + " \n";
    }

    //Consulta o número, retorna o numero da conta
    public int getN_conta()
    { 
        return nroDaconta;
    }

    //Saque o valor na conta, se tiver saldo ou limite.
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
