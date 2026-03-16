import java.util.Scanner;

/**
 * This class simulates a game of Tic Tac Toe between two players. To do this, this game uses a scanner to take a User's intputs of multiple ints
 * to mark their spot on the board, which is set using a 2D char array. This game runs until all tiles are filled and no ones wins or someone
 * wins by getting three Xs or Os in a row, column, or diagonal.
 */

public class TicTacToe {

	/*
	 * The main method declares a char array that acts as the board for Tic Tac Toe, containing simple lines to claim those values as
	 * unclaimed spots on the board. Then, variables are created that track whose turn it is between X and O, when the game is over,
	 * and how many moves have been made throughout the game. The main method also contains the main functions of the Tic Tac Toe
	 * game, grabbing the users' inputs and marking each spot on the board as claimed and changing
	 * their values to Xs and Os and then checking if a winner has been declared or if all
	 * the tiles are claimed. After the game is done, the scanner closes.
	 */
	
	public static void main(String[] args) 
	{

        Scanner input = new Scanner(System.in);

        char[][] board = 
        	{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        	};

        char currentPlayer = 'X';
        boolean gameOver = false;
        int moves = 0;

        System.out.println("Welcome to Tic Tac Toe!");
        
        // This while loop runs as long as the value gameOver isn't true. This loop runs the printBoard method to print the
        // current version of the board and what spots are claimed and unclaimed. Then, the pickSpot method is called on to
        // allow the current player (X or O) to pick a spot to claim.

        while (!gameOver) {

            printBoard(board);
            
            pickSpot(currentPlayer, board, moves, input);
            
            // These two following if statements check if one of the users connected three of their chars horizontally, 
            // vertically, or diagonally or if 9 moves have already been made, which signifies that there are no more moves to be made. 
            // These two if statements control whether or not the while loop continues as it'll shift the gameOver boolean to true
            // once one of the if statements can run and therefore end the entire loop.

            if (checkWinner(board, currentPlayer)) 
            {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            }

            else if (moves == 9) 
            {
                printBoard(board);
                System.out.println("The game is a tie!");
                gameOver = true;
            }
            
            // When a winner or tie isn't found yet, the while loop continues but with the other player, which is what these following
            // lines accomplish. When the current player is X, the value of currentPlayer is changed to O to reflect that it's O's player's
            // turn to play and vice versa.

            else 
            {
                if (currentPlayer == 'X') 
                {
                    currentPlayer = 'O';
                } 
                else 
                {
                    currentPlayer = 'X';
                }
            }
        }

        input.close();
    }
	
	/**
	 * This method simply prints out an updated version of the board (the 2D char array) after each turn, using a for loop to
	 * print out each value in the array.
	 */

    public static void printBoard(char[][] board) 
    {

        System.out.println("\nCurrent Board:");

        for (int i = 0; i < board.length; i++) 
        {

            for (int j = 0; j < board[i].length; j++) 
            {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
    
    /*
     * This method allows the current player to select which spot on the board they'd like to claim.
     * As long as the spot is unclaimed, that spot on the board is marked with an X or O. Otherwise,
     * the user will be prompted to select a new space.
     */
    
    public static void pickSpot(char currentPlayer, char[][] board, int moves, Scanner input)
    {
        System.out.println("Player " + currentPlayer + ", enter row (0-2): ");
        int row = input.nextInt();

        System.out.println("Player " + currentPlayer + ", enter column (0-2): ");
        int col = input.nextInt();

        if (board[row][col] == '-') 
        {
            board[row][col] = currentPlayer;
            moves++;
        } 
        else 
        {
            System.out.println("That space is already taken. Try again.");
            pickSpot(currentPlayer, board, moves, input);
        }
    }
    
    
    /**
     * This method checks if a player has won the game or not. Using various for loops and if statements, the 2D char array is 
     * Traversed to see which values belong to which player and returns a boolean on whether or not a winner (someone connected 3 spots)
     * is made.
     */

    public static boolean checkWinner(char[][] board, char player) 
    {

    	// This for loop checks each row and checks if a player has won from a horizontal connection
        for (int i = 0; i < 3; i++) 
        {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) 
            {
                return true;
            }
        }

        // This for loop checks each column and checks if a player has won from a vertical connection
        for (int j = 0; j < 3; j++) 
        {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) 
            {
                return true;
            }
        }

        // These if statements check each diagonal and check if a player has won from a diagonal connection
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) 
        {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) 
        {
            return true;
        }

        return false;
    }
}
