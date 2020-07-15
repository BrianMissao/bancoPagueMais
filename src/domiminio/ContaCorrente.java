package domiminio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente {
    private String nomeTitular;
    private int numeroDaConta;
    private BigDecimal saldo;

    public ContaCorrente(String nomeTitular, int numeroDaConta, BigDecimal saldo) {
        this.nomeTitular = nomeTitular;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo.setScale(2, RoundingMode.HALF_EVEN);
    }

    public ContaCorrente(String nomeTitular, int numeroDaConta) {
        this.nomeTitular = nomeTitular;
        this.numeroDaConta = numeroDaConta;
        this.saldo = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    void atualizarSaldo(BigDecimal novoSaldo) {
        this.saldo = novoSaldo;
    }

    public void alterarNomeDoTitular(String novoNomeDoTitular) {
        this.nomeTitular = novoNomeDoTitular;
    }
}
