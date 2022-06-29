public class Cliente 
{
    private String nome;
    private String cpf;
    
    Cliente(String nome, String cpf) 
    {
        this.nome = nome;
        this.cpf = cpf;
    }
    public String cliente()
    {
        String t ="\nCliente : " + nome + "\nCPF : " + cpf + " \n";
        return t;
    }
}
