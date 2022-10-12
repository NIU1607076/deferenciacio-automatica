public class Sin implements Expression {
    private Expression expr;
    
    public Sin(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(Math.sin(dn.u), dn.uprime * Math.cos(dn.u));
    }
}