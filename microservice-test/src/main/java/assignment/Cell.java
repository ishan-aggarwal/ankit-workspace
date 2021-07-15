package assignment;

import java.util.List;

public abstract class Cell implements Comparable<Cell> {

    public int currRow;
    public int currCol;
    public int mass;

    private static final int ZERO = 0;
    private static final int MINUS_ONE = -1;

    /**
     *
     * @param currRow
     * @param currCol
     * @param mass
     */
    public Cell(int currRow, int currCol, int mass) {
        this.currRow = currRow >= ZERO ? currRow : ZERO;
        this.currCol = currCol >= ZERO ? currCol : ZERO;
        this.mass = mass >= ZERO ? mass : ZERO;
    }

    /**
     *
     * @param otherCell
     */
    public Cell(Cell otherCell) {
        this.currRow = otherCell.getCurrRow();
        this.currCol = otherCell.getCurrCol();
        this.mass = otherCell.getMass();
    }

    /**
     *
     */
    public void apoptosis() {
        this.currRow = MINUS_ONE;
        this.currCol = MINUS_ONE;
        this.mass = MINUS_ONE;
    }

    /**
     *
     * @return
     */
    public int getCurrRow() {
        return this.currRow;
    }

    /**
     *
     * @return
     */
    public int getCurrCol() {
        return this.currCol;
    }

    /**
     *
     * @return
     */
    public int getMass() {
        return this.mass;
    }

    /**
     *
     * @param newRow
     * @return
     */
    public boolean setCurrRow(int newRow) {
        if(newRow >= ZERO) {
            this.currRow = newRow;
        }
        return false;
    }

    /**
     *
     * @param newCol
     * @return
     */
    public boolean setCurrCol(int newCol) {
        if(newCol >= ZERO) {
            this.currCol = newCol;
        }
        return false;
    }

    /**
     *
     * @param newMass
     * @return
     */
    public boolean setMass(int newMass) {
        if(newMass >= ZERO) {
            this.mass = newMass;
        }
        return false;
    }

    /**
     *
     * @param neighbors
     * @return
     */
    public abstract boolean checkApoptosis(List<Cell> neighbors);

    public int compareTo(Cell otherCell) {
        if(this.mass == otherCell.getMass())
            return 0;
        else if(this.mass > otherCell.getMass())
            return 1;
        else
            return -1;
    }

    public abstract Cell newCellCopy();

}
