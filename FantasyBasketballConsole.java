/**
 * FantasyBasketballConsole.java
 *
 * The FantasyBasketballConsole runs the Fantasy Basketball Draft interface.
 * 
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
import java.util.Scanner;
import java.io.IOException;

public class FantasyBasketballConsole
{

    /**
     * Runs the Fantasy Basketball Draft program.
     *
     * @throws IOException - Writing out to a text file.
     */
    public static void main(String[] args) throws IOException
    {
        /* Create FantasyBasketballApp object in order to run the game. */
        FantasyBasketballApp draft = new FantasyBasketballApp(new Scanner(System.in));
        /* Run the Fantasy Basketball Draft */
        draft.run();
    }

}