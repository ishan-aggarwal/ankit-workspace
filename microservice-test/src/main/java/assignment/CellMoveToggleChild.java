package assignment;

import java.util.List;

public class CellMoveToggleChild extends CellMoveToggle {

    public static int numAlive;
    private static final int TEN = 10;
    /**
     *
     * @param currRow
     * @param currCol
     * @param mass
     */
    public CellMoveToggleChild(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
        numAlive++;
    }

    /**
     *
     * @param otherSubclass
     */
    public CellMoveToggleChild(CellDivide otherSubclass) {
        super(otherSubclass);
        numAlive++;
    }

    /**
     *
     * @param neighbors
     * @return
     */
    public boolean checkApoptosis(List<Cell> neighbors) {
        return super.checkApoptosis(neighbors) && numAlive < TEN;
    }

    @Override
    public void apoptosis() {
        super.apoptosis();
        numAlive--;
    }

    @Override
    public Cell newCellCopy() {
        return new CellMoveUp(this.currRow, this.currCol, this.mass);
    }
}
