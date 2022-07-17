import java.util.ArrayList;
/*
 * Classe Banco, classe para interagir com a classe Conta.
 * 
 * Autor Osvaldo 
 * Versão 25-06-2022
 */

public class Banco {
    ArrayList<Conta> contas;
    private Interface interfaceDoUsuario;
    private int opcao;

    public void loop()
    {
        while(opcao != 8)
        {
            opcao = interfaceDoUsuario.exibirMenu();
            if(opcao == 1)
            {
                criaConta();          
            }
            else if(opcao == 2)
            {
                String opcao6 = exibeCliente(interfaceDoUsuario.nroConta());
                if(opcao6.equals("-1"))
                {
                    interfaceDoUsuario.invalida();
                }
                else
                {
                    interfaceDoUsuario.exibeInformacao(opcao6); 
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
                double n1 = interfaceDoUsuario.qualValor();
                int n2 = interfaceDoUsuario.nroConta();
                int n3 = interfaceDoUsuario.nroConta();
                transferencia2(n1, n2, n3);
            }
            
            else if(opcao == 6)
            {
                exibeListaContas();
            }

            else if(opcao == 7)
            {
                int m = buscaPeloNumero(interfaceDoUsuario.nroConta());
                if(m != -1)
                {
                    interfaceDoUsuario.exibeInformacao(remover(m));
                }
                //remover conta
            }

            else if(opcao == 8)
            {
                interfaceDoUsuario.despedida();
            }
            
            else
            {
                interfaceDoUsuario.invalida();
            }
            
            if(opcao !=8)
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
        interfaceDoUsuario =  new Interface();
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
        int indice = buscaPeloNumero(n);
            if(n != -1)
            {
                return "\nNome : " + contas.get(indice).getNome()+ "\nCpf : " + contas.get(indice).getCPf() + "\nSaldo : " + contas.get(indice).getSaldo();
            }

        return "-1";        
     }

     /*
      * Realiza um busca usando o numero da conta como chave e
      *retorna o objeto  
      */
    private int buscaPeloNumero(int n)
    {
        for(int i = 0; i < contas.size(); i++ )
        {
            if(contas.get(i).getN_conta() == n)
            {
                return i;
            }

        }
        return -1;
    }

     /*
      * Realiza um depósito
      */
    private void depositar(int numeroDaConta, double quanto)
    {
        int indice = buscaPeloNumero(numeroDaConta);
        if(indice != -1)
        {
            contas.get(indice).deposito(quanto);
        }
        else
        {
            interfaceDoUsuario.invalida();
        }
    }
    

    /*
     * Remove uma conta do ArrayList
     */
    private String remover(int n)
    {
        if(contas.get(n).getSaldo() == 0)
        {
            contas.remove(n);
            return "Conta removida";
        }
        else if (contas.get(n).getSaldo() < 0 )
        {
            return "Conta com debito";
        }
        else if (contas.get(n).getSaldo() > 0 )
        {
            return "Conta com saldo";
        }
        return "Erro";
    }
   
    /*
     * Realiza um saque
     */
    private void sacar(int numeroDaConta, double quanto)
    {
        int indice = buscaPeloNumero(numeroDaConta);
        if(indice != -1)
        {
            if(contas.get(indice).saque(quanto))
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
    private boolean transferencia(double valor, int contaOrigem, int contaDestino)
    {
        boolean positivo = contas.get(contaOrigem).saque(valor);
        if(positivo)
        {
            contas.get(contaDestino).deposito(valor);
        }

        return positivo;
    }


    /*
     * transferência entre contas duas contas
     */
    private void transferencia2(double valor, int origem, int destino)
    {
        int contaO = buscaPeloNumero(origem);
        int contaD = buscaPeloNumero(destino);
        if((contaO != -1) || (contaD != -1))
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

    /*
     * Exibe uma lista de contas já criadas 
     */
    private void exibeListaContas()
    {
        String texto ="\nNome -> Numero da conta\n";
        for(Conta conta : contas)
        {
             texto += conta.getNome() + "    " + conta.getN_conta() + "\n";
            
        }
        interfaceDoUsuario.exibeInformacao(texto);
    }

}

