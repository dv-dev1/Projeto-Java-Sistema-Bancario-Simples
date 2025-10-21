import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Conta> contas = new ArrayList<>();
    private static int proximoNumeroConta = 1;

    // Busca uma conta pelo número
    private static Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Sistema Bancário =====");
            System.out.println("1. Criar cliente e conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Consultar saldo e dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Digite um número válido: ");
            }
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o Enter

            switch (opcao) {
                case 1:
                    System.out.println("-- Cadastro de Cliente --");
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    Cliente novoCliente = new Cliente(nome, cpf, endereco);

                    System.out.print("Agência para conta: ");
                    String agencia = sc.nextLine();

                    Conta novaConta = new Conta(
                        proximoNumeroConta,
                        agencia,
                        novoCliente
                    );
                    contas.add(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println(
                        "Número da conta: " + proximoNumeroConta
                    );
                    proximoNumeroConta++;
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    int numContaDeposito = sc.nextInt();
                    sc.nextLine();

                    Conta contaDeposito = buscarConta(numContaDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Valor do depósito: ");
                        double valorDep = sc.nextDouble();
                        sc.nextLine();
                        contaDeposito.depositar(valorDep);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Número da conta: ");
                    int numContaSaque = sc.nextInt();
                    sc.nextLine();

                    Conta contaSaque = buscarConta(numContaSaque);
                    if (contaSaque != null) {
                        System.out.print("Valor do saque: ");
                        double valorSaq = sc.nextDouble();
                        sc.nextLine();
                        contaSaque.sacar(valorSaq);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Número da conta: ");
                    int numContaCons = sc.nextInt();
                    sc.nextLine();

                    Conta contaConsulta = buscarConta(numContaCons);
                    if (contaConsulta != null) {
                        contaConsulta.exibirInformacoes();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
