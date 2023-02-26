import Ficha1.Ficha1;
import Ficha2.Ficha2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void ficha1( String[] args ) {

        Ficha1 teste = new Ficha1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ficha 1:\n    Qual é o exercício:\n");

        switch ( sc.nextInt() ) {

            case 1:
                System.out.println(" --- Celsius Para Farenheit --- \n\n   - Argumento (Double) : \n");
                System.out.println(teste.celsiusParaFarenheit( sc.nextDouble() ));
                break;

            case 2:
                System.out.println(" --- Maximo entre 2 Numeros --- \n\n   - Argumentos (2 Int) : \n");
                Integer a = sc.nextInt();
                Integer b = sc.nextInt();
                System.out.println(teste.maximoNumeros(a,b));
                break;

            case 3:
                System.out.println(" --- Descricao da Conta --- \n\n   - Argumentos (1 String, 1 Double) : \n");
                sc.nextLine();
                String nome = sc.nextLine();

                Double saldo = sc.nextDouble();
                System.out.println( teste.criaDescricaoConta( nome , saldo ) );
                break;

            case 4:
                System.out.println(" --- Euro Para Libras --- \n\n   - Argumentos (2 Double) : \n");
                System.out.println(" + Euros :");
                Double euro = sc.nextDouble();
                System.out.println(" + Taxa :");
                Double taxa = sc.nextDouble();
                System.out.println(" + Libras : " + teste.eurosParaLibras( euro , taxa ) );
                break;

            case 5:
                System.out.println(" --- Imprime Decrescente e com a Media --- \n\n   - Argumentos (2 Int) : \n");
                System.out.println( teste.decresceMedia( sc.nextInt(), sc.nextInt()) );
                break;

            case 6:
                System.out.println(" --- Factorial de um Numero --- \n\n   - Argumentos ( ) : \n");
                System.out.println( teste.factorial( Integer.valueOf(args[0]) ) );
                break;

            case 7:
                System.out.println(" --- Tempo Gasto no Calculo do Factorial de 5000 --- \n\n   - Argumentos ( ) : \n");
                System.out.println( teste.tempoGasto() );
                break;

        }
    }

    public static void ficha2(String[] args) {

        Ficha2 teste = new Ficha2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ficha 2:\n    Qual é o exercício:\n");

        switch (sc.nextInt()) {

            case 1:
                System.out.println(" --- O Minimo da Tua Lista --- \n\n   - Quantos Elementos (Ints) :");

                int ct = sc.nextInt();
                int[] arr = new int[ct];
                int count = 0;
                int valor;
                System.out.println("   - Então quais são os Números?");
                while (ct != count) {
                    valor = sc.nextInt();
                    arr[count] = valor;
                    count++;
                }
                System.out.println(Arrays.toString(arr));

                teste.setArrInt(arr);
                System.out.println(teste.lerMinimo());
                break;

            case 2:
                System.out.println(" --- Como é o Array entre os Indices --- \n\n   - Quantos Elementos (Ints) :");
                int ct1 = sc.nextInt();
                int[] arr1 = new int[ct1];
                int count1 = 0;
                System.out.println("   - Então quais são os Números?");
                while (ct1 != count1) {
                    int tmp = sc.nextInt();
                    arr1[count1] = tmp;
                    count1++;
                }
                teste.setArrInt(arr1);

                System.out.println("   - Então quais são os índices: (2 ints)");
                int tmp1 = sc.nextInt();
                int tmp2 = sc.nextInt();

                System.out.println( Arrays.toString(teste.arrEntreIndice( tmp1, tmp2) ) );
                break;

            case 3:
                System.out.println(" --- Elementos Comuns entre 2 Arrays --- \n\n   - Quantos Elementos tem cada Array (2 Ints) :");
                int cteste = sc.nextInt();
                int cteste1 = sc.nextInt();
                int[] arrtest = new int[cteste];
                int[] arrtest1 = new int[cteste1];
                int countT = 0;
                System.out.println("   - Então quais são os Números do 1º Array?");
                while (cteste != countT) {
                    int tmp = sc.nextInt();
                    arrtest[countT] = tmp;
                    countT++;
                }
                countT = 0;
                System.out.println("   - Então quais são os Números do 2º Array?");
                while (cteste1 != countT) {
                    int tmp = sc.nextInt();
                    arrtest1[countT] = tmp;
                    countT++;
                }

                teste.setArrInt(arrtest);
                teste.setArrInt2(arrtest1);
                System.out.println( Arrays.toString(teste.comumEntreArr()));
                break;

            case 4:
                System.out.println(" --- Operações Entre Datas --- \n\n");
                teste.insereData(LocalDate.parse("2023-12-24"));
                teste.insereData(LocalDate.parse("2022-12-20"));
                System.out.println(teste.dataMaisProxima(LocalDate.parse("2023-03-17")));
                System.out.println(teste.toString());
                break;

            case 5:
                System.out.println("Still Not Answered\n");
                break;

            case 6:
                System.out.println(" --- Operações Sobre Array de Strings --- \n\n");
                String[] stringTest = {"abc","ald","ald\n","abc","def","quim 123","deg","def","abc","quim 123","ald\n"};
                teste.setArrString(stringTest);
                System.out.println(Arrays.toString(teste.stringSemRep()));
                System.out.println("   Maior String : "+teste.maiorString());
                System.out.println(Arrays.toString(teste.stringQueRep()));
                System.out.println("   A String 'abc' aparece "+teste.qtRepString("abc")+" vezes.");
                
        }

    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("   * * * Qual é a ficha que desejas ver: * * *");
        int fic = sc.nextInt();

        switch ( fic ) {

            case 1:
                ficha1( args );

            case 2:
                ficha2( args );

        }
    }
}
