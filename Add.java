public class Add extends BinaryOperator {
    public Add(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }
    
    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = left.evaluate(dn);
        DualNumber dn2 = right.evaluate(dn);
        return new DualNumber(dn1.u + dn2.u, dn1.uprime + dn2.uprime);
    }
}