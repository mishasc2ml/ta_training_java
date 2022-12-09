package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        degrees = (degrees + 360) % 360;
        switch (degrees) {
            case 0:
                return N;
            case 45:
                return NE;
            case 90:
                return E;
            case 135:
                return SE;
            case 180:
                return S;
            case 225:
                return SW;
            case 270:
                return W;
            case 315:
                return NW;
            default:
                return null;
        }
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = (degrees + 360) % 360;
        if (degrees == 0) {
            return N;
        }
        if (degrees > 0) {
            if ((N.degrees + NE.degrees) / 2 > degrees) return N;
            if ((NE.degrees + E.degrees) / 2 > degrees) return NE;
            if ((E.degrees + SE.degrees) / 2 > degrees) return E;
            if ((SE.degrees + S.degrees) / 2 > degrees) return SE;
            if ((S.degrees + SW.degrees) / 2 > degrees) return S;
            if ((SW.degrees + W.degrees) / 2 > degrees) return SW;
            if ((W.degrees + NW.degrees) / 2 > degrees) return W;
            return NW;
        } else {
            if ((N.degrees + NE.degrees) / 2 < degrees) return N;
            if ((NE.degrees + E.degrees) / 2 < degrees) return NE;
            if ((E.degrees + SE.degrees) / 2 < degrees) return E;
            if ((SE.degrees + S.degrees) / 2 < degrees) return SE;
            if ((S.degrees + SW.degrees) / 2 < degrees) return S;
            if ((SW.degrees + W.degrees) / 2 < degrees) return SW;
            if ((W.degrees + NW.degrees) / 2 < degrees) return W;
            return NE;
        }
    }

    public Direction opposite() {
        switch (this) {
            case N:
                return S;
            case NE:
                return SW;
            case E:
                return W;
            case SE:
                return NW;
            case S:
                return N;
            case SW:
                return NE;
            case W:
                return E;
            case NW:
                return SE;
            default:
                return null;
        }
    }

    public int differenceDegreesTo(Direction direction) {
        if (Math.abs(this.degrees - direction.degrees) > 180) {
            return 360 - Math.abs(this.degrees - direction.degrees);
        } else return Math.abs(this.degrees - direction.degrees);
    }
}
