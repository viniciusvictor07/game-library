package ui;

import entities.Game;
import entities.LibraryManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private final LibraryManager libraryManager;
    private final Scanner sc;

    public ConsoleUI(Scanner sc, LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
        this.sc = sc;
    }

    public void addGameFlow() {
        Game pendingGame = createGame();
        libraryManager.addGame(pendingGame);
        System.out.println("Game added successfully!");
    }

    public void removeGameFlow() {
        showGamesFlow();
        System.out.println("Enter the game number to remove:");
        int selectedGame = readOption() - 1;
        libraryManager.removeGame(selectedGame);
        System.out.println("Game removed successfully!");
    }


    public void showGamesFlow() {
        ArrayList<Game> gamesLibrary = libraryManager.getGamesLibrary();
        int index = 0;
        System.out.println("----- Games List -----");
        for (Game game : gamesLibrary) {
            index++;
            System.out.printf("%d. %s\nFranchise: %s\nRanking: %s\nPending Status: %s\n",
                    index,
                    game.getName().toUpperCase(),
                    game.getFranchise(),
                    game.getRanking(),
                    game.getPendingStatus());
        }
        System.out.println("-------------------");
    }

    public void showMenu() {
        System.out.println("1. Add a game");
        System.out.println("2. Remove a game");
        System.out.println("3. Show games");
        System.out.println("0. Exit");
        System.out.println("Enter your option:");
    }

    public void process() {
        while (true) {
            showMenu();
            int selectedOption = readOption();

            if (selectedOption == 0) {
                exit();
                break;
            } else {
                handleService(selectedOption);
            }
        }
    }

    public void handleService(int selectedOption) {
        switch (selectedOption) {
            case 1:
                addGameFlow();
                break;
            case 2:
                removeGameFlow();
                break;
            case 3:
                showGamesFlow();
                break;
            default:
                showInvalidOption();
                break;
        }
    }

    public Game createGame() {
        System.out.println("Enter game name:");
        String selectedName = sc.nextLine();

        System.out.println("Enter game franchise:");
        String selectedFranchise = sc.nextLine();

        System.out.println("Enter game ranking:");
        String selectedRanking = chooseRanking();

        String selectedPendingStatus = choosePendingStatus();

        return new Game(selectedName, selectedFranchise, selectedRanking, selectedPendingStatus);
    }

    public String chooseRanking() {
        showRankingOptions();
        int rankingOption = readOption();
        return switch (rankingOption) {
            case 1 -> "S";
            case 2 -> "A";
            case 3 -> "B";
            case 4 -> "C";
            case 5 -> "D";
            case 6 -> "E";
            default -> "NA";
        };
    }

    public void showRankingOptions() {
        System.out.println("Enter game ranking:");
        System.out.println("1. S");
        System.out.println("2. A");
        System.out.println("3. B");
        System.out.println("4. C");
        System.out.println("5. D");
        System.out.println("6. E");
        System.out.println("7. NA");
        System.out.println("Enter your option:");
    }

    public String choosePendingStatus() {
        showPendingStatusOptions();
        int pendingOption = readOption();
        return switch (pendingOption) {
            case 1 -> "Playing";
            case 2 -> "Completed";
            case 3 -> "Wishlist";
            case 4 -> "Abandoned";
            default -> "Unknown";
        };
    }

    public void showPendingStatusOptions() {
        System.out.println("Enter game pending status:");
        System.out.println("1. Playing");
        System.out.println("2. Completed");
        System.out.println("3. Wishlist");
        System.out.println("4. Abandoned");
        System.out.println("Enter your option:");
    }

    public int readOption() {
        while (true) {
            try {
                int option = sc.nextInt();
                sc.nextLine();
                return option;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number:");
            }
        }
    }

    public void showInvalidOption() {
        System.out.println("Invalid option");
    }

    public void exit() {
        System.out.println("Exiting... Goodbye!");
    }
}
