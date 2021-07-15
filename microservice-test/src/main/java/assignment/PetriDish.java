package assignment;

import java.util.ArrayList;
import java.util.List;

public class PetriDish {

    public Cell[][] dish;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    public List<Movable> movables;
    public List<Divisible> divisibles;

    /**
     *
     * @param board
     */
    public PetriDish(String[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                    String petri = board[i][j];
                    if("null".equals(petri)) {
                        continue;
                    } else {
                        String currentPetri[] = petri.split(" ");
                        String type = currentPetri[ZERO];
                        int mass = Integer.parseInt(currentPetri[ONE]);
                        switch (type) {
                            case "CellMoveUp":
                                this.dish[i][j]  = new CellMoveUp(i,j,mass);
                                break;
                            case "CellMoveToggle":
                                this.dish[i][j]  = new CellMoveToggle(i,j,mass);
                                break;
                            case "CellMoveToggleChild":
                                this.dish[i][j]  = new CellMoveToggleChild(i,j,mass);
                                break;
                            case "CellStationary":
                                this.dish[i][j]  = new CellStationary(i,j,mass);
                                break;
                            case "CellMoveDiagonal":
                                this.dish[i][j]  = new CellMoveDiagonal(i,j,mass);
                                break;
                            case "CellDivide":
                                this.dish[i][j]  = new CellDivide(i,j,mass);
                                break;
                            default:
                                break;
                        }
                    }
            }
        }
    }

    public List<Cell> getNeighborsOf(int row, int col) {
        List<Cell> list = new ArrayList<>();
        try {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    if (i != 0 && j != 0 && dish[row + i][col + j] != null) {
                        list.add(dish[row + i][col + j]);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
        return list;
    }

    public void move() {
        int row = dish.length;
        int col = dish[0].length;

        for(int i=0;i<row;i++) {
            for(int j=0;i<col;j++) {
                Cell cell = dish[i][j];
                if(cell instanceof Movable) {
                    int[] move = ((Movable) cell).getMove();
                    Cell newCell = dish[i+move[0]][j+move[1]];

                }
            }
        }
    }

    public void divide() {
        int row = dish.length;
        int col = dish[0].length;

        for(int i=0;i<row;i++) {
            for(int j=0;i<col;j++) {
                Cell cell = dish[i][j];
                if(cell instanceof Movable) {
                    int[] move = ((Movable) cell).getMove();
                    Cell newCell = dish[i+move[0]][j+move[1]];

                }
            }
        }
    }

    public void update() {
        int row = dish.length;
        int col = dish[0].length;
        for(int i=0;i<row;i++) {
            for (int j=0;i<col;j++) {
                Cell cell = dish[i][j];
                List<Cell> neighborsOf = getNeighborsOf(i, j);
                if(cell.checkApoptosis(neighborsOf)){
                    dish[i][j]=null;
                }
            }
        }
    }

    public void iterate() {
        //step1
        this.move();

        //step2
        this.divide();

        //step3
        this.update();
    }

}
