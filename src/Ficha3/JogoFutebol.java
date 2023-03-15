package Ficha3;

public class JogoFutebol    {

    private enum Jogo {
        por_iniciar,
        a_decorrer,
        terminado

    }
    private Jogo estado;
    private int golosVisitante;
    private int golosVisitado;

    public JogoFutebol() {
        this.estado = Jogo.por_iniciar;
        this.golosVisitado = 0;
        this.golosVisitante = 0;
    }

    public JogoFutebol( JogoFutebol teste ) {
        this.estado = teste.getEstado();
        this.golosVisitante = teste.getGolosVisitante();
        this.golosVisitado = teste.getGolosVisitado();
    }

    public Jogo getEstado() {
        return estado;
    }

    public int getGolosVisitado() {
        return golosVisitado;
    }

    public int getGolosVisitante() {
        return golosVisitante;
    }

    public void setEstado(Jogo estado) {
        this.estado = estado;
    }

    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }

    public void setGolosVisitado(int golosVisitado) {
        this.golosVisitado = golosVisitado;
    }

    public void startGame() {
        if (this.getEstado() == Jogo.por_iniciar) this.estado = Jogo.a_decorrer;
    }

    public void endGame() {
        if (this.getEstado() == Jogo.a_decorrer) this.estado = Jogo.terminado;
    }

    public void goloVisitado() {
        if (this.estado == Jogo.a_decorrer) this.setGolosVisitado(this.golosVisitado+1);
    }

    public void goloVisitante() {
        if (this.estado == Jogo.a_decorrer) this.setGolosVisitante(this.golosVisitante+1);
    }

    public String resultadoActual() {
        if (this.estado == Jogo.por_iniciar) {
            return "  --- Jogo Por Iniciar  ---  \n";
        } else {
            StringBuilder sc = new StringBuilder();
            sc.append("  ---  ESTADO : " + this.estado + "  ---\n");
            sc.append("\n");
            sc.append("  + Golos Casa -> " + this.golosVisitado);
            sc.append("\n");
            sc.append("  + Golos Fora -> " + this.golosVisitante);
            sc.append("\n");
            sc.append("  ---              ---\n");
            return sc.toString();
        }
    }

    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this.getClass() != o.getClass() ) )
            return false ;
        JogoFutebol p = ( JogoFutebol ) o ;
        return ( this.estado == p.getEstado() && this.golosVisitante == p.getGolosVisitante()
                && this.golosVisitado == p.getGolosVisitado()
        );
    }

    public String toString() {
        StringBuilder sc = new StringBuilder();
        sc.append("  ---  ESTADO : " + this.estado + "  ---\n");
        sc.append("\n");
        sc.append("  + Golos Casa -> " + this.golosVisitado);
        sc.append("\n");
        sc.append("  + Golos Fora -> " + this.golosVisitante);
        sc.append("\n");
        sc.append("  ---              ---\n");
        return sc.toString();
    }

    public JogoFutebol clone() {
        return new JogoFutebol(this);
    }
}
