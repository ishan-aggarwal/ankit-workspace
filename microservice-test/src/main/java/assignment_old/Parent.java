package assignment_old;

public class Parent {

    protected static int count = 0;
    public Parent() {
        count++;
    }
    public int getCount() {
        return count++;
    }
}
