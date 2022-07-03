public class Cliente 
{
    private String nome;
    private String cpf;
    

    /*
     * Construtor
     */
    Cliente(String nome, String cpf) 
    {
        this.nome = nome;
        this.cpf = cpf;
    }

    /*
     * Método que retorna uma string com o nome do cliente 
     */
    public String getNome()
    {
        return nome;
    }

    /*
     * Método que retorna uma string com o cpf do cliente 
     */
    public String getCpf()
    {
        return cpf;
    }
}
