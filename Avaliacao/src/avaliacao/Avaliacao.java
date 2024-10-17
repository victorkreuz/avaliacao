package avaliacao;

// * @author Victor Kreuz
import java.util.Scanner;

public class Avaliacao {

    Scanner entrada = new Scanner(System.in);
    String produto[] = new String[10];
    boolean[] consertado = new boolean[10];
    boolean entregue[] = new boolean[10];
    double valorConserto[] = new double[10];
    int listaProdutos = 0;
    double faturamento = 0;

    public static void main(String[] args) {
        Avaliacao class01 = new Avaliacao();
        int opcao = 0;
        do {
            opcao = class01.menu();

            switch (opcao) {
                case 0:
                    class01.cadastroProdutos();
                    break;
                case 1:
                    class01.realizacaoConserto();
                    break;
                case 2:
                    class01.realizarDevolucao();
                    break;
                case 3:
                    class01.relatorioProdutos();
                    break;
                case 4:
                    class01.relatorioProdutosNaoConsertados();
                    break;
                case 5:
                    class01.relatorioProdutosConsertadosNaoEntregues();
                    break;
                case 6:
                    class01.faturamentoLoja();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 7);

    }

    public int menu() {
        System.out.println("=== Menu de Opções ===\n"
                + "0. Receber produto do cliente.\n"
                + "1. Fazer conserto.\n"
                + "2. Entregar produto ao cliente.\n"
                + "3. Exibir relatório completo de produtos.\n"
                + "4. Exibir relatório de produtos que ainda não foram consertados.\n"
                + "5. Exibir relatório de produtos consertados, mas não entregues ao cliente.\n"
                + "6. Exibir faturamento total da loja;\n"
                + "7. Sair do Programa(exit).\n"
                + "Escolha uma opção (1-7):");
        int opcaoMenu = entrada.nextInt();
        return opcaoMenu;
    }

    public void cadastroProdutos() {

        System.out.println("cadastrar produto: ");
        produto[listaProdutos] = entrada.next();
        consertado[listaProdutos] = false;
        entregue[listaProdutos] = false;
        listaProdutos++;

    }

    public void realizacaoConserto() {
        System.out.println("Insira o produto a ser consertado: ");
        String produtoConsertado = entrada.next();
        for (int i = 0; i < listaProdutos; i++) {
            if (produtoConsertado.equalsIgnoreCase(produto[i])) {
                System.out.println("Valor do serviço:");
                valorConserto[i] = entrada.nextDouble();
                consertado[i] = true;
                return;
            }
        }
    }

    public void realizarDevolucao() {
        System.out.println("Insira o produto a ser devolvido: ");
        String produtoDevolvido = entrada.next();
        for (int i = 0; i < listaProdutos; i++) {
            if (produtoDevolvido.equalsIgnoreCase(produto[i])) {
                System.out.println("Devolução realizada com sucesso.");
                entregue[i] = true;
                return;
            }
        }
    }

    public void relatorioProdutos() {
        System.out.println("_-_- RELATÓRIO DE PRODUTOS -_-_");
        for (int i = 0; i < listaProdutos; i++) {
            System.out.println(" - " + produto[i]);
        }
    }

    public void relatorioProdutosNaoConsertados() {
        System.out.println("_- RELATÓRIO DE PRODUTOS CONSERTADOS -_");
        for (int i = 0; i < listaProdutos; i++) {
            if (consertado[i] != false) {
                System.out.println("O produto " + produto[i] + " está consertado");
            } else {
                System.out.println("O produto " + produto[i] + " não está consertado");
            }
        }
    }

    public void relatorioProdutosConsertadosNaoEntregues() {
        for (int i = 0; i < listaProdutos; i++) {
            if (entregue[i] != false) {
                System.out.println("O produto " + produto[i] + " foi entregue.");
            } else {
                System.out.println("O produto " + produto[i] + " não foi entregue.");
            }
        }
    }

    public void faturamentoLoja() {
        for (int i = 0; i < listaProdutos; i++) {
            faturamento = valorConserto[i] + faturamento;

        }
        System.out.println("O faturamento total é de: " + faturamento);
    }
}
