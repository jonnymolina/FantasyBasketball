/**
 * Team.java
 *
 * The Team class represents a sports team that includes the team name and
 * which conference and division the team is in.
 *
 * @author Jonathan Molina
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
public class Team
{
    private String name;        // Team's name.
    private String city;        // Team's city.
    private String conference;  // Team's conference.
    private String division;    // Team's division.
    private int rank;           // Team's rank.
    
    /**
     * Constructor for objects of class Team that initializes the team name.
     *
     * @param teamName - Team's name.
     * @param cityName - Team's city.
     * @param confName - Team's conference.
     * @param divName  - Team's division.
     * @param rankNum  - Team's rank.
     */
    public Team(String teamName, String cityName, String confName, String divName, int rankNum)
    {
        name = teamName;
        city = cityName;
        conference = confName;
        division = divName;
        rank = rankNum;
    }

    /**
     * getTeam
     *
     * Query method for the name of the team.
     * 
     * @return The name of the team.
     */
    public String getTeam()
    {
        return name;
    }

    /**
     * getCity
     *
     * Query method for the name of the city.
     * 
     * @return The name of the city.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * getConference
     *
     * Query method for the name of the conference.
     * 
     * @return The name of the conference.
     */
    public String getConference()
    {
        return conference;
    }

    /**
     * getDivision
     *
     * Query method for the name of the division.
     * 
     * @return The name of the division.
     */
    public String getDivision()
    {
        return division;
    }

    /**
     * getRank
     *
     * Query method for the rank of the team
     * 
     * @return The team's rank.
     */
    public int getRank()
    {
        return rank;
    }
}
