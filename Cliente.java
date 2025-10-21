public class Cliente {

    // Atributos (características) do Cliente
    private String nome;
    private String cpf;
    private String endereco;

    // Construtor: chamado para criar um novo Cliente (define como um cliente nasce)
    public Cliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Métodos "getters": permitem acessar os atributos (boa prática de encapsulamento)
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    // Método "setter": permite alterar o endereço depois que o cliente já foi criado
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Exemplo de método para exibir informações do cliente
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
    }
}
