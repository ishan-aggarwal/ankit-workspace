package assignment;

import java.util.List;

public class CellMoveUp extends Cell implements Movable {

    private static final int FOUR = 4;

    public CellMoveUp(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
    }

    /**
     *
     * @param otherSubclass
     */
    public CellMoveUp(CellDivide otherSubclass) {
        super(otherSubclass);
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "^";
    }

    /**
     *
     * @param neighbors
     * @return
     */
    public boolean checkApoptosis(List<Cell> neighbors) {
        return neighbors.size() != FOUR;
    }

    @Override
    public Cell newCellCopy() {
        return new CellMoveUp(this.currRow, this.currCol, this.mass);
    }

    @Override
    public int[] getMove() {
        int arr[] = {-1,0};
        return arr;
    }
}
