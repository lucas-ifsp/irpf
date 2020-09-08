package br.edu.ifsp.model;

public class GastoSaude extends GastoDedutivel {

    private String regConselho;
    public static final double deducaoMaxSaude = 2000;

    public GastoSaude(String descricao, double valor, String cnpj, String regConselho, int id) {
        super(descricao, valor, cnpj, id);
        this.regConselho = regConselho;
    }

    public String getRegConselho() {
        return regConselho;
    }

    public void setRegConselho(String regConselho) {
        this.regConselho = regConselho;
    }
}
