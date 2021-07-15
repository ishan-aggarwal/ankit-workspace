package raul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfList {

    public static void main(String[] args) {
        Integer[][] islandGrid = new Integer[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0},
                {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};

//        islandGrid = new char[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
//                { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };

        List<List<Integer>> list = new ArrayList();
        for (Integer[] array : islandGrid) {
            //This will add int values into the new list
            // and that list will added to the main list
            list.add(Arrays.asList(array));
        }
        System.out.println(list);
    }
}
