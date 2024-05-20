
/**
 * A class that keeps track of the game statistics.
 *
 * @author Alexandra Guillen
 * @version 1.0
 */
public class GameStats
{
    int nwins;
    int nties;
    int nlosses;
    
    public GameStats(){
        nwins = 0;
        nties = 0;
        nlosses = 0;
    }
    
    public void recordWin(){
        nwins += 1;
    }
    
    public void recordTie(){
        nties += 1;
    }
    
    public void recordLoss(){
        nlosses += 1;
    }
    
    public String toString(){
        return "Number of wins: " + nwins + "\nNumber of ties: " + nties + "\nNumber of losses: " + nlosses;
    }

}
