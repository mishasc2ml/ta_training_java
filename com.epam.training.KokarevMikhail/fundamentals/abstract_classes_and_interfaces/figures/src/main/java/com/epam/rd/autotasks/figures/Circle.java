package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point A;
    private final double r;

    public Circle(Point A, double r) {
        this.A = A;
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public String pointsToString() {
        return "(" + A.toString() + ")";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(A.getX() - r, A.getY());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + r + "]";
    }
}
