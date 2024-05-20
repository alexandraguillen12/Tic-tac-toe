
/**
 * A class that represents a computer-controlled Tic-tac-toe player that implements a random playing strategy.
 *
 * @author Alexandra Guillen
 * @version 1.0
 */
public class CpuPlayer extends APlayer
{
    public CpuPlayer(Game game, char symbol){
        super(game, symbol);
    }
    
    public Move pickMove(){ 
        char[][] board = game.board;
        int length = board.length;
        int randrow;
        int randcol;
        Move cpumove;
        
        while (true){
            randrow = (int) (length*Math.random());
            randcol = (int) (length*Math.random());
            cpumove = new Move(randrow, randcol);
            
            if (game.isValidMove(cpumove) == 'V')
                return cpumove;
            else continue;
        }
        
    }
}
