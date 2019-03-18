import java.util.Scanner;

public class ScannerSingleton {
    private Scanner scanner;
    private static ScannerSingleton ourInstance = new ScannerSingleton();

    public static ScannerSingleton getInstance() {
        return ourInstance;
    }

    private ScannerSingleton() {
        scanner = new Scanner(System.in);
    }

    public String next(){
        return scanner.next();
    }
    public int nextInt(){
        return scanner.nextInt();
    }

}
