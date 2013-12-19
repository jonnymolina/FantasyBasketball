/**
 * BasketballPlayer.java
 *
 * A BasketballPlayer class extends the Player class. Represents a basketball
 * that includes his or her player number, position, and statistics.
 * 
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
public class BasketballPlayer extends Player
{
    private int number;            // The player's number.
    private String position;       // The player's position on the team.
    private BasketballStats stats; // The player's basketball satistics.
    
    /**
     * Default constructor for objects of class BasketballPlayer.
     */
    public BasketballPlayer() {}

    /**
     * Constructor for objects of class BasketballPlayer that initializes BasketballPlayer
     * with: Basketballplayer's name, team information, number, position, and stats.
     * 
     * @param name      - Basketballplayer's name.
     * @param team      - Basketballplayer's team information.
     * @param pNumber   - BasketballPlayer's number.
     * @param pPosition - BasketballPlayer's positon.
     * @param pStats    - BasketballPlayer's personal statistics.
     */
    public BasketballPlayer(String name, Team team, int pNumber, String pPosition, BasketballStats pStats)
    {
        super(name, team);
        number = pNumber;
        position = pPosition;
        stats = pStats;
    }

    /**
     * Constructor for objects of class BasketballPlayer that initializes BasketballPlayer
     * with: Basketballplayer's name, team information, number, position, and individual stats.
     * 
     * @param name      - Basketballplayer's name.
     * @param team      - Basketballplayer's team information.
     * @param pNumber   - BasketballPlayer's number.
     * @param pPosition - BasketballPlayer's positon.
     * @param pStats    - BasketballPlayer's personal statistics.
     * @param avgPts  - Average points.
     * @param avgTO  - Average turnovers.
     * @param ftPct  - Free throw percentage.
     * @param avg3pt - Average number of 3 pointers per game.
     * @param avgREB - Average number of rebounds per game.
     * @param avgAST - Average number of assists per game.
     */
    public BasketballPlayer(String name, Team team, int pNumber, String pPosition, double avgPts, double avgTO,
                            double fgPCT, double ftPCT, double avg3PT, double avgReb, double avgAst)
    {
        super(name, team);
        number = pNumber;
        position = pPosition;
        stats = new BasketballStats(avgPts, avgTO, fgPCT, ftPCT, avg3PT, avgReb, avgAst);
    }

    /**
     * Constructor used to make deep copies of BasketballPlayer objects.
     * 
     * @param player - Basketball player.
     */
    public BasketballPlayer(BasketballPlayer player)
    {
        super(player.getPlayerName(), player.getTeam());
        number = player.number;
        position = player.position;
        stats = player.stats;
    }

    /**
     * getPlayerNumber
     *
     * Query method for the BasketballPlayer's number.
     * 
     * @return The number of the BasketballPlayer.
     */
    public int getPlayerNumber()
    {
        return number;
    }

    /**
     * getPlayerPosition
     *
     * Query method for the BasketballPlayer's position.
     * 
     * @return The position of the BasketballPlayer.
     */
    public String getPlayerPosition()
    {
        return position;
    }

    /**
     * getBBallStats
     *
     * Query method for the BasketballPlayer's personal statistics.
     * 
     * @return The stats of the BasketballPlayer.
     */
    public BasketballStats getBBallStats()
    {
        return stats;
    }

    /**
     * isSamePosition
     *
     * Checks if two players have the same basketball position.
     * 
     * @return True if same position.
     */
    public boolean isSamePosition(BasketballPlayer player)
    {
        return position.equals(player.position);
    }

    /**
     * toString
     *
     * Overrides toString method to add the basketball player's position and stats.
     * 
     * @return String of the Basketball Player's position and stats.
     */
    public String toString()
    {
        return super.toString() + "Position: " + position + "\nStats: " + stats.toString() + "\n";
    }
}
