package application;

import ui.ConsoleUI;
import entities.Game;
import entities.LibraryManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Game> gamesLibrary = new ArrayList<>();
        LibraryManager libraryManager = new LibraryManager(sc, gamesLibrary);
        ConsoleUI consoleUI = new ConsoleUI(sc, libraryManager);
        consoleUI.process();

        sc.close();
    }
}
