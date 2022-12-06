package com.epam.rd.autotasks.arithmeticexpressions;


public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value < 0) return "(" + value + ")";
                else return "" + value;
            }
        };
    }

    public static Expression sum(Expression... members) {
        return new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression member : members) {
                    sum += member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String res = "(";
                for (int i = 0; i < members.length - 1; i++) {
                    res = res + members[i].toExpressionString() + " + ";
                }
                res = res + members[members.length - 1].toExpressionString() + ")";
                return res;
            }
        };
    }

    public static Expression product(Expression... members) {
        return new Expression() {
            @Override
            public int evaluate() {
                int product = 1;
                for (Expression member : members) {
                    if (member.evaluate() != 0) product *= member.evaluate();
                }
                return product;
            }

            @Override
            public String toExpressionString() {
                String res = "(";
                for (int i = 0; i < members.length - 1; i++) {
                    res = res + members[i].toExpressionString() + " * ";
                }
                res = res + members[members.length - 1].toExpressionString() + ")";
                return res;
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor) {
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
    }
}
