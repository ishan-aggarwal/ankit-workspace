package assignment;

import java.util.List;

public class CellMoveToggle extends CellMoveUp {

    public boolean toggled;
    private static final int TWO = 2;
    private static final int FIVE = 5;
    /**
     *
     * @param currRow
     * @param currCol
     * @param mass
     */
    public CellMoveToggle(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
        this.toggled = true;
    }

    /**
     *
     * @param otherSubclass
     */
    public CellMoveToggle(CellDivide otherSubclass) {
        super(otherSubclass);
    }

    /**
     *
     * @return
     */
    public String toString() {
        return this.toggled ? "T" : "t";
    }

    /**
     *
     * @param neighbors
     * @return
     */
    public boolean checkApoptosis(List<Cell> neighbors) {
        int size = neighbors.size();
        return size < TWO || size > FIVE;
    }
    @Override
    public Cell newCellCopy() {
        return new CellMoveUp(this.currRow, this.currCol, this.mass);
    }

    @Override
    public int[] getMove() {
        if(toggled) {
            int arr[] = {-1,0};
            return arr;
        }
        toggled = !toggled;
        return null;
    }
}
