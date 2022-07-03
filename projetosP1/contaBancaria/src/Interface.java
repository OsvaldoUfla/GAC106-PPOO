import java.util.Scanner;
/*
 * Classe Interface, classe para interagir com o usúario.
 * 
 * Autor Osvaldo 
 * Versão 25-06-2022
 */
public class Interface {

    Scanner entrada = new Scanner(System.in);

    /*
     * Exibe o menu de escolha
     */
    public int exibirMenu()
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

    /*
    * Exibe mensagem de opção invalida
    */
    public void invalida()
    {
        System.out.println("\nOpçao invalida! ");
    }

     /*
    * Exibe mensagem de saldo e limite insuficiente
    */
    public void semSaldo()
    {
        System.out.println("\nSaldo e limite insuficiente! ");
    }

    /*
    * Exibe mensagem de Operação realizada com sucesso
    */
    public void ok()
    {
        System.out.println("\nOperação realizada com sucesso! ");
    }


    /*
    * Exibe despedida
    */
    public void despedida()
    {
        System.out.println("Ate mais! ");
    }

    /**
    * Aguarda o usuario digitar o enter pra exibir o menu de novo.
    */
    public void aguardarEnter()
    {
        System.out.println("Digite ENTER para continuar ");
        System.out.println("");
        entrada.nextLine();
    }

    /*
     * Pede o nome e o cpf do cliente e retorna em um vetor de String
     */
    public String[] nomeCPF()
    {
        String[] nomeCpf = new String[2];
        System.out.println(" Nome do Cliente : ");
        nomeCpf[0] = entrada.nextLine();
        System.out.println(" Cpf do cliente : ");
        nomeCpf[1] = entrada.nextLine();
        
        return nomeCpf;
    }

    /*
     * Pede o saldo e limite para o usúario 
     * e retorna em um vetor de duas posições
     * saldo e limite respectivamente nas posições 0, 1
     * caso posição 0 com valor -1 conta inicia com saldo zerado;
     */
    public Double[] saldoLimite()
    {
        Double[] saldoLimite = new Double[2];
        System.out.println("Digite o Saldo : (Conta sem saldo digite não)");
        boolean n = (entrada.hasNextDouble());
        if( n )
        {
            saldoLimite[0] = entrada.nextDouble();
        }
        else
        {
            saldoLimite[0] = -1.0;
        }
        System.out.println(" Limite : ");
        saldoLimite[1] = entrada.nextDouble();

        return saldoLimite;
    }

    /*
     * Exibe o numero da conta 
     */
    public void exibeNroConta(int n)
    {
        System.out.println("Conta numero " + n + " criada com socesso ");
    }
     
    /*
     * Exibe String passado por parametro
     */
    public void exibeInformacao(String t)
    {
        System.out.println(t);
    }

    /*
     * Pede o numero da conta para o cliente e retorna um int
     */
    public int nroConta()
    {
        System.out.println("\nInsira o numero da conta : ");
        return  Integer.parseInt(entrada.nextLine());
    }

    /*
     * Pede o um valor para cliente e retorna um double
     */
    public Double qualValor()
    {
        System.out.println("\niQual o valor : ");
        return  entrada.nextDouble();
    }

    public void exibeTransferencia()
    {
        System.out.println("\nValor a ser transferido \nConta de origem \nConta de destino \n");
    }
}



