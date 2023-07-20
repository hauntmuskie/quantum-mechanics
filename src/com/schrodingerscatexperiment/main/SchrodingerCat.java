package com.schrodingerscatexperiment.main;

import com.schrodingerscatexperiment.model.ClearScreen;

import java.util.Random;
import java.util.Scanner;

public class SchrodingerCat {
    private static final String CAT_ALIVE_EMOJI = "😽";
    private static final String CAT_DEAD_EMOJI = "😿";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di permainan Kucing Schrödinger!");
        System.out.println("Kucing ini ada di dalam kotak dengan nasib yang belum diketahui...");
        System.out.println("Apakah kucing ini hidup atau mati? 🐱");
        System.out.println("--------------------------------------------");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Mulai Permainan");
            System.out.println("2. Informasi Permainan dan Dunia Kuantum");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1/2/3): ");
            int menuChoice = getUserInput(scanner, 1, 3);
            System.out.println();

            switch (menuChoice) {
                case 1:
                    startGame(scanner);
                    break;
                case 2:
                    ClearScreen.clearScreen();
                    displayInformation();
                    break;
                case 3:
                    System.out.println("Terima kasih telah bermain!");
                    scanner.close();
                    System.exit(0);
                    break;
            }

            // Pause before clearing the screen to allow the player to read the results
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ClearScreen.clearScreen();
        }
    }

    private static void startGame(Scanner scanner) {
        while (true) {
            System.out.println("Kotak-kotak tersedia: [1] [2] [3] [4] [5]");
            System.out.print("Masukkan nomor kotak pilihanmu: ");
            int boxNumber = getUserInput(scanner, 1, 5);

            int randomBox = getRandomBoxNumber();
            animateOpeningBox(boxNumber, randomBox);

            boolean isCatAlive = determineCatState(boxNumber, randomBox);
            System.out.println();
            System.out.print("Hasil: ");
            if (isCatAlive) {
                System.out.println("Kamu membuka kotak nomor " + boxNumber + " " + CAT_ALIVE_EMOJI);
                System.out.println("Yay! Kucingnya hidup, selamat! 😸");

                // Penjelasan Multiverse:
                System.out.println();
                System.out.println("Interpretasi Multiverse: Di alam semesta paralel, ada versi dirimu yang lain yang membuka kotak yang sama,");
                System.out.println("namun di alam semesta itu, kucingnya ternyata sudah meninggal. Namun, di alam semesta ini,");
                System.out.println("keberuntungan berpihak padamu, dan kucingnya masih hidup! Nikmati kebahagiaan dari peristiwa yang menguntungkan ini.");
            } else {
                System.out.println("Kamu membuka kotak nomor " + boxNumber + " " + CAT_DEAD_EMOJI);
                System.out.println("Oh, kucingnya sudah mati... 😿");

                // Penjelasan Multiverse:
                System.out.println();
                System.out.println("Interpretasi Multiverse: Dalam luasnya multiverse, terdapat banyak realitas alternatif di mana kamu membuka");
                System.out.println("kotak dan menemukan kucingnya masih hidup. Namun, di cabang multiverse ini, takdir berjalan berbeda,");
                System.out.println("dan sang kucing sayangnya telah meninggal. Kenanglah kenangan akan kucing tersebut dan renungkanlah ketidakpastian eksistensi.");
            }

            System.out.println("--------------------------------------------");
            System.out.print("Apakah kamu ingin mencoba lagi? (Y/N) > ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private static void displayInformation() {
        System.out.println("Informasi Permainan dan Dunia Kuantum");
        System.out.println("--------------------------------------------");
        System.out.println("Kucing Schrödinger adalah sebuah ilustrasi dalam dunia kuantum yang terkenal,");
        System.out.println("yang pertama kali diusulkan oleh fisikawan Austria bernama Erwin Schrödinger pada tahun 1935.");
        System.out.println("Konsep ini berfokus pada paradoks yang melibatkan kucing dalam kotak.");
        System.out.println("Kucing tersebut ada dalam superposisi keadaan hidup dan mati sampai kotaknya dibuka.");
        System.out.println("Hasil eksperimen tergantung pada seberapa banyak kita mengetahui tentang sistem kuantum.");
        System.out.println("Jadi, dalam permainan ini, kucing bisa hidup atau mati berdasarkan keputusan Anda dalam membuka kotak.");
        System.out.println();
        System.out.println("Dalam fisika kuantum, ada banyak fenomena yang tidak selalu berperilaku seperti partikel dalam dunia makroskopik.");
        System.out.println("Superposisi adalah konsep bahwa partikel kuantum dapat berada dalam dua atau lebih keadaan secara bersamaan,");
        System.out.println("sehingga kucing bisa hidup dan mati dalam kotak sebelum keadaannya diamati.");
        System.out.println("Dalam interpretasi Kopenhagen, ketika pengamat melihat kotak, kucing akan terkunci dalam keadaan hidup atau mati,");
        System.out.println("mengakhiri superposisi dan membentuk dunia yang konsisten dengan pengamatan.");
        System.out.println("Namun, ada interpretasi lain seperti banyak dunia dan kolaps gelombang yang juga menawarkan penjelasan.");
        System.out.println("--------------------------------------------");
        System.out.println("Selamat bermain dan semoga menyenangkan! 😸");
        System.out.println();
    }

    public static int getUserInput(Scanner scanner, int minChoice, int maxChoice) {
        int userChoice;
        while (true) {
            try {
                userChoice = scanner.nextInt();
                if (userChoice >= minChoice && userChoice <= maxChoice) {
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Masukkan angka antara " + minChoice + " dan " + maxChoice + ".");
                }
            } catch (Exception e) {
                System.out.println("Pilihan tidak valid. Masukkan angka antara " + minChoice + " dan " + maxChoice + ".");
                scanner.next(); // Clear the invalid input
            }
        }
        return userChoice;
    }

    private static int getRandomBoxNumber() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    private static void animateOpeningBox(int selectedBox, int randomBox) {
        System.out.println("Sedang membuka kotak...");
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isCatAlive = determineCatState(selectedBox, randomBox);

        // Animation with randomness based on the Schrödinger equation
        Random random = new Random();
        int numFrames = 10;
        for (int frame = 0; frame < numFrames; frame++) {
            String animation = "";
            String schrodinger = "iħ ∂ψ/∂t = -ħ²/(2m) ∇²ψ + Vψ";
            char schrodingerChar = schrodinger.charAt(frame);
            for (int i = 0; i < 8; i++) {
                char symbol = (random.nextDouble() > 0.5) ? schrodingerChar : ' ';
                animation += symbol;
            }
            System.out.print(animation);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\r");
        }

        // Animation to reveal the outcome
        System.out.print("Kucingnya " + (isCatAlive ? "hidup" : "mati") + "!");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
                System.out.print(" .");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private static boolean determineCatState(int selectedBox, int randomBox) {
        int result = (selectedBox + randomBox) % 2;
        return result != 0;
    }
}
