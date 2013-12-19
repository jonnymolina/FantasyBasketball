/**
 * BasketballStats.java
 *
 * A BasketballStats class extends SportsStats and adds specific basketball statistics.
 * Includes FG%, FT%, 3PT Avg, Reb Avg, Ast Avg, Stl Avg, and Blk Avg. 
 *
 * @author Jonathan Molina
 * @version 18 October 2013
 */
public class BasketballStats extends SportsStats
{
    private double fgPCT;  // Field goal percentage.
    private double ftPCT;  // Free throw percentage.
    private double avg3PT; // Average number of 3 pointers per game.
    private double avgReb; // Average number of rebounds per game.
    private double avgAst; // Average number of assists per game.


    /**
     * Constructor for BasketballStats objects that initializes all instance variables
     * including its super class's instance variables.
     * 
     * @param avPts  - Average points.
     * @param avgTO  - Average turnovers.
     * @param fgPct  - Field goal percentage
     * @param ftPct  - Free throw percentage.
     * @param avg3pt - Average number of 3 pointers per game.
     * @param avgREB - Average number of rebounds per game.
     * @param avgAST - Average number of assists per game.
     */
    public BasketballStats(double avgPts, double avgTO, double fgPct, double ftPct,
        double avg3pt, double avgREB, double avgAST)
    {
        super(avgPts, avgTO);
        fgPCT = fgPct;
        ftPCT = ftPct;
        avg3PT = avg3pt;
        avgReb = avgREB;
        avgAst = avgAST;
    }

    /**
     * getFG
     * 
     * Query method for the field goal percentage.
     * 
     * @return The field goal percentage.
     */
    public double getFG()
    {
        return fgPCT;
    }

    /**
     * getFT
     * 
     * Query method for the free throw percentage.
     * 
     * @return The free throw percentage.
     */
    public double getFT()
    {
        return fgPCT;
    }

    /**
     * get3PT
     * 
     * Query method for average number of 3 pointers per game.
     * 
     * @return The average number of 3 pointers per game.
     */
    public double get3PT()
    {
        return avg3PT;
    }

    /**
     * getREB
     * 
     * Query method for the average number of rebounds per game.
     * 
     * @return The average number of rebounds per game.
     */
    public double getREB()
    {
        return avgReb;
    }

    /**
     * getAST
     * 
     * Query method for the average number of assists per game.
     * 
     * @return The average number of assists per game.
     */
    public double getAST()
    {
        return avgAst;
    }

    /**
     * toString
     *
     * Overrides toString method to show the stats all in one line.
     * 
     * @return String of Basketball Stats on one line.
     */
    public String toString()
    {
        String out = super.toString() + " FG %: " + fgPCT + " FT %: " + ftPCT + " Avg 3PT: " + avg3PT 
                    + " Avg REB: " + avgReb + " Avg AST: " + avgAst;
        return out;
    }
}
