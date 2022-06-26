import java.util.Scanner;
/*
 * Classe Banco, classe para interagir com a classe Conta.
 * 
 * Autor Osvaldo 
 * Versão 25-06-2022
 */

public class Banco {
    private Conta conta = null;
    Scanner entrada = new Scanner(System.in);
    int opcao = 0;     
    public void loop()
    {
        while(opcao != 5)
        {
            opcao = exibirMenu(entrada);
            if(opcao == 1)
            {
                System.out.println("Deseja criar uma conta com saldo e limite com um valor  inicial digite 1, ou digite 2 para criar uma conta com saldo e limite igual a zero : ");
                int n = entrada.nextInt();
                if(n == 1)
                {
                    System.out.println(" digite o saldo depois limite : ");//melhorar este texto
                    double saldo = entrada.nextDouble();
                    double limite = entrada.nextDouble();
                    conta = new Conta(saldo,limite);
                }
                else if(n == 2)
                {
                    conta = new Conta();
                }
                else 
                {
                    System.out.println(" Opção Inválida! ");
                }
            }
            else if(opcao == 2)
            {
                System.out.println("O saldo é de : " + conta.getSaldo());
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

