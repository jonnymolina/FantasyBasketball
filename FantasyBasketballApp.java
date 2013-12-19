/**
 * The underlying code for the whole Fantasy Basketball Draft.
 * 
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

public class FantasyBasketballApp
{
    private Scanner in;                                                               // Scanner to scan user input.
    private int numFantasyPlayers;                                                    // Number of Fantasy Players.
    private int numRounds;                                                            // Number of draft rounds.
    private BasketballPlayerPool basketballPlayers = new BasketballPlayerPool();      // BasketballPlayer selection.
    private ArrayList<FantasyPlayer> fantasyPlayers = new ArrayList<FantasyPlayer>(); // List of Fantasy Players.
    public static final int kDEFAULT_ROUNDS = 5;

    /**
     * Constructor for objects of class FantasyBasketballApp.
     * 
     * @param input - Initialize scanner to scan user input.
     */
    public FantasyBasketballApp(Scanner input)
    {
        in = input;
    }

    /**
     * run
     * 
     * Runs the whole Fantasy Basketball Draft.
     *
     * @throws IOException - Writing out to a text file.
     */
    public void run() throws IOException
    {
        /* Welcome screen */
        System.out.println("\nWelcome to the Fantasy Basketball Draft! This is where you"
                         + "\npractice drafting for the upcoming NBA Fantasy Basketball Season."
                         + "\n\nHope you kept up with the preseason and good luck!\n");

        numFantasyPlayers = getNumPlayers();                      // Initializes number of Fantasy Players.
        System.out.println("\nThere are 5 rounds of drafting.");
        numRounds = kDEFAULT_ROUNDS;                              // Initializes number of draft rounds.

        /* Prompt each Fantasy Player to enter names. */
        for (int cycle = 0; cycle < numFantasyPlayers; cycle++)
        {
            System.out.print("\nName of Fantasy Player "+ (fantasyPlayers.size() + 1) +" (First and/or Last Name) : ");
            fantasyPlayers.add(new FantasyPlayer(in.nextLine())); // Initialize the list of fantasy players.
        }

        /* If players not ready to begin the draft */
        if (!startDraft())
        {
            System.out.println("\nYou don't want to start the draft yet? Run me again when you guys are ready!\n\n");
        }
        /* Otherwise, run the draft. */
        else
        {
            runDraft();
            System.out.println("\n\nThank you for participating!\n");
        }
    }

    /**
     * reverse
     *
     * Reverse the order of FantasyPlayers.
     * 
     * @param fantasyPlayers - The list of FantasyPlayers to be reversed.
     */
    public void reverse(ArrayList<FantasyPlayer> fantasyPlayers)
    {
        FantasyPlayer temp;
        /* For even number of players */
        if (fantasyPlayers.size() % 2 == 0)
        {
            for (int cycle = 0, reverse = fantasyPlayers.size() - 1; cycle < reverse; cycle++, reverse--)
            {
                temp = fantasyPlayers.get(cycle);                       // Store the current Fantasy Player in a temporary location.
                fantasyPlayers.set(cycle, fantasyPlayers.get(reverse)); // Replace the current item with its corresponding reversed component.
                fantasyPlayers.set(reverse, temp);                      // Store the stored Fantasy Player at its corresponding reversed index.
            }
        }
        /* For odd number of players */
        else
        {
            for (int cycle = 0, reverse = fantasyPlayers.size() - 1; cycle != reverse; cycle++, reverse--)
            {
                temp = fantasyPlayers.get(cycle);                       // Store the current Fantasy Player in a temporary location.
                fantasyPlayers.set(cycle, fantasyPlayers.get(reverse)); // Replace the current item with its corresponding reversed component.
                fantasyPlayers.set(reverse, temp);                      // Store the stored Fantasy Player at its corresponding reversed index.
            }
        }
    }

    /**
     * getNumPlayers
     *
     * Prompt the user for the number of FantasyPlayers.
     * 
     * @return Number of FantasyPlayers about to play.
     */
    public int getNumPlayers()
    {
        Scanner in2 = new Scanner(System.in); // New scanner to scan in input.
        int numPlayers;                       // Variable to store number of players.

        System.out.print("\nEnter the number of players (between 2 and 3 inclusive): ");
        numPlayers = in2.nextInt();

        /* Prompt user again if user input out of range. */
        while (numPlayers < 2 || numPlayers > 3)
        {
            System.out.println("Number of players invalid.");
            System.out.print("Enter the number of players (between 2 and 3 inclusive): ");

            /* Prompts user again if inputting anything else other than an integer. */
            while (!in2.hasNextInt())
            {
                System.out.print("Enter the number (integer) of the players (range from 2 to 3): ");
                in2.next();
            }

            numPlayers = in2.nextInt();       // Stores inputted integer.
        }

        return numPlayers;
    }

    /**
     * startDraft
     *
     * Determines whether the users are ready to start the draft.
     * 
     * @return True if the users are ready to begin the draft.
     */
    public boolean startDraft()
    {
        System.out.print("\n\nAre you guys ready to start the draft? (Y/N) ");
        String response = in.nextLine().toUpperCase();
        boolean startDraft;

        if (response.equals("Y"))
        {
            startDraft = true;
        }
        else
        {
            startDraft = false;
        }

        return startDraft;
    }

    /**
     * runDraft
     *
     * Runs the draft round by round. Displays results after and prompts
     * user if text files of the results are desired.
     * 
     * @throws IOException - Writing out to a text file.
     */
    public void runDraft() throws IOException
    {
        int roundCount = 0; // Keeps tracks of the number of rounds.

        /* If there are still rounds left */
        while (roundCount < numRounds)
        {
            /* Each Fantasy Player takes a turn choosing a Basketball Player. */
            for (int cycle = 0; cycle < fantasyPlayers.size(); cycle++)
            {
                displayMainMenu(cycle);
            }

            reverse(fantasyPlayers); // Reverse the order of picks after each round.
            roundCount++;            // Increase to move on to the next round.

            /* Indicate to the users that the round has ended. */
            System.out.println("\n---------- END OF ROUND " + roundCount + " ----------");
        }
        
        /* Indicate to the users that the draft is over. */
        System.out.println("\n\n********** END OF DRAFT **********\n\n");
        System.out.println("\n********** Results **********\n");

        reverse(fantasyPlayers); // Reverse list one more time for original order.
        displayFantasyTeams();   // Display the results after drafting.
        System.out.println();
        writeToFile();           // Prompts user if text file of the results are desired.
    }

    /**
     * writeToFile
     *
     * Prompts the user if text file of the results are wanted.
     * User enters the file name.
     * 
     * @throws IOException - Writing out to a text file.
     */
    public void writeToFile() throws IOException
    {
        System.out.print("Would you like to save the results onto a text file? (Y/N) ");
        String response = in.nextLine().toUpperCase();
        boolean write = false;

        if (response.equals("Y"))
        {
            write = true;
        }

        if (write)
        {
            System.out.print("Enter the file name (without .txt extension): ");
            writeDraftToFile(in.next() + ".txt");
        }
    }

    /**
     * displayFantasyTeams
     *
     * Prints out the Fantasy Player's name and Basketball Players on his/her
     * team with the position of each player also.
     * 
     */
    public void displayFantasyTeams()
    {
        for (int cycle = 0; cycle < fantasyPlayers.size(); cycle++)
        {
            /* If no players on team, indicate to users with '(None)' */
            if (fantasyPlayers.get(cycle).size() == 0)
            {
                System.out.println(fantasyPlayers.get(cycle).getName() + "'s Team: (None)");   
            }
            /* Otherwise, begin to print out normally. */
            else
            {
                System.out.println(fantasyPlayers.get(cycle).toString());
            }
        }
    }

    /**
     * displayAllPlayers
     *
     * Displays all available BasketballPlayers left to be chose.
     * 
     * @param all - If true, shows all players. If false, shows 5 or under.
     */
    public void displayAllPlayers(boolean all)
    {
        BasketballPlayer display; // Temporary BasketballPlayer object for easy method declaration.

        /* If user wants, show all players available. */
        if (all)
        {
            System.out.println("\n\n\nPlayers Available (all " + basketballPlayers.size() + "): \n");
            /* Cycle through the whole list to print out. */
            for (int cycle = 0; cycle < basketballPlayers.size(); cycle++)
            {
                display = basketballPlayers.getPlayer(cycle);
                System.out.println(display.toString());
            }
        }
        /* Otherwise, show the first 5 BasketballPlayers in the list. */
        else if (basketballPlayers.size() > 5)
        {
            System.out.println("\n\n\nPlayers Available (showing 5 of " +  basketballPlayers.size() + "): \n");
            /* Cycle through first 5 BasketballPlayers to display. */
            for (int cycle = 0; cycle < 5; cycle++)
            {
                display = basketballPlayers.getPlayer(cycle);
                System.out.println(display.toString());
            }
        }
        /* If less than 5 players availabe, then show the rest. */
        else
        {
            System.out.println("\n\n\nPlayers Available (" +  basketballPlayers.size() + " players left): \n");
            /* Cycle through the rest of the list to display the last few BasketballPlayers availabe. */
            for (int cycle = 0; cycle < basketballPlayers.size(); cycle++)
            {
                display = basketballPlayers.getPlayer(cycle);
                System.out.println(display.toString());
            }
        }
    }

    /**
     * enterPlayer
     *
     * Prompts the Fantasy Player for which BasketballPlayer to add to their Fantasy Team.
     * 
     * @param fantasyPlayer - The turn Fantasy Player.
     */
    public void enterPlayer(FantasyPlayer fantasyPlayer)
    {
        /* Prompt the user to enter a player name, to view all players, or the first 5 players. */
        System.out.print("\nEnter player (first and last name), (a) for All Players, (b) to show first 5 players: ");
        String playerName = in.nextLine().toUpperCase(); // Scan in user input.

        /* If wanting to see all players. */
        if (playerName.equals("A"))
        {
            displayAllPlayers(true);
            displayFantasyTeams();
            System.out.println("\nFantasy Player " + fantasyPlayer.getName() + "'s turn to pick!");
            enterPlayer(fantasyPlayer);
        }
        /* Or wanting to see the first 5 players. */
        else if (playerName.equals("B"))
        {
            displayAllPlayers(false);
            displayFantasyTeams();
            System.out.println("\nFantasy Player " + fantasyPlayer.getName() + "'s turn to pick!");
            enterPlayer(fantasyPlayer);
        }
        /* If the player entered a BasketballPlayer in the list. */
        else if (basketballPlayers.containsPlayer(playerName))                  // Checks to see if list still has the player.
        {
            BasketballPlayer player = basketballPlayers.getPlayer(playerName);  // gets copy of basketball player
            boolean valid = fantasyPlayer.addPlayer(player);                    // Checks if valid. If true, already added to fantasy team.
            
            /* Added player to the Fantasy Team successful? */
            if (valid)
            {
                basketballPlayers.removePlayer(playerName);
            }
            /* Otherwise, position is already taken by another player. */
            else
            {
                System.out.println("\n" + fantasyPlayer.toString());
                System.out.println("\nThe position " + player.getPlayerPosition() + " is already taken. Please enter a different player"
                            + " with a different position.");
                enterPlayer(fantasyPlayer);
            }
        }
        /* Otherwise, the user did not input an existing BasketballPlayer. */
        else
        {
            System.out.println("\n'" + playerName + "' Is not available on the roster. Please choose another player.");
            enterPlayer(fantasyPlayer); // Prompts the turn Fantasy Player again.
        }
    }

    /**
     * displayMainMenu
     *
     * Displays the main menu where it shows the turn Fantasy Player, the BasketballPlayers on
     * each team, and the first 5 BasketballPlayers available.
     * 
     * @param currentPlayer - The index of the current Fantasy Player.
     */
    public void displayMainMenu(int currentPlayer)
    {
        /* FantasyPlayer object to retrieve current Fantasy Player for easy method calling. */
        FantasyPlayer currentFantasyPlayer = fantasyPlayers.get(currentPlayer);
        System.out.println("\n\n********** MAIN MENU **********\n\n");

        /* Display the current BasketballPlayers on each team. */
        displayFantasyTeams();

        /* Indicate the current turn Fantasy Player. */
        System.out.println("\nFantasy Player " + currentFantasyPlayer.getName() + "'s turn to pick!");
        /* Display the first 5 BasketballPlayers Avaiblable. */
        displayAllPlayers(false);

        /* Prompt the user to either add a BasketballPlayer or to view all the available players left. */
        System.out.print("\nEnter (p) to add a player name to your team or (a) to view all players: ");
        String input = in.nextLine().toUpperCase(); // Scan in user input.
        
        /* User wants to add a BasketballPlayer to their team. */
        if (input.equals("P"))
        {
            /* Prompt the turn Fantasy Player to pick a player */
            enterPlayer(currentFantasyPlayer);
        }
        /* User wants to view all BasketballPlayers available. */
        else if (input.equals("A"))
        {
            /* Display all players. */
            displayAllPlayers(true);
            /* Display the current players in each team. */
            displayFantasyTeams();
            /* Prompt the turn Fantasy Player to pick a player */
            System.out.println("\nFantasy Player " + currentFantasyPlayer.getName() + "'s turn to pick!");
            /* Prompt the turn Fantasy Player to pick a player */
            enterPlayer(currentFantasyPlayer);
        }
        /* Otherwise, the user inputted something invalid. Back to the main menu. */
        else
        {
            System.out.println("\nInvalid input.");
            /* Back to the main menu. */
            displayMainMenu(currentPlayer);
        }
    }

    /**
     * writeDraftToFile
     *
     * Creats a text file containing all the Fantasy Player's Teams.
     * 
     * @param fileName - Name of the text file being created.
     */
    public void writeDraftToFile(String fileName) throws IOException
    {
        PrintWriter out = new PrintWriter(fileName);                           // New PrintWrite Object to write data to a file.

        out.println("***************** Draft Results ***************** \n\n"); // Title of the results text file.
        for (int cycle = 0; cycle < fantasyPlayers.size(); cycle++)
        {
            /* Write the Fantasy Player's name and the players on their team. */
            out.println(fantasyPlayers.get(cycle).toString());
        }

        /* Close the file stream */
        out.close();
      }
}
