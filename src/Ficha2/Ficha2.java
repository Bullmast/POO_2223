package Ficha2;
import java.time.LocalDate;
import java.util.Arrays;

public class Ficha2 {

    private LocalDate[] datas;
    private int[] arrInt;
    private int[] arrInt2;
    private String[] arrString;
    private int[][] notaAluno;
    private int[] key;

    // Construtores da Classe Ficha 2
    public Ficha2 () {
        this.datas = new LocalDate[0];
        this.arrInt = new int[0];
        this.arrInt2 = new int[0];
        this.arrString = new String[0];
        this.notaAluno = new int[5][5];
        this.key = new int[7];
        int tmp = 50;
        for(int i = 0; i < 7; i++) {
            if (i == 5) { tmp = 9; }
            key[i] = (int) (Math.random() * tmp) + 1;
        }
    }


    // Set das Variáveis de Instância
    public void setArrInt(int[] tmp) {
        this.arrInt = Arrays.copyOf(tmp, tmp.length);
    }

    public void setArrInt2(int[] tmp) {
        this.arrInt2 = Arrays.copyOf(tmp, tmp.length);
    }

    public void setArrString(String[] tmp) {
        this.arrString = Arrays.copyOf(tmp, tmp.length);
    }

    public void setNotaAluno(int[][] giv) {
        int[][] tmp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            tmp[i] = Arrays.copyOf(giv[i],5);
        }
        this.notaAluno = tmp;
    }

    public void setKey(int[] tries) {
        for(int i = 0; i < 7; i++) {
            this.key[i] = tries[i];
        }
    }



    // ****** Inicio dos Exercicios ******

    public int lerMinimo () {
        Arrays.sort(this.arrInt);
        return arrInt[0];
    }

    public int[] arrEntreIndice ( int ind1, int ind2) {
        return Arrays.copyOfRange( arrInt, ind1, ind2);
    }

    public int[] comumEntreArr () {
        int tmp[] = new int[Integer.min(arrInt.length,arrInt2.length)];
        Arrays.fill(tmp,-1);
        int count = 0;
        for (int elem: arrInt) {
            if ( Arrays.binarySearch( arrInt2, elem) >= 0) {
                tmp[count] = elem;
                count++;
            }
        }
        return tmp;
    }

/*
    public int[] comumEntreArr (int[] arr1, int[] arr2) {

        int tmp[] = new int[Integer.min(arr1.length,arr2.length)];
        Arrays.fill(tmp,-1);
        int count = 0;
        for (int elem: arr1) {
            if ( Arrays.binarySearch( arr2, elem) >= 0) {
                tmp[count] = elem;
                count++;
            }
        }
        return tmp;
    }
*/



    // ******** .2. Exercicios Sobre Acessos ao Array de Datas .2. ********

    public void insereData ( LocalDate data) {

        LocalDate[] tmp = new LocalDate[this.datas.length + 1];
        tmp = Arrays.copyOf(this.datas, tmp.length);
        tmp[this.datas.length] = data;
        this.datas = tmp;

    }

    public LocalDate dataMaisProxima(LocalDate data) {

        LocalDate current = data;
        int bestDay = Integer.MAX_VALUE;
        int dayGiven = data.getDayOfYear();
        int yearGiven = data.getDayOfYear();
        int difGiven = dayGiven + yearGiven;

        for ( LocalDate date : this.datas) {

            int bestTmp = Integer.MAX_VALUE;
            int yearArray = date.getYear();
            int dayArray = date.getDayOfYear();
            bestTmp = yearArray + dayArray;
            if (Math.abs(bestTmp - difGiven) < Math.abs(bestDay - difGiven)) {
                bestDay = bestTmp;
                current = date;
            }

        }

        return current;
    }

    public String toString() {

        String tmp = "";
        for (LocalDate elem: this.datas) {
            tmp = tmp+" "+elem.toString();
        }

        return tmp;
    }



    // ******** .4. Exercicios Sobre Operações com Strings .4. ********

    public String[] stringSemRep () {

        int[] cnt = new int[this.arrString.length-1];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        int cntT = 0;

        for (int i = 0; i < this.arrString.length-1 ; i++) {
            Arrays.sort(cnt);
            int tmp = Arrays.binarySearch( cnt, i);
            if ( tmp < 0 ) {
                for (int j = i+1; j < this.arrString.length ; j++) {
                    if (( this.arrString[i].compareTo(this.arrString[j]) == 0 ) && ( Arrays.binarySearch( cnt, j) < 0 ) ) {
                        cnt[cntT] = j;
                        cntT++;
                    }
                }
            }
        }

        int resCnt = 0;
        String[] result = new String[this.arrString.length - cntT];
        for (int i = 0; i < this.arrString.length; i++) {
            if ( Arrays.binarySearch(cnt, i) < 0 ) {
                result[resCnt] = this.arrString[i];
                resCnt++;
            }
        }

        return result;
    }

    public String maiorString() {

        int max = 0;
        String res = "";
        for ( String elem : this.arrString ) {
            if (elem.length() > max) {
                max = elem.length();
                res = elem;
            }
        }

        return res;
    }

    public String[] stringQueRep () {

        int[] cnt = new int[this.arrString.length-1];
        int[] cntR = new int[this.arrString.length-1];
        int cntrT = 0;
        Arrays.fill(cnt, Integer.MAX_VALUE);
        Arrays.fill(cntR, Integer.MAX_VALUE);
        int cntT = 0;
        int pick;

        for (int i = 0; i < this.arrString.length-1 ; i++) {
            Arrays.sort(cnt);
            Arrays.sort(cntR);
            pick = 0;
            int tmp = Arrays.binarySearch( cnt, i);
            if ( tmp < 0 ) {
                for (int j = i+1; j < this.arrString.length ; j++) {
                    if (( this.arrString[i].compareTo(this.arrString[j]) == 0 ) && ( Arrays.binarySearch( cnt, j) < 0 ) ) {
                        if (pick == 0) {
                            pick = 1;
                            cntR[cntrT] = i;
                            cntrT++;
                        }
                        cnt[cntT] = j;
                        cntT++;
                    }
                }
            }
        }

        int resCnt = 0;
        String[] result = new String[cntrT];
        for(;resCnt != cntrT; resCnt++) {
            result[resCnt] = this.arrString[cntR[resCnt]];
        }

        return result;
    }

    public int qtRepString ( String teste ) {

        int cnt = 0;
        for ( String elem : this.arrString ) {
            if (elem.compareTo(teste) == 0){
                cnt++;
            }
        }

        return cnt;
    }



    // ******** .5. Exercicios Sobre as Notas dos Alunos .5. ********

    public int notasCadeira (int ind) {

        int med = 0;
        for (int[] aluno : this.notaAluno) {
            med += aluno[ind];
        }
        return med;

    }

    public double mediaAluno (int ind) {

        int med = 0;
        for (int nota : this.notaAluno[ind]) {
            med += nota;
        }

        return med/5;
    }

    public double mediaCadeira (int ind) {

        int med = 0;
        for (int[] aluno : this.notaAluno) {
            med += aluno[ind];
        }
        return med/5;

    }

    public int notaMaisAlta() {
        int notaMaisAlta = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(this.notaAluno[i][j] > notaMaisAlta) {
                    notaMaisAlta = this.notaAluno[i][j];
                }
            }
        }
        return notaMaisAlta;
    }

    public int notaMaisBaixa() {
        int notaMaisBaixa = Integer.MAX_VALUE;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(this.notaAluno[i][j] < notaMaisBaixa ) {
                    notaMaisBaixa = this.notaAluno[i][j];
                }
            }
        }
        return notaMaisBaixa;
    }

    public int[] notasAcima(int lim) {
        int[] res = new int[25];
        int cnt = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(this.notaAluno[i][j] > lim ) {
                    res[cnt] = this.notaAluno[i][j];
                    cnt++;
                }
            }
        }
        res = Arrays.copyOf(res, cnt);

        return res;
    }

    public String pautaToString () {
        String res = " * * * * * Pauta * * * * * ";
        for (int i = 0; i < 5; i++) {
            res = res + "\n  Aluno " + i + " :";
            for (int j = 0; j < 5; j++) {
                res += " " + this.notaAluno[i][j];
            }
        }
        res += "\n * * * * *       * * * * * \n\n";

        return res;
    }

    public int cadeiraMaisAlta () {
        double res = 0;
        int ind = 0;
        for (int i = 0; i < 5; i++) {
            double tmp = this.mediaCadeira(i);
            if (res < tmp) {
                res = tmp;
                ind = i;
            }
        }
        return ind;
    }

    // ******** .6. Exercicios Sobre Matrizes .6. ********

    public String matrizToString (int[][] matriz) {
        return Arrays.deepToString(matriz);
    }

    public int[][] somaMatriz (int[][] matriz1, int[][] matriz2) {
        int[][] tmp = new int[matriz1.length][matriz2.length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                tmp[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return tmp;
    }

    public boolean equalsMatriz (int[][] matriz1, int[][] matriz2) {
        return Arrays.deepEquals(matriz1,matriz2);
    }

    public int[][] matrizOposta (int[][] matriz) {
        int[][] tmp = new int[matriz.length][matriz[0].length];

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[0].length; j++) {
                tmp[i][j] = -matriz[i][j];
            }
        }

        return tmp;
    }



    // ******** .7. EuroMilhões .7. ********
    public String adivinhaEuro (int[] guess) {
        String res = " - * - * - * - EuroMilhoes - * - * - * - \n\n  _ . _ Chave Vencedora : ";
        int cnt = 0;
        int cntE = 0;

        for(int i = 0; i < 7; i++) {
            res += this.key[i] + " | ";
        }
        res += "\n                         -*_*-*_*-*_*-*_*-*_*-*_*-*_*-*_*-*_*-\n  _ . _ Chave Dada      : ";
        for(int j = 0; j < 7; j++) {
            if (guess[j] == this.key[j]) {
                res += "€ | ";
                if (j < 5) { cnt++; } else { cntE++; }
            } else {
                res += "X | ";
            }
        }

        // *** Verificar se Ganhaste Prémio ***
        if ((cnt == 5) && (cntE == 2)) {
            res += "\n" +
                    "\n" +
                    "              -.-.-.-.-.-.-.-.-.-*-.-.-.-.-.-.-.--.-.\n" +
                    "              -.-.-.-.-.-.-.-.*******.-.-.-.-.-.--.-.\n" +
                    "              -.-.-.-.-.-.-*************-.-.-.-.--.-.\n" +
                    "              -.-.-.-*****    PARABÉNS   *****-.--.-.\n" +
                    "              -.-.***** O EUROMILHÕES É TEU *****.-.-\n" +
                    "              -.-.-.-*************************-.--.-.\n" +
                    "              -.-.-.-.-.-.-*************-.-.-.-.--.-.\n" +
                    "              -.-.-.-.-.-.-.-.*******.-.-.-.-.-.--.-.\n" +
                    "              -.-.-.-.-.-.-.-.-.-*-.-.-.-.-.-.-.--.-.\n" +
                    "\n";
            for(int k = 0; k < 50; k++) {
                for (int y = k; y != 0; y--) {
                    res += "  ";
                }
                res += Arrays.toString(this.key)+"\n";
            }
        } else {
            res += "\n" + "\n" + "-.-.-.-.-.-.-.-.-.-*-.-.-.-.-.-.-.--.-.\n" +
                    "\n" + "\n" + "     ::: Números Certos : " + cnt + "\n     ::: Estrelas Certas : " + cntE +
                    "\n" + "\n" +
                    "\n" +
                    "-.-.-.-.-.-.-.-.-.-*-.-.-.-.-.-.-.--.-.\n" +"\n" + "\n" +
                    "    ***   BEST LUCK NEXT TIME    ***   \n" +"\n" + "\n" +
                    "-.-.-.-.-.-.-.-.-.-*-.-.-.-.-.-.-.--.-.\n" ;
        }

        return res;
    }

}
