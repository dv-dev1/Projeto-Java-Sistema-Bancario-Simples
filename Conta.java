public class Conta {

    // Atributos básicos da conta bancária
    private int numero;
    private String agencia;
    private double saldo;
    private Cliente titular; // Associação - cada conta tem um titular (cliente)

    // Construtor
    public Conta(int numero, String agencia, Cliente titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = 0.0; // saldo inicial é zero
        this.titular = titular;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    // Métodos para operações bancárias

    // Depositar valor na conta
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println(
                "Depósito de R$ " + valor + " realizado com sucesso!"
            );
        } else {
            System.out.println("Valor para depósito deve ser positivo.");
        }
    }

    // Sacar valor da conta
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println(
                "Saque de R$ " + valor + " realizado com sucesso!"
            );
            return true;
        } else {
            System.out.println(
                "Saldo insuficiente ou valor inválido para saque."
            );
            return false;
        }
    }

    // Exibir informações e saldo da conta
    public void exibirInformacoes() {
        System.out.println("=== Informações da Conta ===");
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
    }
}
