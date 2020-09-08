package br.edu.ifsp.model;

public class DeclaracaoSimplificada extends Declaracao {

    public DeclaracaoSimplificada(double renda, double valorPago) {
        this.setRendaTributavel(renda);
        this.setValorPago(valorPago);
    }

    @Override
    public double valorImposto() {
        return getRendaTributavel() > 22847.88? (getRendaTributavel()-22847.88) * 0.2 : 0;
    }
}
