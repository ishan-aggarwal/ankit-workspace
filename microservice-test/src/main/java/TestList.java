import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class TestList {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ank");
        list.add(0,"abc");
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
}
