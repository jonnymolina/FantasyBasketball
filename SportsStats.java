/**
 * SportsStats.java
 *
 * A SportsStats class contains common sports statistics to a player.
 * Includes average points and average turnovers.
 * 
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
public class SportsStats
{
    private double avgPts; // Average points.
    private double avgTO;  // Average turnovers.
    
    /**
     * Constructor for SportsStats objects that initializes avgPts and avgTO.
     * 
     * @param pts - Average points.
     * @param to  - Average turnovers.
     */
    public SportsStats(double pts, double to)
    {
        avgPts = pts;
        avgTO = to;
    }
    
    /**
     * setPts
     *
     * Set the avgPts instance.
     * 
     * @param pts - Average points.
     */
    public void setPts(double pts)
    {
        avgPts = pts;
    }
    
    /**
     * setTO
     *
     * Set the avgTO instance.
     * 
     * @param to - Average turnovers.
     */
    public void setTO(double to)
    {
        avgTO = to;
    }

    /**
     * getPts
     *
     * Query method for the avgPts.
     * 
     * @return The points average.
     */
    public double getPts()
    {
        return avgPts;
    }
    
    /**
     * getAvgTO
     *
     * Query method for the avgTO.
     * 
     * @return The turnover average.
     */
    public double getAvgTO()
    {
        return avgTO;
    }

    /**
     * toString
     *
     * Overrides toString method to show average points and turnovers.
     * 
     * @return String of the average poitns and turnovers.
     */
    public String toString()
    {
        return "Avg PTS: " + avgPts + " TO: " + avgTO;
    }
}
