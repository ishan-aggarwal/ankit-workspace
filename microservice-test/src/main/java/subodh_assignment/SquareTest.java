package subodh_assignment;

import java.util.ArrayList;
import java.util.List;

public class SquareTest {

    public static boolean find(ArrayList<Square> list, Square sq) {
        for(int i =0;i<list.size();i++) {
            if(sq.equals(list.get(i))) {
                return  true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Square square = new Square();
        ArrayList<Square> list = new ArrayList<>();
        list.add(square);

        System.out.println(find(list, null));
    }
}

class Square {

}
