package com.epam.rd.autotasks.figures;

import static java.lang.Math.min;

class Triangle extends Figure {
    private final Point A;
    private final Point B;
    private final Point C;


    public Triangle(Point a, Point b, Point c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    @Override
    public double area() {
        return Math.abs((B.getX() - A.getX()) * (C.getY() - A.getY()) - (C.getX() - A.getX()) * (B.getY() - A.getY())) / 2;
    }

    @Override
    public String pointsToString() {
        return "(" + A.toString() + ")" + "(" + B.toString() + ")" + "(" + C.toString() + ")";
    }

    @Override
    public Point leftmostPoint() {
        double smallest = Math.min(min(A.getX(), B.getX()), C.getX());
        if (smallest == A.getX()) return A;
        else if (smallest == B.getX()) return B;
        else return C;

    }
}
