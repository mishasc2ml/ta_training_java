package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point A;
    private final double r;

    public Circle(Point A, double r) {
        this.A = A;
        this.r = r;

        if (A != null && r > 0 && area() != 0) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public Point centroid() {
        return A;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this.getClass() == figure.getClass()) {
            return Math.abs(this.A.getX() - ((Circle) figure).A.getX()) < 0.001 && Math.abs(this.A.getY() - ((Circle) figure).A.getY()) < 0.001 &&
                    Math.abs(this.r - ((Circle) figure).r) < 0.001;
        }
        return false;
    }
}
