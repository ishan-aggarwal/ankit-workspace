package assignment;

import java.util.List;

public class CellMoveDiagonal extends CellMoveUp {

    public boolean orientedRight;
    public int diagonalMoves;
    private static final int ZERO = 0;
    private static final int THREE = 3;
    /**
     *
     * @param currRow
     * @param currCol
     * @param mass
     */
    public CellMoveDiagonal(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
        this.orientedRight = true;
        this.diagonalMoves = ZERO;
    }

    /**
     *
     * @param otherSubclass
     */
    public CellMoveDiagonal(CellDivide otherSubclass) {
        super(otherSubclass);
    }

    /**
     *
     * @return
     */
    public String toString() {
        return this.orientedRight ? "/" : "\\";
    }

    /**
     *
     * @param neighbors
     * @return
     */
    public boolean checkApoptosis(List<Cell> neighbors) {
        return neighbors.size() > THREE;
    }

    @Override
    public Cell newCellCopy() {
        return new CellMoveUp(this.currRow, this.currCol, this.mass);
    }

    @Override
    public int[] getMove() {
        int arr[];
        if(orientedRight) {
            arr = new int[]{-1,1};
        } else {
            arr = new int[]{-1,-1};
        }
        diagonalMoves++;
        if(diagonalMoves % 4 == 0) {
            orientedRight = !orientedRight;
        }
        return arr;
    }
}
