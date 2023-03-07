package Ficha3;


import java.util.Arrays;

public class Telemóvel {

    private String marca;
    private String modelo;
    private int[] display;
    private int espaçoMsgs;
    private int espaçoFotoApp;
    private int espaçoFotos;
    private int espaçoApps;
    private int espaçoTotal;
    private int numApps;
    private int numFotos;
    private String[] nomeApps;

    public Telemóvel() {
         this.marca = "";
         this.modelo = "";
         this.display = new int[2];
         this.espaçoMsgs = 0;
         this.espaçoFotoApp = 0;
         this.espaçoFotos = 0;
         this.espaçoApps = 0;
         this.espaçoTotal = 0;
         this.numApps = 0;
         this.numFotos = 0;
         String[] tmp = {"",""};
         this.nomeApps = tmp;
    }

    public Telemóvel( String marc, String model, int[] tamanho, int emsgs, int efotoapp,
                      int efotos, int eapps, int esptotal, int napps, int nfotos,
                      String[] nomeapps ) {

        this.marca = marc;
        this.modelo = model;
        this.display = Arrays.copyOf(tamanho,2);
        this.espaçoMsgs = emsgs;
        this.espaçoFotoApp = efotoapp;
        this.espaçoFotos = efotos;
        this.espaçoApps = eapps;
        this.espaçoTotal = esptotal;
        this.numApps = napps;
        this.numFotos = nfotos;
        this.nomeApps = Arrays.copyOf(nomeapps,nomeapps.length);

    }

    public Telemóvel( Telemóvel teste ) {
        this.marca = teste.getMarca();
        this.modelo = teste.getModelo();
        this.display = teste.getDisplay();
        this.espaçoMsgs = teste.getEspaçoMsgs();
        this.espaçoFotoApp = teste.getEspaçoFotoApp();
        this.espaçoFotos = teste.getEspaçoFotos();
        this.espaçoApps = teste.getEspaçoApps();
        this.espaçoTotal = teste.getEspaçoTotal();
        this.numApps = teste.getNumApps();
        this.numFotos = teste.getNumFotos();
        this.nomeApps = teste.getNomeApps();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int[] getDisplay() {
        return Arrays.copyOf(this.display,this.display.length);
    }

    public int getEspaçoMsgs() {
        return espaçoMsgs;
    }

    public int getEspaçoFotoApp() {
        return espaçoFotoApp;
    }

    public int getEspaçoFotos() {
        return espaçoFotos;
    }

    public int getEspaçoApps() {
        return espaçoApps;
    }

    public int getEspaçoTotal() {
        return espaçoTotal;
    }

    public int getNumFotos() {
        return numFotos;
    }

    public int getNumApps() {
        return numApps;
    }

    public String[] getNomeApps() {
        return Arrays.copyOf(this.nomeApps, this.nomeApps.length);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDisplay(int[] display) {
        this.display = Arrays.copyOf(display,2);
    }

    public void setEspaçoMsgs(int espaçoMsgs) {
        this.espaçoMsgs = espaçoMsgs;
    }

    public void setEspaçoFotoApp(int espaçoFotoApp) {
        this.espaçoFotoApp = espaçoFotoApp;
    }

    public void setEspaçoFotos(int espaçoFotos) {
        this.espaçoFotos = espaçoFotos;
    }

    public void setEspaçoApps(int espaçoApps) {
        this.espaçoApps = espaçoApps;
    }

    public void setEspaçoTotal(int espaçoTotal) {
        this.espaçoTotal = espaçoTotal;
    }

    public void setNumApps(int numApps) {
        this.numApps = numApps;
    }

    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }

    public void setNomeApps(String[] nomeApps) {
        this.nomeApps = Arrays.copyOf(nomeApps,nomeApps.length);
    }


    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this.getClass() != o.getClass() ) )
            return false ;
        Telemóvel p = ( Telemóvel ) o ;
        return ( this.marca == p.getMarca() && this.modelo == p.getModelo()
                && this.espaçoMsgs == p.getEspaçoMsgs() && this.espaçoFotos == p.getEspaçoFotos()
                && this.espaçoApps == p.getEspaçoApps() && this.espaçoFotoApp == p.getEspaçoFotoApp()
                && this.espaçoTotal == p.getEspaçoTotal() && this.numApps == p.getNumApps()
                && this.numFotos == p.getNumFotos() && Arrays.equals(this.display,p.getDisplay())
                && Arrays.deepEquals(this.nomeApps,p.getNomeApps())
        );
    }

    public String toString() {
        return "Telemóvel :\n   + Marca : "+this.getMarca()+"\n   + Modelo : "+this.getModelo()+"\n   + Display : "
                +Arrays.toString(this.getDisplay())+"\n   + Espaço para Msgs : "+this.getEspaçoMsgs()+"\n   + Espaço para Fotos : "
                +this.getEspaçoFotos()+"\n   + Espaço para Apps : "+this.getEspaçoApps()
                +"\n   + Espaço para Fotos e Apps : "+this.getEspaçoFotoApp()+"\n   + Espaço Total : "+this.getEspaçoTotal()+
                "\n   + Número de Fotos : "+this.getNumFotos()+"\n   + Número de Apps Instaladas : "+this.getNumApps()+
                "\n   + Nome das Apps Instaladas : "+Arrays.toString(this.getNomeApps());
    }

    public Telemóvel clone() {
        return new Telemóvel(this);
    }

}
