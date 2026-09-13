package application;

import entities.LibraryManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager(sc);

        libraryManager.addGameFlow();
        sc.close();
    }
}
