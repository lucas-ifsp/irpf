package br.edu.ifsp.model;

public abstract class GastoDedutivel {

    private String descricao;
    private double valor;
    private String cnpj;
    private int id;

    public GastoDedutivel(String descricao, double valor, String cnpj, int id) {
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return getClass().getSimpleName();
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
