package test;

public class Output {

    //main method to print the result on the console
    public static void main(String[] args) {

        //creating object of sphere class
        Sphere sphere = new Sphere(10);

        //printing volume of the sphere
        System.out.println("Volume of Sphere with radius "+ sphere.getRadius()+" is "
                + Math.round(sphere.calcVolume()  * 100.0) / 100.0);

        //printing surface area of the sphere
        System.out.println("Surface area of Sphere with radius "+ sphere.getRadius()+" is "
                +  + Math.round(sphere.calcSurfaceArea()  * 100.0) / 100.0);

        //creating object of pyramid class
        Pyramid pyramid = new Pyramid(230,140);

        //printing volume of the Pyramid
        System.out.println("Volume of Pyramid with base "+ pyramid.getBase()+
                " and height "+pyramid.getHeight()+
                " is "+Math.round(pyramid.calcVolume()  * 100.0) / 100.0);

        //printing surface area of the Pyramid - rounding up the decimal places
        System.out.println("Surface area of Pyramid with base "+ pyramid.getBase()+
                " and height "+pyramid.getHeight()+
                " is "+ Math.round(pyramid.calcSurfaceArea()  * 100.0) / 100.0);

    }
}
