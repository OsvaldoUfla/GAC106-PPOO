import java.util.ArrayList;
/*
 * Classe Banco, classe para interagir com a classe Conta.
 * 
 * Autor Osvaldo 
 * Versão 25-06-2022
 */

public class Banco {
    ArrayList<Conta> contas;
    private Interface interfaceDoUsuario =  new Interface();
    private int opcao;

    public void loop()
    {
        while(opcao != 6)
        {
            opcao = interfaceDoUsuario.exibirMenu();
            if(opcao == 1)
            {
                criaConta();          
            }
            else if(opcao == 2)
            {
                if(exibeCliente(interfaceDoUsuario.nroConta()).equals("-1"))
                {
                    interfaceDoUsuario.invalida();
                }
                else
                {
                    interfaceDoUsuario.exibeInformacao(exibeCliente(interfaceDoUsuario.nroConta())); 
                }
            }
            
            else if(opcao == 3)
            {
                depositar(interfaceDoUsuario.nroConta(), interfaceDoUsuario.qualValor());
            }
            
            else if(opcao == 4)
            {
                sacar(interfaceDoUsuario.nroConta(),interfaceDoUsuario.qualValor());
            }

            else if(opcao == 5)
            {
                interfaceDoUsuario.exibeTransferencia();
                transferencia2(interfaceDoUsuario.qualValor(),interfaceDoUsuario.nroConta(),interfaceDoUsuario.nroConta());
            }
            
            else if(opcao == 6)
            {
                interfaceDoUsuario.despedida();
            }
            
            else
            {
                interfaceDoUsuario.invalida();
            }
            
            if(opcao !=6 )
            {
                interfaceDoUsuario.aguardarEnter();
            }
        }
    }
    
    /*
     * construtor
     */
    Banco()
    {
        contas = new ArrayList<Conta>();
        opcao = 0;
    }

    /*
     * Cria uma conta nova e inseri no ArrayList
     */
    private void criaConta()
    {
        String[] nCpf = interfaceDoUsuario.nomeCPF();
        Cliente cliente = new Cliente(nCpf[0], nCpf[1]);

        Double[] sLimite = interfaceDoUsuario.saldoLimite();

        if(sLimite[0] > 0.0)
        {
            contas.add(new Conta(sLimite[0], sLimite[1], cliente));
            interfaceDoUsuario.exibeNroConta(contas.get(contas.size()-1).getN_conta());
        }
        else
        {
            contas.add(new Conta(sLimite[1], cliente));
            interfaceDoUsuario.exibeNroConta(contas.get(contas.size()-1).getN_conta());
        }
    }

    /*
     * Exibe nome cpf e saldo do cliente
     */
     private String exibeCliente(int n)
     {
        Conta conta = buscaPeloNumero(n);
            if(conta != null)
            {
                return conta.getClienteSaldo();
            }

        return "-1";        
     }

     /*
      * Realiza um busca usando o numero da conta como chave e
      *retorna o objeto  
      */
    private Conta buscaPeloNumero(int n)
    {
        for(Conta conta : contas)
        {
            if(conta.getN_conta() == n)
            {
                return conta;
            }

        }
        return null;
    }

     /*
      * Realiza um depósito
      */
    private void depositar(int numeroDaConta, double quanto)
    {
        Conta conta = buscaPeloNumero(numeroDaConta);
        if(conta != null)
        {
            conta.deposito(quanto);
        }
        else
        {
            interfaceDoUsuario.invalida();
        }
    }
    
   
    /*
     * Realiza um saque
     */
    private void sacar(int numeroDaConta, double quanto)
    {
        Conta conta = buscaPeloNumero(numeroDaConta);
        if(conta != null)
        {
            if(conta.saque(quanto))
            {
                interfaceDoUsuario.ok();
            }
            else
            {
                interfaceDoUsuario.semSaldo();
            }
        }
        else
        {
            interfaceDoUsuario.invalida();
        }
    }


    /*
     * transferência entre contas
     */
    private boolean transferencia(double valor, Conta contaOrigem, Conta contaDestino)
    {
        boolean positivo = contaOrigem.saque(valor);
        if(positivo)
        {
            contaDestino.deposito(valor);
        }

        return positivo;
    }


    /*
     * transferência entre contas duas contas
     */
    private void transferencia2(double valor, int origem, int destino)
    {
        Conta contaO = buscaPeloNumero(origem);
        Conta contaD = buscaPeloNumero(destino);
        if((contaO != null) || (contaD != null))
        {
            if(transferencia(valor,  contaO, contaD))
            {
                interfaceDoUsuario.ok();
            }
            else
            {
                interfaceDoUsuario.semSaldo();
            }
        }
        else
        {
            interfaceDoUsuario.invalida();
        }
    }


}

