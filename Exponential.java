public class Exponential implements Expression {
    private Expression expr;
    
    public Exponential(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        dn1 = expr.evaluate(dn);
        return new DualNumber(Math.exp(dn1.u), dn1.uprime * Math.exp(dn1.u));
    }
}