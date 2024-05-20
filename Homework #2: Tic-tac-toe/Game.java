import java.util.Scanner;

/**
 * A class that represents a Tic-tac-toe game.
 *
 * @author Alexandra Guillen
 * @version 1.0
 */
public class Game
{
    char[][] board;
    int boardSize;
    APlayer[] players;
    final char blank = ' ';
    final char cpu = 'O';
    final char human = 'X';

    public Game(int boardSize){
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];
        
        for(int i=0; i < boardSize; i++){
            char[] row = board[i];
            for(int j=0; j < boardSize; j++){
                row[j] = ' ';
            }
        }
    }

    public int getBoardSize(){
        if(boardSize == 0)
            boardSize = 3;
        else if(boardSize < 1 || boardSize > 9) 
            throw new IllegalArgumentException("Board size must be within 1 and 9");
        return boardSize;
    }

    protected void resetGame(){
        for(int i=0; i < boardSize; i++){
            char[] row = board[i];
            for(int j=0; j < boardSize; j++){
                row[j] = ' ';
            }
        }
    }

    public char isValidMove​(Move move){
        if (move.row < 0 || move.row > boardSize)
            return 'R';
        else if (move.col < 0 || move.col > boardSize)
            return 'C';
        else if (board[move.row][move.col] != blank)
            return 'O';
        return 'V';
    }

    protected boolean executeMove​(Move move, char symbol){
        if (isValidMove(move) != 'V')
            return false;
        else{
            board[move.row][move.col] = symbol;
            return true;
        }    
    }

    public char getGameStatus(){
        int numX = 0;
        int numO = 0;
        
        for (int i=0; i < board.length; i++){
            char[] row = board[i];
            for (int j=0; j < board.length; j++){
                if (row[j] == 'X') numX++;
                else if (row[j] == 'O') numO++;
                else break; 
            }
            if (numX == board.length) return 'X';
            else if (numO == board.length) return 'O';
            else{
                numX = 0;
                numO = 0;
            }
        }
        
        for (int i=0; i < board.length; i++){
            for (int j=0; j < board.length; j++){
                char elem = board[j][i];
            
                if (elem == 'X') numX++;
                else if (elem == 'O') numO++;
                else break;
            }
            if (numX == board.length) return 'X';
            else if (numO == board.length) return 'O';
            else{
                numX = 0;
                numO = 0;
            }
        }
        
        for (int i=0; i < board.length; i++){
            char elem = board[i][i];
                
            if (elem == 'X') numX++;
            else if (elem == 'O') numO++;
            else break;
        }
        
        if (numX == board.length) return 'X';
            else if (numO == board.length) return 'O';
            else{
                numX = 0;
                numO = 0;
            }
        
        for (int i=0; i < board.length; i++){
            char elem = board[i][(board.length - 1) - i];
                
            if (elem == 'X') numX++;
            else if (elem == 'O') numO++;
            else break;
        }
        
        if (numX == board.length) return 'X';
            else if (numO == board.length) return 'O';
            else{
                numX = 0;
                numO = 0;
            }
        
        for (int i=0; i < board.length; i++){
            for (int j=0; j < board.length; j++){
                char elem = board[i][j];
            
                if (elem == ' ') return '?';
            }
        }
        
        return 'T';
    }

    public String toString(){
        String emptyboard = "";

        for(int i=1; i <= board.length; i++){
            emptyboard += "   " + i;
        }
        for(int j=0; j < board.length; j++){
            char[] row = board[j];
            emptyboard += "\n" + (char)('A' + j) + " ";
            for(int k=0; k < board.length; k++){
                emptyboard += " " + row[k] + " ";
                if (k < board.length - 1)
                    emptyboard += "|";
            }
            if (j < board.length - 1){
                emptyboard += "\n  ---";
                for (int l=0; l < board.length - 1; l++){
                    emptyboard += "|---";
                }
                }
            }
        return emptyboard;
    }

    public char playSingleGame(){
        Game singlegame = new Game(boardSize);
        HumanPlayer player1 = new HumanPlayer(singlegame, 'X');
        CpuPlayer player2 = new CpuPlayer(singlegame, 'O');
        APlayer player = new APlayer();
        
        Move firstmove;
        
        if (Math.random() < .5)
            player = player1;
        else 
            player = player2;
        
        do{
        firstmove = player.pickMove();
        
        if (firstmove == null) return 'Q';
        
        if (!singlegame.executeMove(firstmove, player.symbol)){
            System.out.println("Invalid move");
        }
        else{
            singlegame.executeMove(firstmove, player.symbol);
            System.out.println(singlegame.toString());
            if (player == player1) player = player2;
            else player = player1;
        }
        } while (singlegame.getGameStatus() == '?');
        
        if (singlegame.getGameStatus() == 'X') return 'H';
        else if (singlegame.getGameStatus() == 'O') return 'C';
        return 'T';
    }
    
    public static void main​(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-tac-toe!");
        int size; 
        try {
            size = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException e){
            size = 3;
        }

        if(size < 1 || size > 9) size = 3;

        Game game = new Game(size);
        
        System.out.println(game.toString());
        char result;
        GameStats stats = new GameStats();
        
        while(true){
        result = game.playSingleGame();
        
        if (result == 'H'){
            stats.recordWin();
            System.out.println("You won!");
        }
        else if (result == 'C'){
            stats.recordLoss();
            System.out.println("Computer won :(");
        }
        else if (result == 'T'){
            stats.recordTie();
            System.out.println("Tie");
        }
        else{
            System.out.println(stats.toString());
            break;
        }
        
        game.resetGame();
        }
    }
}    
