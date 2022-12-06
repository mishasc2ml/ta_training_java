package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;

class Triangle {
    private final Point A;
    private final Point B;
    private final Point C;
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(Point a, Point b, Point c) {
        this.side1 = length(a, b);
        this.side2 = length(b, c);
        this.side3 = length(c, a);

        if (side1 >= side3 + side2 || side3 >= side1 + side2 || side2 >= side1 + side3) {
            throw new IllegalArgumentException();
        }
        this.A = a;
        this.B = b;
        this.C = c;
    }

    double length(Point A, Point B) {
        return sqrt((A.getX() - B.getX()) * (A.getX() - B.getX()) + (A.getY() - B.getY()) * (A.getY() - B.getY()));
    }

    public double area() {
        double semiPer = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPer * (semiPer - side1) * (semiPer - side2) * (semiPer - side3));
    }

    public Point centroid() {
        return new Point((A.getX() + B.getX() + C.getX()) / 3, (A.getY() + B.getY() + C.getY()) / 3);
    }
}

