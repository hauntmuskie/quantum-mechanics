package com.doubleslitexperiment.model;

import java.util.Random;
import java.util.Scanner;

public class QuantumDoubleSlitExperiment {
    private boolean isObserverEnabled;
    private String subAtomType;

    public QuantumDoubleSlitExperiment() {
        this.isObserverEnabled = false;
        this.subAtomType = "elektron"; // Default subatom adalah elektron
    }

    public void setObserverEnabled(boolean isEnabled) {
        this.isObserverEnabled = isEnabled;
    }

    public void setSubAtomType(String subAtomType) {
        this.subAtomType = subAtomType;
    }

    public void startExperiment() throws InterruptedException {
        helloScreen();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            clearScreen();

            switch (choice) {
                case 1 -> toggleObserverEffect();
                case 2 -> chooseSubAtomType(scanner);
                case 3 -> runExperiment();
                case 4 -> {
                    System.out.println("Keluar dari permainan. Sampai jumpa!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }

            pauseForInput(); // Tunggu sampai pengguna menekan tombol sebelum melanjutkan
            clearScreen(); // Hapus/refresh layar sebelum menampilkan menu berikutnya
        }
    }

    private void helloScreen() {
        System.out.println("Selamat datang di Eksperimen Celah Ganda Kuantum!");
        System.out.println("Anda akan mengirim " + subAtomType + " melalui dua celah sempit dan melihat pola interferensi atau biasa.");
        System.out.println("Penting: Efek Pengamat akan mempengaruhi perilaku subatom!");
        displayObserverStatus();
    }

    private void toggleObserverEffect() {
        isObserverEnabled = !isObserverEnabled;
        displayObserverStatus();
    }

    private void chooseSubAtomType(Scanner scanner) {
        System.out.print("Pilih Jenis Subatom (elektron, foton, neutron): ");
        String subAtom = scanner.next().toLowerCase();
        if (subAtom.equals("elektron") || subAtom.equals("foton") || subAtom.equals("neutron")) {
            subAtomType = subAtom;
            System.out.println("Jenis subatom telah diubah menjadi " + subAtomType + ".");
        } else {
            System.out.println("Jenis subatom tidak valid. Pilih antara 'elektron', 'foton', atau 'neutron'.");
        }
    }

    private void runExperiment() throws InterruptedException {
        System.out.println("Eksperimen Sedang Berjalan...");
        System.out.println("Mengirim " + subAtomType + " melalui celah ganda...");
        displayObserverStatus();

        if (isObserverEnabled) {
            System.out.println("Efek Pengamat (Observer): Subatom berinteraksi dengan lingkungannya.");
        } else {
            System.out.println("Efek Pengamat (Interferensi): Subatom tetap dalam keadaan superposisi/interferensi.");
        }

        System.out.print("Menembakkan " + subAtomType + " melalui celah ganda: ");
        animateShooting();

        if (isObserverEnabled) {
            displayParticleBehavior();
        } else {
            displayWaveBehavior();
        }

        System.out.println();
        System.out.println("Eksperimen berhasil!");
    }

    private void animateShooting() {
        System.out.print("📹 ");
        for (int i = 0; i < 8; i++) {
            System.out.print("• ");
            delay();
        }
        System.out.println();
    }

    private void displayParticleBehavior() {
        int rows = 5;
        int cols = 2;
        System.out.println("\nHasil Pola Biasa (Perilaku Partikel):");
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("•       ");
            }
            System.out.println();
        }

    }

    private void displayWaveBehavior() throws InterruptedException {
        int rows = 8;
        int cols = 6;
        int numDots = 88; // Number of dots to appear in the pattern
        int animationDuration = 5; // 10 seconds
        long startTime = System.currentTimeMillis();
        Random random = new Random();

        System.out.println("\nHasil Pola Interferensi (Perilaku Gelombang) - Static Random Wave Pattern:");
        System.out.println();

        // Generate random positions for the dots
        int[][] dotPositions = new int[numDots][2];
        for (int i = 0; i < numDots; i++) {
            dotPositions[i][0] = random.nextInt(rows);
            dotPositions[i][1] = random.nextInt(cols);
        }

        // Main animation loop
        while (System.currentTimeMillis() - startTime < animationDuration) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    char character = isDotPosition(dotPositions, i, j) ? '•' : ' ';
                    System.out.print(character + "       ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Helper method to check if a given position is a dot position
    private static boolean isDotPosition(int[][] dotPositions, int row, int col) {
        for (int[] dotPosition : dotPositions) {
            if (dotPosition[0] == row && dotPosition[1] == col) {
                return true;
            }
        }
        return false;
    }

    private void displayObserverStatus() {
        System.out.println("Status Efek Pengamat saat ini: " +
                (isObserverEnabled ? "Diaktifkan 👀" : "Dinonaktifkan ❌"));
    }

    private void displayMenu() {
        System.out.println("=====================================");
        System.out.println("Menu:");
        System.out.println("1. Aktifkan/Nonaktifkan Efek Pengamat (Observer)");
        System.out.println("2. Pilih Jenis Subatom (elektron, foton, neutron)");
        System.out.println("3. Mulai Eksperimen");
        System.out.println("4. Keluar");
        System.out.println("Masukkan pilihan (1/2/3/4): ");
        System.out.println("=====================================");
    }

    private void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            Process process;
            if (os.contains("win")) {
                process = new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
            } else {
                process = new ProcessBuilder("clear").inheritIO().start();
            }
            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pauseForInput() {
        System.out.print("Tekan enter untuk melanjutkan...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

