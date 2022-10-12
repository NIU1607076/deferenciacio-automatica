public class Power implements Expression {
    private Expression expr;
    private Expression k;
    
    public Power(Expression expr, Expression k) {
        this.expr = expr;
        this.k = k;
    }

    public DualNumber evaluate(DualNumber dn) {
        double u = Math.pow(dn.u, this.k.evaluate(dn).u);
        double uP = Math.pow(dn.u, new Substract(new Constant(this.k.evaluate(dn).u), new Constant(1)).evaluate(dn).u);

        Multiply aux = new Multiply(this.k, new Constant(dn.uprime));
        double uprime = new Multiply(aux, new Constant(uP)).evaluate(dn).u;

        return new DualNumber(u, uprime);
    }
}