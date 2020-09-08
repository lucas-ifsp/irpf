package br.edu.ifsp.model;

public class GastoEducacao extends GastoDedutivel {

    private String nomeInstituicao;
    public static final double deducaoMaxEducacao = 1500;

    public GastoEducacao(String descricao, double valor, String cnpj, String nomeInstituicao, int id) {
        super(descricao, valor, cnpj, id);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
}
