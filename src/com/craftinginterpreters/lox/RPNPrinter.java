package com.craftinginterpreters.lox;

public class RPNPrinter implements Expr.Visitor<String> {
    public String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        StringBuilder result = new StringBuilder();
        result.append(expr.left.accept(this));
        result.append(expr.right.accept(this));
        result.append(expr.operator.lexeme);


        return result.toString();
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return "("  + expr.expression.accept(this) + ")";
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) {
            return "nil";
        }

        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        StringBuilder result = new StringBuilder();
        result.append(expr.rigth.accept(this));
        result.append(expr.operator.lexeme);

        return result.toString();
    }


    public static void main(String[] args) {

        Expr one = new Expr.Literal(
                1
        );
        Expr two = new Expr.Literal(
                2
        );
        Expr three = new Expr.Literal(
                3
        );
        Expr four = new Expr.Literal(
                4
        );


        Expr leftSum = new Expr.Binary(
                one,
                new Token(TokenType.PLUS, "+", null, 1),
                two
        );
        Expr grp1 = new Expr.Grouping(
                leftSum
        );

        Expr rightSubt = new Expr.Binary(
                three,
                new Token(TokenType.MINUS, "-", null, 1),
                four
        );

        Expr grp2 = new Expr.Grouping(
                rightSubt
        );

        Expr mult = new Expr.Binary(
                grp1,
                new Token(TokenType.STAR, "*", null, 1),
                grp2
        );

        System.out.println(new RPNPrinter().print(mult));

    }
}
