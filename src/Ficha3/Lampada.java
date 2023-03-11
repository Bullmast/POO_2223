package Ficha3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Lampada {

    private enum Estado {
        OFF,
        ON,
        ECO
    }
    private Estado state;
    private double consumo;
    private double potencia;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataReset;

    public Lampada() {
        this.state = Estado.OFF;
        this.consumo = 0;
        this.potencia = 1.75;
        this.dataCriacao = LocalDateTime.now();
        this.dataReset = LocalDateTime.now();
    }

    public Lampada ( Lampada teste ) {
        this.state = teste.getState();
        this.consumo = teste.getConsumo();
        this.potencia = teste.getPotencia();
        this.dataCriacao = teste.getDataCriacao();
        this.dataReset = teste.getDataReset();
    }

    public Estado getState() {
        return state;
    }

    public double getPotencia() {
        return potencia;
    }

    public double getConsumo() {
        return consumo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataReset() {
        return dataReset;
    }

    public void setState(Estado estado) {
        this.consumo += this.periodoConsumo();
        this.state = estado;
        this.dataReset = LocalDateTime.now();
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataReset(LocalDateTime dataReset) {
        this.dataReset = dataReset;
    }

    public void lampON() {
        this.setState(Estado.ON);
    }

    public void lampOFF() {
        this.setState(Estado.OFF);
    }

    public void lampECO() {
        this.setState(Estado.ECO);
    }

    public double totalConsumo() {
        return this.consumo + this.periodoConsumo();
    }

    public double periodoConsumo() {
        double tmp = 0;
        switch (this.state) {
            case OFF -> {
                tmp = 0;
            }
            case ON -> {
                tmp = 1;
            }
            case ECO -> {
                tmp = 0.5;
            }
        }
        return tmp * potencia * this.dataReset.until(LocalDateTime.now(), ChronoUnit.MILLIS);
    }

    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this.getClass() != o.getClass() ) )
            return false ;
        Lampada p = ( Lampada ) o ;
        return ( this.state == p.getState() && this.consumo == p.getConsumo()
                && this.dataReset.isEqual(p.getDataReset())
                && this.dataCriacao.isEqual(p.getDataCriacao())
                && this.potencia == p.getPotencia()
        );
    }

    public String toString() {
        StringBuilder sc = new StringBuilder();
        sc.append(" - Lampada :\n"); sc.append("   + Estado: "+this.state); sc.append("\n");
        sc.append("   + Consumo até ao Último Reset: "+this.consumo); sc.append("\n");
        sc.append("   + Data de Criação: "+this.dataCriacao.toString()); sc.append("\n");
        sc.append("   + Data do Último Reset: "+this.dataReset.toString()); sc.append("\n");
        sc.append("   + Potência: "+this.potencia); sc.append("\n");
        return sc.toString();
    }

    public Lampada clone() {
        return new Lampada(this);
    }
}
