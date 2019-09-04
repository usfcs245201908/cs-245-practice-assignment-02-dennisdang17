// practice backtracking!
public class NQueens
{
    int size;
    int[][] board;
    public NQueens(int n)
    {
        this.size = n;
        this.board = new int[n][n];
    }
    
    public boolean canPlaceQueen(int row, int col)
    {
        for (int i = 0; i < col; i++)
        { 
            if (board[row][i] == 1) 
            {
                return false; 
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1)
            {
                return false;
            }
        }
                
        for (int i = row, j = col; j >= 0 && i < size; i++, j--) 
        {
            if (board[i][j] == 1)
            {
                return false; 
            }
        }

        return true;
    }
    
    public boolean placeNQueens() throws Exception
    {
        if (size<=0)
        {
            throw new Exception("Error!");
        }
        return placeQueens(0);
    }

    public boolean placeQueens(int col)
    {
        if (col>=size)
        {
            return true;
        }
        for (int row=0; row<size; row++)
        {
            if (canPlaceQueen(row,col))
            {
                board[row][col]=1;
                if (placeQueens(col+1))
                {
                    return true;
                }
                else
                {
                    board[row][col]=0;
                }
            }
        }
        return false;
    } 

    public void printToConsole()
    {
        for (int i=0; i<size; i++)
        {
            for(int j=0; j<size; j++)
            {
                if (board[i][j]==1)
                {
                    System.out.print(" Q " );
                }
                else
                {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
    }

}