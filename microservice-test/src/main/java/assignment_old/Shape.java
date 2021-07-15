package assignment_old;

public class Shape {

    public static void main(String[] args) {
        Shape shape =new Quadrilateral();
        Quadrilateral quadrilateral = new Quadrilateral();

        //shape = quadrilateral;

        Triangle tri = (Triangle) shape;
    }
}

class Quadrilateral extends Shape {

}
class Triangle extends Shape {

}


