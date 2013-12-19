/**
 * Player.java
 *
 * A Player class that represents a generic sports player that includes
 * his or her player name and team information.
 * 
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
public class Player
{
    private String playerName; // The name of the player.
    private Team team;         // Information about the team.

    /**
     * Default constructor for objects of class Player.
     */
    public Player()
    {}
    
    /**
     * Constructor for objects of class Player that initializes Player
     * with the given player name and Team object.
     * 
     * @param pName - Name of the player.
     * @param team - Team object, contains team information.
     */
    public Player(String pName, Team tTeam)
    {
        playerName = pName;
        team = tTeam;
    }
    
    /**
     * Query method for the name of the player.
     * 
     * @return The name of the player.
     */
    public String getPlayerName()
    {
        return playerName;
    }
    
    /**
     * Query method for the player's team.
     * 
     * @return The player's team.
     */
    public Team getTeam()
    {
        return team;
    }

    /**
     * Overrides toString method to show the Player's name and team.
     * 
     * @return String of "Name, City Team\n".
     */
    public String toString()
    {
        return playerName + ", " + team.getCity() + " " + team.getTeam() + "\n";
    }
}
