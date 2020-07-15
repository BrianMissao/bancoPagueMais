import domiminio.CaixaEletronico;
import domiminio.ContaCorrente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class realizaInteracaoComOUsuario {
    private static Scanner scanner = new Scanner(System.in);
    private static ContaCorrente contaCorrente;
    private static CaixaEletronico caixaEletronico;

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao banco Pague mais!\nO seu dinheiro é muito importante para nós.");
        int numeroDaConta = Integer.parseInt(obterDados("Digite o número da conta:"));
        String nomeDoTitular = obterDados("Digite o nome do titular:");
        String respostaDoUsuario = obterDados("Deseja realizar um depósito agora?");
        String valorADepositar;
        if (respostaDoUsuario.equals("s")) {
            valorADepositar = obterDados("Qual o valor do depósito?");
            contaCorrente = new ContaCorrente(nomeDoTitular, numeroDaConta, new BigDecimal(valorADepositar).setScale(2, RoundingMode.HALF_EVEN));
        } else {
            contaCorrente = new ContaCorrente(nomeDoTitular, numeroDaConta);
        }
        caixaEletronico = new CaixaEletronico(contaCorrente);
        interagirComCaixaEletronico();
        System.out.println("Lembre-se: O dinheiro não trás felicidade, nos dê o seu e seja feliz.\nO banco Pague mais agradece a sua preferência!");
    }

    private static void interagirComCaixaEletronico() {
        String valorQueOUsuarioDesejaSacarOuDepositar;
        imprimirDadosDaConta();
        valorQueOUsuarioDesejaSacarOuDepositar = obterDados("Digite o valor que deseja depositar (para nossa alegria):");
        caixaEletronico.depositarDinheiro(new BigDecimal(valorQueOUsuarioDesejaSacarOuDepositar).setScale(2, RoundingMode.HALF_EVEN));
        imprimirDadosDaConta();
        valorQueOUsuarioDesejaSacarOuDepositar = obterDados("Digite o valor que deseja sacar:");
        caixaEletronico.sacarDinheiro(new BigDecimal(valorQueOUsuarioDesejaSacarOuDepositar).setScale(2, RoundingMode.HALF_EVEN));
        imprimirDadosDaConta();
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }

    private static void imprimirDadosDaConta() {
        System.out.println("*Dados da conta\nNome do titular: " + contaCorrente.getNomeTitular() + "\nNúmero da conta: " + contaCorrente.getNumeroDaConta() + "\nSaldo da conta: " + contaCorrente.getSaldo());
    }
}
