package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Quadrilateral extends Figure {
    private final Point A;
    private final Point B;
    private final Point C;
    private final Point D;
    private final double side1;
    private final double side2;
    private final double side3;
    private final double side4;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;


        if (isNull() && isConvex() && isDegen() && area() != 0) {
            this.side1 = length(a, b);
            this.side2 = length(b, c);
            this.side3 = length(c, d);
            this.side4 = length(d, a);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        Triangle ABC = new Triangle(A, B, C);
        Triangle ABD = new Triangle(A, B, D);
        Triangle ACD = new Triangle(A, C, D);
        Triangle CBD = new Triangle(C, B, D);

        Segment firstSegment = new Segment(ABD.centroid(), CBD.centroid());
        Segment secondSegment = new Segment(ACD.centroid(), ABC.centroid());

        return firstSegment.intersection(secondSegment);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this.getClass() == figure.getClass()) {
            return Math.abs(Math.abs(area() - ((Quadrilateral) figure).area())) < 0.001 &&
                    Math.abs(centroid().getX() - figure.centroid().getX()) < 0.001 &&
                    Math.abs(centroid().getY() - figure.centroid().getY()) < 0.001;
        }
        return false;
    }

    public double area() {
        return Math.abs((A.getX() - B.getX()) * (A.getY() + B.getY()) + (B.getX() - C.getX()) * (B.getY()
                + C.getY()) + (C.getX() - D.getX()) * (C.getY() + D.getY()) + (D.getX() - A.getX())
                * (D.getY() + A.getY())) / 2;
    }

    double length(Point A, Point B) {
        return sqrt((A.getX() - B.getX()) * (A.getX() - B.getX()) + (A.getY() - B.getY()) * (A.getY() - B.getY()));
    }

    private boolean isNull() {
        return A != null && B != null && C != null && D != null;
    }

    private boolean isDegen() {
        return side1 >= side3 + side2 + side4 || side3 >= side1 + side2 + side4 || side2 >= side1 + side3 + side4 ||
                side4 >= side1 + side2 + side3;
    }

    private boolean isConvex() {
        double areaABC = new Triangle(A, B, C).area();
        double areaADC = new Triangle(A, D, C).area();
        double areaABD = new Triangle(A, B, D).area();
        double areaCBD = new Triangle(C, B, D).area();
        return areaABC + areaADC == areaABD + areaCBD;
    }

    static class Segment {

        private final double k;
        private final double b;

        private final double x1;
        private final double y1;
        private final double x2;
        private final double y2;

        public Segment(Point start, Point end) {

            if (start == null || end == null) {
                throw new IllegalArgumentException();
            }
            if (start.getX() == end.getX() && start.getY() == end.getY()) {
                throw new IllegalArgumentException();
            }


            // get coordinates
            this.x1 = start.getX();
            this.x2 = end.getX();
            this.y1 = start.getY();
            this.y2 = end.getY();

            this.k = (end.getY() - start.getY()) / (end.getX() - start.getX());
            this.b = end.getY() - k * end.getX();

        }

        Point intersection(Segment another) {

            if (another.b == this.b && another.k == this.k) {
                return null;
            }

            if (another.b != this.b && another.k == this.k) {
                return null;
            }

            double x = (another.b - this.b) / (this.k - another.k);
            double y = this.k * x + this.b;

            if (x < Math.min(another.x1, another.x2) || y < Math.min(another.y1, another.y2) ||
                    x > Math.max(another.x1, another.x2) || y > Math.max(another.y1, another.y2)) {
                return null;
            }

            if (x < Math.min(this.x1, this.x2) || y < Math.min(this.y1, this.y2) ||
                    x > Math.max(this.x1, this.x2) || y > Math.max(this.y1, this.y2)) {
                return null;
            }
            return new Point(x, y);
        }
    }
}

