public class Logarithm implements Expression {
    private Expression expr;
    
    public Logarithm(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(Math.log(dn.u), dn.uprime / dn.u);
    }
}