package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    ArrayList<Game> gamesLibrary = new ArrayList<>();
    private final Scanner sc;

    public LibraryManager(Scanner sc) {
        this.sc = sc;
    }

    public void addGameFlow() {
        System.out.println("Enter game name:");
        String selectedName = sc.nextLine();

        System.out.println("Enter game franchise:");
        String selectedFranchise = sc.nextLine();

        System.out.println("Enter game ranking:");
        String selectedRanking = sc.nextLine();

        System.out.println("Enter game pending status:");
        String selectedPendingStatus = sc.nextLine();

        Game pendingGame = new Game(selectedName, selectedFranchise, selectedRanking, selectedPendingStatus);
        gamesLibrary.add(pendingGame);
        showGames();
    }

    public void showGames() {
        System.out.println("Games list:");
        for (Game game : gamesLibrary) {
            System.out.printf("Name:%s - Franchise: %s - Ranking: %s - Pending Status: %s\n",
                    game.getName(),
                    game.getFranchise(),
                    game.getRanking(),
                    game.getPendingStatus());
        }
    }
}
