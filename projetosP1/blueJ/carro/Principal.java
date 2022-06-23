import java.util.Scanner;


/**
 * Classe principal com menus para interagir com carro.
 * 
 * @author (Osvaldo) 
 * @version v2.0
 */
public class Principal
{
    public static void main(String[] args)
    {   
        Carro carro = null;
        Scanner entrada = new Scanner(System.in);
        
        int opcao = 0;
        while(opcao != 5)
        {
            opcao = exibirMenu(entrada);
            if(opcao == 1)
            {
                System.out.println("Digite o nome o carro : ");
                String nome = entrada.nextLine();
                carro = new Carro(nome);
            }
            
            else if(opcao == 2)
            {
                System.out.println("Carro de nome : " + carro.getNome() + " e velocidade " + carro.getVelocidade());
            }
            
            else if(opcao == 3)
            {
                System.out.println("Quanto voce quer acelerar : ");
                int quanto = Integer.parseInt(entrada.nextLine());
                carro.acelerar(quanto);
                System.out.println("Nova velocidade e " + carro.getVelocidade());
            }
            
            else if(opcao == 4)
            {
                System.out.println("Quanto voce quer reduzir : ");
                int quanto = Integer.parseInt(entrada.nextLine());
                if(carro.reduzir(quanto))
                {
                    System.out.println("Nova velocidade e " + carro.getVelocidade());
                }
                else
                {
                    System.out.println("Reduzida maior ou igual a velocidade do carro, carro parado! ");
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
        System.out.println("1) Criar o carro ");
        System.out.println("2) Exibir os dados do carrro ");
        System.out.println("3) Acelerar o carro ");
        System.out.println("4) Reduzir a velocidade do carro ");
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

