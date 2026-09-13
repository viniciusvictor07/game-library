package application;

import entities.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Game> gamesLibrary = new ArrayList<>();
        String selectedName;
        String selectedFranchise;
        String selectedRanking;
        String selectedPendingStatus;

        System.out.println("Enter game name:");
        selectedName = input.nextLine();

        System.out.println("Enter game franchise:");
        selectedFranchise = input.nextLine();

        System.out.println("Enter game ranking:");
        selectedRanking = input.nextLine();

        System.out.println("Enter game pending status:");
        selectedPendingStatus = input.nextLine();

        Game pendingGame = new Game(selectedName, selectedFranchise, selectedRanking, selectedPendingStatus);
        gamesLibrary.add(pendingGame);

        System.out.println("Games list:");
        for (Game game : gamesLibrary) {
            System.out.printf("%s - %s - %s - %s\n",
                    game.getName(),
                    game.getFranchise(),
                    game.getRanking(),
                    game.getPendingStatus());
        }
        input.close();
    }
}
