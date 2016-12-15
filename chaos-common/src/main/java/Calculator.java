import java.util.Scanner;

public class Calculator {

    public int add(int a, int b) {
        int c = a + b;
        System.out.println("c");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator roboot = new Calculator();
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = roboot.add(a, b);
            System.out.printf(String.format("%d + %d = %d", a, b, c));
        }
    }

}