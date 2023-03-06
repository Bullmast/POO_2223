package Ficha3;

public class Circulo {

    private double x;
    private double y;
    private double raio;

    public Circulo() {
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Circulo( Circulo teste ) {
        this.x = teste.getX();
        this.y = teste.getY();
        this.raio = teste.getRaio();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRaio() {
        return raio;
    }

    public void setX(double xy) {
        this.x = xy;
    }

    public void setY(double zy) {
        this.y = zy;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void alteraCentro (double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public double calculaArea() {
        return Math.PI * Math.pow(this.raio,2);
    }

    public double calculaPerimetro() {
        return 2 * Math.PI * this.raio;
    }

    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this.getClass() != o.getClass() ) )
            return false ;
        Circulo p = ( Circulo ) o ;
        return ( this.x == p.getX() && this.y == p.getY() && this.raio ==p.getRaio() ) ;
    }

    public String toString() {
        return "Circulo :\n  Centro : X="+this.x+"; Y="+this.y+";\n  Raio : "+this.raio;
    }

    public Circulo clone() {
        return new Circulo(this);
    }
}
