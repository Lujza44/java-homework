package cz.cuni.mff.milotovl.util;

import java.util.List;

public class Calc {
    private String inToPost(String expr) {
        return expr;
    }
    private double evalPost(String expr) {
        return 0;
    }
    public String execute(String expr) throws IllegalArgumentException {
        try {
            String postExpr = inToPost(expr);
            double result = evalPost(postExpr);
            return String.format("%.5f", result);
        } catch (Exception e) {
            throw new IllegalArgumentException("Nevalidny vyraz.", e);
        }
    }

    private List<Token> tokenize(String expr) {

        return List.of();
    }
}

interface Token {

}