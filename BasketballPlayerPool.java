/**
 * List of all players to choose from.
 * 
 * @author Jonathan Molina 
 * @version Project 2 - Fantasy Basketball Draft; 18 October 2013
 */
import java.util.ArrayList;

public class BasketballPlayerPool extends AbstractFantasyTeam
{
    /**
     * Default constructor that initializes the list of BasketballPlayers with the
     * hard-coded BasketballPlayer information.
     */
    public BasketballPlayerPool()
    {
        /** 
         * Easetern Conference
         * */

        /* Atlantic Division */
        addBrooklynNets();
        addPhiladelphia76ers();

        /* Southeast Division */
        addMiamiHeat();
        addCharlotteBobcats();

        /** 
         * Western Conference
         * */

        /* Northwest Division */
        addOklahomaCityThunder();
        addMinnesotaTimberwolves();

        /* Pacifc Division */
        addGoldenStateWarriors();
        addSacramentoKings();
    }

    /**
     * getPlayer(int)
     *
     * Outputs a deep copy of the BasketballPlayer at the specific index.
     *
     * @param index - Position of the BasketballPlayer in the ArrayList.
     * @return BasketballPlayer object at that given index (deep copy).
     */
    public BasketballPlayer getPlayer(int index)
    {
        return new BasketballPlayer(this.get(index));
    }

    /**
     * getPlayer(String)
     *
     * Only called if the player is in the list. Searches for the BasketballPlayer
     * and outputs a deep copy of it.
     *
     * @param name - BasketballPlayer's name. Used to search through list.
     * @return BasketballPlayer object with the same name (deep copy).
     */
    // Only called if player in list in order to check if valid pick
    public BasketballPlayer getPlayer(String name)
    {
        int index = 0;

        for (int cycle = 0; cycle < this.size(); cycle++)
        {
            if (this.get(cycle).getPlayerName().toUpperCase().equals(name.toUpperCase()))
            {
                index = cycle;
            }
        }

        return new BasketballPlayer(this.get(index));
    }

    /**
     * removePlayer
     *
     * Removes BasketballPlayer with the same name from the list.
     * Assumes the player is in the list.
     *
     * @param name - Name of the BasketballPlayer.
     */
    public void removePlayer(String name)
    {
        int index = 0;

        for (int cycle = 0; cycle < this.size(); cycle++)
        {
            /* Check to see if the name searching for. */
            if (this.get(cycle).getPlayerName().toUpperCase().equals(name.toUpperCase()))
            {
                index = cycle;
            }
        }

        this.remove(index);
    }

    /**
     * containsPlayer
     *
     * Searches for a player in the list with the given name
     * and returns true if fond.
     *
     * @param name - Name of the BasketballPlayer.
     * @return True if player found.
     */
    public boolean containsPlayer(String name)
    {
        boolean contains = false;

        for (int cycle = 0; cycle < this.size(); cycle++)
        {
            if (this.get(cycle).getPlayerName().toUpperCase().equals(name.toUpperCase()))
            {
                contains = true;
            }
        }

        return contains;
    }

    /**
     * EASTERN CONFERENCE
     */

    /* Atlantic Division */

    /**
     * addBrooklynNets
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addBrooklynNets()
    {
        Team nets = new Team("Nets", "Brooklyn", "Eastern", "Atlantic", 9);

        this.add(new BasketballPlayer("Deron Williams", nets, 8, "PG", 20.4, 2.8, 0.440, 0.860, 2.2, 3.0, 7.7));
        this.add(new BasketballPlayer("Brook Lopez", nets, 11, "C", 19.4, 1.8, 0.521, 0.758, 0.0, 6.9, 0.6));
    }

    /**
     * addPhiladelphia76ers
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addPhiladelphia76ers()
    {
        Team seventySixers = new Team("76ers", "Philadelphia", "Eastern", "Atlantic", 26);

        this.add(new BasketballPlayer("Jrue Holiday", seventySixers, 11, "PG", 17.7, 3.7, 0.431, 0.752, 2.0, 4.2, 8.0));
        this.add(new BasketballPlayer("Thaddeus Young", seventySixers, 21, "SF", 14.8, 1.2, 0.531, 0.574, 0.1, 7.5, 1.6));
    }

    /* Southeast Division */

    /**
     * addMiamiHeat
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addMiamiHeat()
    {
        Team heat = new Team("Heat", "Miami", "Eastern", "Southeast", 1);

        this.add(new BasketballPlayer("LeBron James", heat, 6, "SF", 26.8, 3.0, 0.565, 0.753, 2.4, 8.0, 7.3));
        this.add(new BasketballPlayer("Chris Bosh", heat, 1, "PF", 19.5, 2.1, 0.496, 0.799, 0.1, 8.9, 2.1));
    }

    /**
     * addCharlotteBobcats
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addCharlotteBobcats()
    {
        Team bobcats = new Team("Bobcats", "Charlotte", "Eastern", "Southeast", 28);

        this.add(new BasketballPlayer("Kemba Walker", bobcats, 15, "PG", 17.7, 2.4, 0.423, 0.798, 3.0, 3.5, 5.7));
        this.add(new BasketballPlayer("Gerald Henderson", bobcats, 9, "SG", 15.5, 1.6, 0.447, 0.824, 1.0, 3.7, 2.6));
    }   

    /**
     * WESTERN CONFERENCE
     */

    /* Northwest Division */

    /**
     * addOklahomaCityThunder
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addOklahomaCityThunder()
    {
        Team thunder = new Team("Thunder", "Oklahoma City", "Western", "Northwest", 2);

        this.add(new BasketballPlayer("Kevin Durant", thunder, 35, "SF", 30.8, 3.5, 0.510, 0.905, 3.2, 7.9, 4.6));
        this.add(new BasketballPlayer("Kendrick Perkins", thunder, 5, "C", 4.2, 1.4, 0.457, 0.611, 0.0, 6.0, 1.4));
    }

    /**
     * addMinnesotaTimberwolves
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addMinnesotaTimberwolves()
    {
        Team timberwolves = new Team("Timberwolves", "Minnesota", "Western", "Northwest", 25);

        this.add(new BasketballPlayer("Kevin Love", timberwolves, 42, "PF", 18.3, 2.2, 0.352, 0.704, 1.8, 14.0, 2.3));
        this.add(new BasketballPlayer("Ricky Rubio", timberwolves, 9, "PG", 10.7, 3.0, 0.360, 0.800, 1.4, 4.0, 7.3));
    }    

    /* Pacifc Division */

    /**
     * addSacramentoKings
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addSacramentoKings()
    {
        Team kings = new Team("Kings", "Sacramento", "Western", "Pacific", 13);

        this.add(new BasketballPlayer("Marcus Thorton", kings, 23, "SG", 12.7, 0.9, 0.429, 0.881, 3.7, 2.5, 1.3));
        this.add(new BasketballPlayer("Jason Thompson", kings, 34, "PF", 10.5, 1.2, 0.502, 0.694, 0.0, 6.7, 1.0));
    }

    /**
     * addGoldenStateWarriors
     *
     * Adds the BasketballPlayers to the list.
     */
    private void addGoldenStateWarriors()
    {
        Team warriors = new Team("Warrios", "Golden State", "Western", "Pacific", 10);

        this.add(new BasketballPlayer("Klay Thompson", warriors, 11, "SG", 16.6, 1.9, 0.429, 0.881, 3.7, 2.5, 1.3));
        this.add(new BasketballPlayer("David Lee", warriors, 10, "C", 18.5, 2.6, 0.502, 0.694, 0.0, 1.2, 3.5));
    }
}
