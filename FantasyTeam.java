/**
 * FantasyTeam.java
 *
 * The Team class represents a sports team that includes the team name and
 * which conference and division the team is in.
 *
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
import java.util.ArrayList;
public class FantasyTeam extends AbstractFantasyTeam
{
    //private ArrayList<BasketballPlayer> fantasyTeam = new ArrayList<BasketballPlayer>();

    /**
     * Default constructor for FantasyTeam objects.
     */
    public FantasyTeam()
    {}

    /**
     * Constructor for FantasyTeam and adds the BasketballPlayer to the list.
     *
     * @param newPlayer - Adds a new BasketballPlayer to the list.
     */
    public FantasyTeam(BasketballPlayer newPlayer)
    {
        this.add(newPlayer);
    }

    /**
     * getTeam
     *
     * Query method for a deep copy of the ArrayList of BasketballPlayers.
     * 
     * @return The ArrayList of BasketballPlayers (deep copy).
     */
    public ArrayList<BasketballPlayer> getTeam()
    {
        /* Create new ArrayList of BasketballPlayers, ready for copying */
        ArrayList<BasketballPlayer> deepCopyTeam = new ArrayList<BasketballPlayer>();
        int cycle = 0; // Variable to help cycle through list. 

        /* Cycle through list */
        while (cycle < this.size())
        {
            /* Calls deep copy constructor. */
            deepCopyTeam.add(new BasketballPlayer(this.get(cycle)));
            cycle++;
        }

        return deepCopyTeam;
    }

    /**
     * addPlayer
     *
     * Adds a player to the Fantasy Team and returns true if successful.
     * 
     * @param player - BasketballPlayer object being added to the team.
     * @return True if player added successful.
     */
    public boolean addPlayer(BasketballPlayer newPlayer)
    {
        boolean success = false;

        /* If no players on the list, no need to check. */
        if (this.size() == 0)
        {
            this.add(newPlayer);
            success = true;
        }
        /* If there are other players on the team, check positions. */
        else if (checkValid(newPlayer))
        {
            this.add(newPlayer);
            success = true;
        }
        
        return success;
    }

    /**
     * checkValid
     *
     * Checks if position different than the others. True if it is valid.
     * 
     * @param player - BasketballPlayer object being added to the team.
     * @return True if valid move.
     */
    public boolean checkValid(BasketballPlayer player)
    {
        boolean valid = true, check;

        for (int cycle = 0; cycle < this.size(); cycle++)
        {
            /* Call method to see if same position */
            check = this.get(cycle).isSamePosition(player);
            if (check)
            {
                valid = false;
            }
        }

        return valid;
    }

    /**
     * size
     * 
     * Query method for the size of the team.
     * 
     * @return The size of the team.
     */
    public int getSize()
    {
        return this.size();
    }

    /**
     * toString
     *
     * Overrides toString method to append the players on the team
     * and their position together.
     * 
     * @return String of the players on the team and their positions.
     */
    public String toString()
    {
        String players = "";

        for (int cycle = 0; cycle < this.size(); cycle++)
        {
            /* PlayerName (Position) */
            players += (this.get(cycle).getPlayerName() + " (" + this.get(cycle).getPlayerPosition()) + ") ";
        }

        return players;
    }
}
