package isaiah.project3;

import java.awt.*;
import javax.swing.*;

public class Pattern extends JComponent
{
    public static final int GRID_SIZE = 20;
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;

/*********************************************/
    /*                                           */
/**     MODIFY ONLY THE CODE BETWEEN        **/
/**       THESE COMMENT BLOCKS              **/
    /*                                           */
    /*  Change the boolean expression in line 39 */
    /*  Use one line for your expression         */
    /*                                           */
    /*  Fill in the comments with your solutions */
    /*    to Questions 1-9.                      */
    /*                                           */
    /*********************************************/

    public boolean fill(int row, int column)
    {
        // Change the Boolean expression to produce
        //        different patterns

        // Q0:  return !(row == 0 && column == 0);

        //return true if either row=0 or column=0
        // Q1:  return (row == 0 || column == 0);

        //return true if row == column
        // Q2;  return  (row == column);

        //return true if row number is even
        // Q3:  return (row%2 == 0);

        //return true if column is odd
        // Q4:  return !(column%2 == 0);

        //either (both row and column are even) or (both column and row are odd)
        // Q5:  return (row%2 == 0 && column%2 == 0) || (!(row%2 == 0) && !(column%2 == 0))

        //return false if both row and column are odd
        //no color when both row and column are odd
        // Q6:  return !(!(row%2 == 0) && !(column%2 == 0));

        // referring to total number of rows
        // Q7: return row >= ((ROWS/2)-2) && row<=((ROWS/2)+1)


        // Q8:  return (row >= ((ROWS/2)-2) && row<=((ROWS/2)+1)) &&
        //            (column >= ((COLUMNS/2)-2) && column<=((COLUMNS/2)+1));

        // making an 'X' pattern
        // Q9:  return (row == column) || (row+column == ROWS-1);

        return (row == column) || (row+column == ROWS-1);
    }

/*********************************************/
    /*                                           */
/**     MODIFY ONLY THE CODE BETWEEN        **/
/**       THESE COMMENT BLOCKS              **/
    /*                                           */
    /*********************************************/

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor (Color.RED);
        Pattern pattern = new Pattern ();
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLUMNS; j++)
            {
                if (pattern.fill(i, j))
                {
                    g2.fill(new Rectangle (
                            j * GRID_SIZE, i * GRID_SIZE,
                            GRID_SIZE - 1, GRID_SIZE - 1));
                }
            }
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension (GRID_SIZE * COLUMNS,
                GRID_SIZE * ROWS);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame ();
        frame.add(new Pattern ());
        frame.pack ();
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setVisible (true);
    }
}
