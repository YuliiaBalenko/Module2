package task1;

public class Test {

    public static void main(String[] args) {
        try {
            Point A = new Point(5, 3);
            Point B = new Point(7, 5);
            Point C = new Point(5, 3);
            System.out.println("The area of triangle: " + Triangle.area(A, B, C));
        } catch (TriangleException e) {
            System.out.println("Can't calculate triangle area");
        }
    }
}
