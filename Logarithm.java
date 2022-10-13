public class Logarithm implements Expression {
    private Expression expr;
    
    public Logarithm(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = expr.evaluate(dn);
        return dn1.u > 0 ? new DualNumber(Math.log(dn1.u), dn1.uprime / dn1.u) : null;
    }
}