/**
 * FantasyPlayer.java
 *
 * The FantasyPlayer represents the players drafting BasketballPlayers using the FantasyTeam class.
 *
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
public class FantasyPlayer
{
    private String fantasyPlayerName;                    // The Fantasy Player's name.
    private FantasyTeam fantasyTeam = new FantasyTeam(); // Refers to the Fantasy Player's Fantasy Team of Basketball Players.

    /**
     * Constructor for FantasyPlayer objects and initializes the player's name.
     *
     * @param name - Fantasy Players name.
     */
    public FantasyPlayer(String name)
    {
        fantasyPlayerName = name;
    }

    /**
     * Adds a player to the Fantasy Team and returns true if successful.
     * 
     * @param player - BasketballPlayer object being added to the team.
     * @return True if player added successful.
     */
    public boolean addPlayer(BasketballPlayer player)
    {
        return fantasyTeam.addPlayer(player);
    }

    /**
     * size
     * 
     * Query method for the size of the team.
     * 
     * @return The size of the team.
     */
    public int size()
    {
        return fantasyTeam.getSize();
    }

    /**
     * getName
     *
     * Query method for the name of the Fantasy Player.
     * 
     * @return The name of the Fantasy Player.
     */
    public String getName()
    {
        return fantasyPlayerName;
    }

    /**
     * toString
     *
     * Overrides toString method to show the Fantasy Player's name and the
     * Basketball Players on his team.
     * 
     * @return String of Fantasy Player's name and the team.
     */
    public String toString()
    {
        return fantasyPlayerName + "'s Team: " + fantasyTeam.toString();
    }
}
