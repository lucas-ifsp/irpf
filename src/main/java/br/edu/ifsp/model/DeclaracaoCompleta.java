package br.edu.ifsp.model;

import java.util.ArrayList;
import java.util.List;

public class DeclaracaoCompleta extends Declaracao {

    private List<GastoDedutivel> dedutiveis = new ArrayList<>();

    public DeclaracaoCompleta(double renda, double valorPago) {
        this.setRendaTributavel(renda);
        this.setValorPago(valorPago);
    }

    @Override
    public double gastoDedutivel() {
        return 0;
    }

    @Override
    public double valorImposto() {
        double cotaImposto = getRendaTributavel();
        double aPagar = 0;

        if(cotaImposto < 22847.88)
            return 0;
        else{
            if(cotaImposto > 55976.16){
                aPagar += (cotaImposto - 55976.16) * 0.275;
                cotaImposto = 55976.16;
            }
            if(cotaImposto > 45012.72){
                aPagar += (cotaImposto - 45012.72) * 0.225;
                cotaImposto = 45012.72;
            }
            if(cotaImposto > 33919.92){
                aPagar += (cotaImposto - 33919.92) * 0.15;
                cotaImposto = 33919.92;
            }
            if(cotaImposto > 22847.88){
                aPagar += (cotaImposto - 22847.88) * 0.075;
            }
            return aPagar;
        }
    }

    public void addGasto(GastoDedutivel gastoDedutivel){
        dedutiveis.add(gastoDedutivel);
    }
    public void rmGasto(GastoDedutivel gastoDedutivel){
        dedutiveis.remove(gastoDedutivel);
    }
}
