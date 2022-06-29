import java.util.Scanner;
/*
 * Classe Banco, classe para interagir com a classe Conta.
 * 
 * Autor Osvaldo 
 * Versão 25-06-2022
 */

public class Banco {
    private Conta conta;
    Scanner entrada = new Scanner(System.in);
    private int opcao = 0;     
    public void loop()
    {
        while(opcao != 5)
        {
            opcao = exibirMenu(entrada);
            if(opcao == 1)
            {
                System.out.println(" Nome do Cliente : ");
                String nomeMenu = entrada.nextLine();
                System.out.println(" Cpf do cliente : ");
                String cpfMenu = entrada.nextLine();
                System.out.println(" Saldo : ");
                double saldo = entrada.nextDouble();
                System.out.println(" Limite : ");
                double limite = entrada.nextDouble();
                conta = new Conta(saldo, limite, nomeMenu, cpfMenu);
            }
            else if(opcao == 2)
            {
                System.out.println(conta.getSaldo());
            }
            
            else if(opcao == 3)
            {
                System.out.println("Insira o valor a ser depositado : ");
                double quanto = entrada.nextDouble();
                conta.deposito(quanto);
                System.out.println("Depósito realizado! ");
            }
            
            else if(opcao == 4)
            {
                System.out.println("Digite o valor a ser sacado : ");
                double quanto = entrada.nextDouble();
                if(conta.saque(quanto))
                {
                    System.out.println("Saque realizado! ");
                }
                else
                {
                    System.out.println("Saldo ou limite insuficiente! ");
                }
            }
            
            else if(opcao == 5)
            {
                System.out.println("Ate mais! ");
            }
            
            else
            {
                System.out.println("Opçao invalida! ");
            }
            
            if(opcao !=5 )
            {
                aguardarEnter(entrada);
            }
        }
    }
    
    Banco()
    {
        conta = null;
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
        System.out.println("5) Sair");
        System.out.println("Digite sua opçao desejada : ");
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

