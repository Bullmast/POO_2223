package Ficha3;

public class LinhaDeEncomenda {

    //VISUAL PARADIGM ONLINE
    private String referencia;
    private String descrição;
    private double preçoBase;
    private int quantidadeEnc;
    private static double imposto;
    private double desconto;

    public String getReferencia() {
        return referencia;
    }

    public String getDescrição() {
        return descrição;
    }

    public double getPreçoBase() {
        return preçoBase;
    }

    public int getQuantidadeEnc() {
        return quantidadeEnc;
    }

    public double getDesconto() {
        return desconto;
    }

    public static double getImposto() {
        return imposto;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setPreçoBase(double preçoBase) {
        this.preçoBase = preçoBase;
    }

    public static void setImposto(double imposto) {
        LinhaDeEncomenda.imposto = imposto;
    }

    public void setQuantidadeEnc(int quantidadeEnc) {
        this.quantidadeEnc = quantidadeEnc;
    }
}
