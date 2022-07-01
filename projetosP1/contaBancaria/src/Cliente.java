public class Cliente 
{
    private String nome;
    private String cpf;
    
    Cliente(String nome, String cpf) 
    {
        this.nome = nome;
        this.cpf = cpf;
    }

    /*
     * Novo cliente
     */
    public static Cliente novoCliente(String nome, String cpf)
    {
        return new Cliente(nome, cpf);
    }

    /*
     * Método que retorna uma string com o nome do cliente 
     */
    public String getNome()
    {
        String t ="Cliente : " + nome + " \n";
        return t;
    }

    /*
     * Método que retorna uma string com o cpf do cliente 
     */
    public String getCpf()
    {
        String t ="CPF : " + cpf + " \n";
        return t;
    }
}
