package olivia;

public class ObjectRef {

    public static void mystryA(int y, Point p) {
        y = y+p.y;
        p.x = p.x-y;

        System.out.println(y+" "+ p.x+ " "+ p.y);
    }

    public static void main(String[] args) {
        int y=3;
        Point p1 = new Point(5,7);
        mystryA(y,p1);
        System.out.println(y+" "+ p1.x+" "+ p1.y);

        Point p2 = new Point(-2,4);
        mystryA(y,p2);
        System.out.println(y+" "+ p2.x+" "+ p2.y);
    }
}

class Point {

    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}