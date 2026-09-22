package entities;

import java.util.ArrayList;

public class LibraryManager {
    private final ArrayList<Game> gamesLibrary;

    public LibraryManager(ArrayList<Game> gamesLibrary) {
        this.gamesLibrary = gamesLibrary;
    }

    public boolean addGame(Game pendingGame) {
        gamesLibrary.add(pendingGame);
        return true;
    }

    public void removeGame(int selectedOption) {
    gamesLibrary.remove(selectedOption);
    }

    public ArrayList<Game> getGamesLibrary() {
        return gamesLibrary;
    }
}
