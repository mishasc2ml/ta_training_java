package com.epam.rd.autotasks.segments;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private final double k;
    private final double b;
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    public Segment(Point start, Point end) {
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

    double length() {
        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }

    Point middle() {
        return new Point((x1 + x2) / 2, (y1 + y2) / 2);
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
