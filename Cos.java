public class Cos implements Expression {
    private Expression expr;
    
    public Cos(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(Math.cos(dn.u), -dn.uprime * Math.sin(dn.u));
    }
}