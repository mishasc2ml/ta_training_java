package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private final Point A;
    private final Point B;
    private final Point C;
    private final Point D;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
    }

    @Override
    public double area() {
        return Math.abs((A.getX() - B.getX()) * (A.getY() + B.getY()) + (B.getX() - C.getX()) * (B.getY()
                + C.getY()) + (C.getX() - D.getX()) * (C.getY() + D.getY()) + (D.getX() - A.getX())
                * (D.getY() + A.getY())) / 2;
    }

    @Override
    public String pointsToString() {
        return "(" + A.toString() + ")" + "(" + B.toString() + ")" + "(" + C.toString() + ")" + "(" + D.toString() + ")";
    }

    @Override
    public Point leftmostPoint() {
        double smallest = Math.min(Math.min(Math.min(A.getX(), B.getX()), C.getX()), D.getX());
        if (smallest == A.getX()) return A;
        else if (smallest == B.getX()) return B;
        else if (smallest == C.getX()) return C;
        else return D;
    }
}
