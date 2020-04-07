package task2_1;

public class Test {

    public static void main(String[] args) {
        Area ar = new Area();

        //Rectangle test
        double length = 10;
        double breadth = 5;
        System.out.println("Rectangle length = " + length +  " and breadth = " + breadth + "\nRectangle area: " + ar.rectangleArea(length, breadth) + "\n");

        //Square test
        double side = 7;
        System.out.println("Square side = " + side + "\nSquare area: " + ar.squareArea(side) + "\n");

        //Circle test
        double radius = 5;
        System.out.println("Circle radius = " + radius + "\nCircle area: " + ar.circleArea(radius) + "\n");

    }
}