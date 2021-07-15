package test;

import java.util.ArrayList;
import java.util.List;

public class InstaPost {

    private List<InstaItem> items = new ArrayList<>();



    public void add(InstaItem instaItem) {
        this.items.add(instaItem);
    }



    public void printAll() {

        for(InstaItem item : this.items) {
            System.out.println(item.toString());
        }

    }



}




