package yomi;

public class InterviewedExample {

    private static abstract class Shape {
        public void printMe() {
            System.out.println("I am a shape");
        }
        public abstract double computeArea();
    }

    private static class Circle extends Shape {

        private double rad = 10;

        public void printMe() {
            System.out.println("I am a circle");
        }
        public  double computeArea(){
            return rad*rad*3.14;
        }
    }

    private static class Ambiguous extends Shape {

        private double area = 10;
        private String printMe = "I am ambiguous";

        public void printMe(String printMe) {
            System.out.println(this.printMe);
        }
        public  double computeArea(){
            return area;
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        Circle circle = new Circle();
        Ambiguous ambiguous = new Ambiguous();

        shapes[0] = circle;
        shapes[1] = ambiguous;

        for(Shape s : shapes) {
            s.printMe();
            System.out.println(s.computeArea());
        }

        ambiguous.printMe("I am a square");
    }

}
