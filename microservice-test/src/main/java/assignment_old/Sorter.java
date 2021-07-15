package assignment_old;

import java.util.Locale;
import java.util.ResourceBundle;

public class Sorter {

    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", new Locale("zh","CN"));
        System.out.println(bundle.containsKey("name"));

    }
}
