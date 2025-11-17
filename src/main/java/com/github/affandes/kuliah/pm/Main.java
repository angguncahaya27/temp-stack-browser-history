package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<String> history = new Stack<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n----- MENU BROWSER -----");
            System.out.println("1. Browse Website");
            System.out.println("2. Back");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine(); // bersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan URL Website: ");
                    String url = input.nextLine();
                    browse(url);
                    break;
                case 2:
                    back();
                    break;
                case 3:
                    viewHistory();
                    break;
                case 4:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);

        input.close();
    }

    public static void browse(String url) {
        history.push(url);
        System.out.println("Anda mengunjungi: " + url);
    }

    public static void back() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("Kembali dari: " + removed);
        } else {
            System.out.println("History kosong!");
        }
    }

    public static void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history!");
        } else {
            System.out.println("\nRiwayat Kunjungan:");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println("- " + history.get(i));
            }
        }
    }
}

    