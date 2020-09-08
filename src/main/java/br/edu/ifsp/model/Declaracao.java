package br.edu.ifsp.model;

public abstract class Declaracao {
    private double valorPago;
    private double rendaTributavel;
    private int id;

    public final double valorAPagar(){
        return valorImposto() - getValorPago() - gastoDedutivel();
    }

    public double gastoDedutivel(){
        return 0;
    }

    public abstract double valorImposto();

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getRendaTributavel() {
        return rendaTributavel;
    }

    public void setRendaTributavel(double rendaTributavel) {
        this.rendaTributavel = rendaTributavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
