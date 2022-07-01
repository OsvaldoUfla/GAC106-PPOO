import java.util.Scanner;
/*
 * Classe Banco, classe para interagir com a classe Conta.
 * 
 * Autor Osvaldo 
 * Versão 25-06-2022
 */

public class Banco {
    private Conta conta;
    //private Conta conta1;

    Scanner entrada = new Scanner(System.in);
    private int opcao = 0;     
    public void loop()
    {
        while(opcao != 6)
        {
            opcao = exibirMenu(entrada);
            if(opcao == 1)
            {
                criaConta();          
            }
            else if(opcao == 2)
            {
                exibeCliente();            }
            
            else if(opcao == 3)
            {
                depositar2();
            }
            
            else if(opcao == 4)
            {
                sacar2();
            }

            else if(opcao == 5)
            {
                transferencia2();
            }
            
            else if(opcao == 6)
            {
                despedida();
            }
            
            else
            {
                System.out.println("Opçao invalida! ");
            }
            
            if(opcao !=6 )
            {
                aguardarEnter(entrada);
            }
        }
    }
    
    Banco()
    {
        conta = null;
    }

    
    private void criaConta()
    {
        System.out.println("Deseja criar a conta saldo inicial? (s para SIM OU n para NÃO) ");
        String simNao = entrada.nextLine();
        if(simNao.equals("s") || simNao.equals("S"))
        {
            /*
             * Método cria conta com saldo informado
            */
            System.out.println(" Saldo : ");
            double saldo = entrada.nextDouble();
            System.out.println(" Limite : ");
            double limite = entrada.nextDouble();
            conta = new Conta(saldo, limite, cadastraCliente());
            System.out.println("Conta numero " + conta.getN_conta() + " criada com socesso ");
        }
        else
        {   
            /*
             * Método cria conta com saldo incial zero
            */
            System.out.println(" Limite : ");
            double limite = entrada.nextDouble();
            conta = new Conta(limite, cadastraCliente());
            System.out.println("Conta numero " + conta.getN_conta() + " criada com socesso ");
        }
        
        System.out.println("Deseja criar a conta saldo inicial? (s para SIM OU n para NÃO) ");
        simNao = entrada.nextLine();
        if(simNao.equals("s") || simNao.equals("S"))
        {
            /*
             * Método cria conta com saldo informado
            */
            System.out.println(" Saldo : ");
            double saldo = entrada.nextDouble();
            System.out.println(" Limite : ");
            double limite = entrada.nextDouble();
            conta1 = new Conta(saldo, limite, cadastraCliente());
            System.out.println("Conta numero " + conta1.getN_conta() + " criada com socesso ");
        }
        else
        {   
            /*
             * Método cria conta com saldo incial zero
            */
            System.out.println(" Limite : ");
            double limite = entrada.nextDouble();
            conta1 = new Conta(limite, cadastraCliente());
            System.out.println("Conta numero " + conta1.getN_conta() + " criada com socesso ");
        }
    }

    private Cliente cadastraCliente()
    {
        entrada.nextLine();
        System.out.println(" Nome do Cliente : ");
        String nomeMenu = entrada.nextLine();
        System.out.println(" Cpf do cliente : ");
        String cpfMenu = entrada.nextLine();
        
        return Cliente.novoCliente(nomeMenu, cpfMenu);
    }

    /*
     * Exibe nome cpf e saldo do cliente
     */
     private void exibeCliente()
     {
        System.out.println("insira o numero da conta : ");
        int opcaoDoUsuario = Integer.parseInt(entrada.nextLine());
        if(opcaoDoUsuario == conta.getN_conta())
        {
            System.out.println(conta.getClienteSaldo());
        }
        else if(opcaoDoUsuario == conta1.getN_conta())
        {
            System.out.println(conta1.getClienteSaldo());
        }
     }

     /*
      * Realiza um depósito para as duas contas
      */
    private void depositar2()
    {
        System.out.println("insira o numero da conta : ");
        int opcaoDoUsuario = Integer.parseInt(entrada.nextLine());
        System.out.println("Insira o valor a ser depositado : ");
        double quanto = entrada.nextDouble();
        if(opcaoDoUsuario == conta.getN_conta())
        {
            depositar(conta, quanto); 
        }

        else if(opcaoDoUsuario == conta1.getN_conta())
        {
            depositar(conta1, quanto);
        }
        System.out.println("Depósito realizado! ");
    }

     /*
      * Realiza um depósito
      */
    private void depositar(Conta contax, double quanto)
    {
        contax.deposito(quanto);
    }
    
    /*
     * Realiza um saque em uma da duas contas
     */
    private void sacar2()
    {
        System.out.println("insira o numero da conta : ");
        int opcaoDoUsuario = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite o valor a ser sacado : ");
        double quanto = entrada.nextDouble();
        boolean saqueRealizado = true;
        if(opcaoDoUsuario == conta.getN_conta())
        {
           
            saqueRealizado = sacar(conta, quanto);
        }

        else if(opcaoDoUsuario == conta1.getN_conta())
        {
            saqueRealizado = sacar(conta1, quanto);
        }

        if(saqueRealizado)
        {
            System.out.println("Saque realizado! ");
        }
        else
        {
            System.out.println("Saldo ou limite insuficiente! ");
        }
    }


    /*
     * Realiza um saque
     */
    private boolean sacar(Conta contax, double quanto)
    {
        return contax.saque(quanto);
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
    private void transferencia2()
    {
        boolean positivo = true;
        System.out.println("insira o numero da conta Origem : ");
        int origem = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite o valor a ser transferido : ");
        double quanto = entrada.nextDouble();

        if(origem == conta.getN_conta())
        {
            positivo = transferencia(quanto, conta, conta1);
        }
        else if(origem == conta1.getN_conta())
        {
            positivo = transferencia(quanto, conta1, conta);
        }

        if(positivo)
        {
            System.out.println("transferência realizada com sucesso! : ");
        }
        else
        {
            System.out.println("transferência não realizada ");
            System.out.print("Saldo ou limite insuficiente! ");
        }
        
    }

     /*
      * Exibe despedida
      */
    private static void despedida()
    {
        System.out.println("Ate mais! ");
    }

    /**
     * Exibe o menu 
     */
    private static int exibirMenu(Scanner entrada)
    {
        System.out.println("");
        System.out.println("1) Criar conta ");
        System.out.println("2) consultar saldo ");
        System.out.println("3) Depositar ");
        System.out.println("4) Realizar saque ");
        System.out.println("5) Realizar transferência ");
        System.out.println("6) Sair");
        System.out.println("Digite opçao desejada : ");
        int opcaoDoUsuario = Integer.parseInt(entrada.nextLine());
        return opcaoDoUsuario;
    }
        
    /**
     * Aguarda o usuario digitar o enter pra exibir o menu de novo.
     */
    private static void aguardarEnter(Scanner entrada)
    {
        System.out.println("Digite ENTER para continuar ");
        System.out.println("");
        entrada.nextLine();
    }
}

