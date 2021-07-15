package assignment;

import java.util.List;

public class CellDivide extends Cell implements Divisible {

    public int direction;
    private static final int THREE = 3;
    private static final int ONE = 1;

    /**
     *
     * @param currRow
     * @param currCol
     * @param mass
     */
    public CellDivide(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
        this.direction = ONE;
    }

    /**
     *
     * @param otherSubclass
     */
    public CellDivide(CellDivide otherSubclass) {
        super(otherSubclass);
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "+";
    }

    /**
     *
     * @param neighbors
     * @return
     */
    public boolean checkApoptosis(List<Cell> neighbors) {
        return neighbors.size() == THREE;
    }

    @Override
    public Cell newCellCopy() {
        return new CellMoveUp(this.currRow, this.currCol, this.mass);
    }

    @Override
    public int[] getDivision() {
        int arr[] = {};
        switch (direction) {
            case 1:
                arr = new int[]{};
                direction = 2;
                break;
            case 2:
                arr = new int[]{};
                direction = 3;
                break;
            case 3:
                arr = new int[]{};
                direction = 0;
                break;
            default:
        }
        return arr;
    }
}
