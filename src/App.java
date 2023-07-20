import com.doubleslitexperiment.main.QuantumDoubleSlitGame;
import com.schrodingerscatexperiment.main.SchrodingerCat;
import com.schrodingerscatexperiment.model.ClearScreen;

import java.util.Scanner;

import static com.schrodingerscatexperiment.main.SchrodingerCat.getUserInput;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang..");
        System.out.println("Pilih Permainan Eksperimen:");
        System.out.println("1. Eksperimen Kucing Schrödinger (Schrodinger's Cat)");
        System.out.println("2. Eksperimen Percobaan Celah Ganda (Double Slit Experiment)");
        System.out.println("3. Keluar");

        int gameChoice;
        do {
            System.out.print("Pilihan (1/2/3): ");
            gameChoice = getUserInput(scanner, 1, 3);

            switch (gameChoice) {
                case 1 -> {
                    ClearScreen.clearScreen();
                    SchrodingerCat.main(args);
                }
                case 2 -> {
                    ClearScreen.clearScreen();
                    QuantumDoubleSlitGame.main(args);
                }
                case 3 -> System.out.println("Terima Kasih Telah Bermain! Goodbye!");
                default -> System.out.println("Pilihan tidak valid. Mohon pilih dengan benar.");
            }
        } while (gameChoice != 3);

        scanner.close();
    }
}