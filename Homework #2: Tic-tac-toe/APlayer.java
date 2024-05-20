
/**
 * An abstract class representing a generic Tic-tac-toe game player.
 *
 * @author Alexandra Guillen
 * @version 1.0
 */
public class APlayer
{
    protected Game game;
    protected char symbol;
    
    protected APlayer(){}
    
    protected APlayer(Game game, char symbol){
        this.game = game;
        this.symbol = symbol;
    }
    
    public char getSymbol(){
        return 0;
    }
    
    public Move pickMove(){
        return null;
    }
}
