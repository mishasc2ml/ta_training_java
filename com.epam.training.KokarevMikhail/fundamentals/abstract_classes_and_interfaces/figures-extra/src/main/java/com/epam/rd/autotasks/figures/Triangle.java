package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Triangle extends Figure {
    private final Point A;
    private final Point B;
    private final Point C;
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(Point a, Point b, Point c) {
            this.A = a;
            this.B = b;
            this.C = c;

        if (isNull() && isDegen() && area() != 0) {
            this.side1 = length(a, b);
            this.side2 = length(b, c);
            this.side3 = length(c, a);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return new Point((A.getX() + B.getX() + C.getX()) / 3, (A.getY() + B.getY() + C.getY()) / 3);
    }
    @Override
    public boolean isTheSame(Figure figure) {
        if (this.getClass() == figure.getClass()){
            return this.A == ((Triangle) figure).A && this.B == ((Triangle) figure).B && this.C == ((Triangle) figure).C;
        }
        return false;
    }

    double length(Point A, Point B) {
        return sqrt((A.getX() - B.getX()) * (A.getX() - B.getX()) + (A.getY() - B.getY()) * (A.getY() - B.getY()));
    }

    private boolean isDegen() {
        return side1 >= side3 + side2 || side3 >= side1 + side2 || side2 >= side1 + side3;
    }

    public double area() {
        return Math.abs((B.getX() - A.getX()) * (C.getY() - A.getY()) - (C.getX() - A.getX()) * (B.getY() - A.getY())) / 2;
    }

    private boolean isNull(){
        return A != null && B != null && C != null;
    }
}
