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
        if (libraryManager.addGame(newGame())) {
            System.out.println("Game added successfully!");
        } else {
            System.out.println("Game already exists!");
        }
    }

    public void removeGameFlow() {

        showGamesFlow();
        System.out.println("Enter the game number to remove:");
        int selectedGame = readInt() - 1;
        libraryManager.removeGame(selectedGame);
        System.out.println("Game removed successfully!");
    }

    public void showGamesFlow() {
        if (isLibraryEmpty()) {
            return;
        }
        showGamesList();
    }

    public void showSelectedGameInfoFlow() {
        if (isLibraryEmpty()) {
            return;
        }
        showGamesList();
        System.out.println("Enter the game number to show info:");
        int selectedOption = readInt() - 1;
        showGameInfo(selectedOption);
    }

    public void showGamesList() {
        System.out.println("----- Games List -----");
        ArrayList<Game> gamesLibrary = libraryManager.getGamesLibrary();
        for (Game game : gamesLibrary) {
            System.out.printf("%d. %s\n",
                    gamesLibrary.indexOf(game) + 1,
                    game.getName().toUpperCase());
        }
    }

    public void showGameInfo(int selectedOption) {
        ArrayList <Game> gamesLibrary = libraryManager.getGamesLibrary();
        for (Game game : gamesLibrary) {
            if (gamesLibrary.indexOf(game) == selectedOption) {
                System.out.println( "----- Game Info -----\n" + game.getName().toUpperCase());
                System.out.printf("Franchise: %s\n", game.getFranchise().toUpperCase());
                System.out.printf("Ranking: %s\n", game.getRanking().toUpperCase());
                System.out.printf("Pending Status: %s\n", game.getPendingStatus().toUpperCase());
                System.out.println("-------------------");
            }
        }
    }

    public void showMenu() {
        System.out.println("----- Game Library -----");
        System.out.println("1. Add a game");
        System.out.println("2. Remove a game");
        System.out.println("3. Show games");
        System.out.println("4. Show selected game info");
        System.out.println("0. Exit");
        System.out.println("Enter your option:");
    }

    public void process() {
        while (true) {
            showMenu();
            int selectedOption = readInt();

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
            case 4:
                showSelectedGameInfoFlow();
                break;
            default:
                showInvalidOption();
                break;
        }
    }

    public Game newGame() {
        System.out.println("Enter game name:");
        String selectedName = readValidString();

        System.out.println("Enter game franchise:");
        String selectedFranchise = readValidString();

        System.out.println("Enter game ranking:");
        String selectedRanking = chooseRanking();

        String selectedPendingStatus = choosePendingStatus();

        return new Game(selectedName, selectedFranchise, selectedRanking, selectedPendingStatus);
    }

    public String chooseRanking() {
        showRankingOptions();
        int rankingOption = readInt();
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
        int pendingOption = readInt();
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

    public boolean isLibraryEmpty() {
        if (libraryManager.getGamesLibrary().isEmpty()) {
            System.out.println("The library is empty.");
            return true;
        } else {
            return false;
        }
    }

    public int readInt() {
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                sc.nextLine();
                showInvalidOption();
            }
        }
    }

    public String readValidString() {
        String input;
        while ((input = sc.nextLine().trim()).isEmpty()) {
            showInvalidOption();
        }
        return input;
    }

    public void showInvalidOption() {
        System.out.println("Invalid input, please try again: ");
    }

    public void exit() {
        System.out.println("Exiting... Goodbye!");
    }
}
