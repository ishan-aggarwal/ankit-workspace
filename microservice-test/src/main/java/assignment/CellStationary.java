package assignment;

import java.util.List;

public class CellStationary extends Cell {

    private static final int SEVEN = 7;
    private static final int THREE = 3;

    /**
     *
     * @param currRow
     * @param currCol
     * @param mass
     */
    public CellStationary(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
    }

    /**
     *
     * @param otherSubclass
     */
    public CellStationary(CellDivide otherSubclass) {
        super(otherSubclass);
    }

    /**
     *
     * @return
     */
    public String toString() {
        return ".";
    }

    /**
     *
     * @param neighbors
     * @return
     */
    public boolean checkApoptosis(List<Cell> neighbors) {
        int size = neighbors.size();
        return size >= THREE && size <=SEVEN;
    }

    @Override
    public Cell newCellCopy() {
        return new CellMoveUp(this.currRow, this.currCol, this.mass);
    }

}
