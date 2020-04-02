import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(a + b);
    }
}