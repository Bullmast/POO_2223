import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
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

                break;

        }
    }
}
