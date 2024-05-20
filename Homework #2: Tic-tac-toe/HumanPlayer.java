import java.util.Scanner;

/**
 * A class that represents a human Tic-tac-toe player that reads moves from the keyboard.
 *
 * @author Alexandra Guillen
 * @version 1.0
 */
public class HumanPlayer extends APlayer
{
    public HumanPlayer​(Game game, char symbol){
        super(game, symbol);
    }
    
    public Move pickMove(){
        Scanner scanner = new Scanner(System.in);
        int r;
        int c;
        
        System.out.println("Pick Move: ");
        String move = scanner.next();
        move = move.toUpperCase();
        if (move.equals("QUIT"))
            return null;
        else {    
            r = move.charAt(0) - 'A';
            c = move.charAt(1) - '1';
        }
        
        Move humanmove  = new Move(r,c);
        
        return humanmove;
    }
}
