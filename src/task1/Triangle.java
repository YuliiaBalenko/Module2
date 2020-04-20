package task1;

public class Triangle {
    private Point A;
    private Point B;
    private Point C;

    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double area() throws TriangleException {
        if ((A.equals(B) || A.equals(C) || B.equals(C)) ||
                (A.x == B.x && A.x == C.x) ||
                (A.y == B.y && A.y == C.y)) {
            throw new TriangleException();
        }

        // area = (Ax(By -Cy) + Bx(Cy -Ay) + Cx(Ay - By))/2
        double area = (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2;
        return Math.abs(area);
    }
}
