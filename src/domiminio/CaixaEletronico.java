package domiminio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CaixaEletronico {
    private ContaCorrente contaCorrente;
    private final BigDecimal taxa = new BigDecimal("5.00").setScale(2, RoundingMode.HALF_EVEN);

    public CaixaEletronico(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public void sacarDinheiro(BigDecimal valorASacar) {
        BigDecimal saldoAnteriorAoSaque = contaCorrente.getSaldo();
        BigDecimal novoSaldo = saldoAnteriorAoSaque.subtract(valorASacar);
        novoSaldo = aplicarTaxaDeSaqueSobreO(novoSaldo);
        contaCorrente.atualizarSaldo(novoSaldo);
        System.out.println("Operação realizada com sucesso!");
    }

    private BigDecimal aplicarTaxaDeSaqueSobreO(BigDecimal saldo) {
        return saldo.subtract(taxa);
    }

    public void depositarDinheiro(BigDecimal valorADepositar) {
        BigDecimal novoSaldo = contaCorrente.getSaldo().add(valorADepositar);
        contaCorrente.atualizarSaldo(novoSaldo);
        System.out.println("Operação realizada com sucesso!");
    }
}
