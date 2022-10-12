public class Exponential implements Expression {
    private Expression expr;
    
    public Exponential(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(Math.exp(dn.u), dn.uprime * Math.exp(dn.u));
    }
}