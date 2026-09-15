package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    @SuppressWarnings("all")
    private final Scanner sc;
    private final ArrayList<Game> gamesLibrary;

    public LibraryManager(Scanner sc, ArrayList<Game> gamesLibrary) {
        this.sc = sc;
        this.gamesLibrary = gamesLibrary;
    }

    public void addGame(Game pendingGame) {
        gamesLibrary.add(pendingGame);
    }

    public void removeGame(int selectedOption) {
    gamesLibrary.remove(selectedOption);
    }

    public ArrayList<Game> getGamesLibrary() {
        return gamesLibrary;
    }
}
