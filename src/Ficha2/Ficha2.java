package Ficha2;
import java.time.LocalDate;
import java.util.Arrays;

public class Ficha2 {

    private LocalDate[] datas;
    private int[] arrInt;
    private int[] arrInt2;

    // Construtores da Classe Ficha 2
    public Ficha2 () {
        this.datas = new LocalDate[0];
        this.arrInt = new int[0];
        this.arrInt2 = new int[0];
    }


    // Set das Variáveis de Instância
    public void setArrInt(int[] tmp) {
        this.arrInt = Arrays.copyOf(tmp, tmp.length);
    }

    public void setArrInt2(int[] tmp) {
        this.arrInt2 = Arrays.copyOf(tmp, tmp.length);
    }

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

}
