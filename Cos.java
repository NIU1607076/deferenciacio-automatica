public class Cos implements Expression {
    private Expression expr;
    
    public Cos(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = expr.evaluate(dn);
        return new DualNumber(Math.cos(dn1.u), -dn1.uprime * Math.sin(dn1.u));
    }
}