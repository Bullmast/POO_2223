package Ficha3;

public class LinhaDeEncomenda {

    //VISUAL PARADIGM ONLINE
    private String referencia;
    private String descrição;
    private double preçoBase;
    private int quantidadeEnc;
    private static double imposto = 0.25;
    private double desconto;

    public LinhaDeEncomenda() {
        this.referencia = "";
        this.descrição = "";
        this.preçoBase = 0;
        this.quantidadeEnc = 0;
        this.desconto = 0.13;
    }

    public LinhaDeEncomenda( LinhaDeEncomenda teste ) {
        this.referencia = teste.getReferencia();
        this.descrição = teste.getDescrição();
        this.preçoBase = teste.getPreçoBase();
        this.quantidadeEnc = teste.getQuantidadeEnc();
        this.desconto = teste.getDesconto();
    }

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

    public double calculaValorLinhaEnc() {
        return this.preçoBase * this.quantidadeEnc * (1-this.desconto) * (1+this.getImposto());
    }

    public double calculaValorDesconto() {
        return this.preçoBase * this.quantidadeEnc * (this.desconto);
    }

    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this.getClass() != o.getClass() ) )
            return false ;
        LinhaDeEncomenda p = ( LinhaDeEncomenda ) o ;
        return ( this.referencia.compareTo(p.getReferencia()) == 0
                && this.descrição.compareTo(p.getDescrição()) == 0
                && this.quantidadeEnc == p.getQuantidadeEnc()
                && this.preçoBase == p.getPreçoBase()
                && this.desconto == p.getDesconto()
        );
    }

    public String toString() {
        StringBuilder sc = new StringBuilder();
        sc.append("  ---  Linha De Encomenda :  ---\n");
        sc.append("\n");
        sc.append("  + Referência -> " + this.referencia);
        sc.append("\n");
        sc.append("  + Descrição -> " + this.descrição);
        sc.append("\n");
        sc.append("  + Desconto -> " + this.desconto);
        sc.append("\n");
        sc.append("  + Quantidade Encomendada -> " + this.quantidadeEnc);
        sc.append("\n");
        sc.append("  + Preço Base -> " + this.preçoBase);
        sc.append("\n");
        sc.append("  + Imposto -> " + this.imposto);
        sc.append("\n");
        sc.append("  ---                        ---\n");
        return sc.toString();
    }

    public LinhaDeEncomenda clone() {
        return new LinhaDeEncomenda(this);
    }
}
