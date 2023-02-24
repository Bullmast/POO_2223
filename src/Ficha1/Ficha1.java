package Ficha1;

import java.lang.Math;
import java.time.LocalDateTime;

public class Ficha1 {

    public double celsiusParaFarenheit( double graus ) {
        return graus * 1.8 + 32;
    }

    public int maximoNumeros(int a, int b) {
        return Math.max(a,b);
    }

    public String criaDescricaoConta( String nome, double saldo ) {
        return "A conta de "+nome+" tem "+saldo+"€ de saldo disponivel.";
    /*    StringBuffer sb = new StringBuffer("A conta de ");
        sb.append(nome);
        sb.append(" tem ");
        sb.append(saldo);
        sb.append("€ de saldo disponivel.");

        return sb.toString();
     */
    }

    public double eurosParaLibras(double valor, double taxaConversao) {
        return valor * taxaConversao;
    }

    public String decresceMedia (int a, int b) {

        if (a >= b) {
            return " "+a+" "+b+" "+(a+b)/2;
        } else {
            return " "+b+" "+a+" "+(a+b)/2;
        }

    }

    public long factorial (int num) {

        int res = 1, i;
        for (i=2; i<=num; i++)
            res *= i;
        return res;

    }

    public long tempoGasto() {

        LocalDateTime current = LocalDateTime.now();
        //System.out.println(current.toString());
        long calculo = factorial(5000);
        LocalDateTime after = LocalDateTime.now();
        //System.out.println(after.toString());
        return after.getNano() - current.getNano();

    }

}
