public class Power implements Expression {
    private Expression expr;
    private Expression k;

    public Power(Expression expr, Expression k) {
        this.expr = expr;
        this.k = k;
    }

    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = expr.evaluate(dn);
        double u = Math.pow(dn1.u, this.k.evaluate(dn1).u);
        double uP = Math.pow(dn1.u, new Substract(new Constant(this.k.evaluate(dn1).u), new Constant(1)).evaluate(dn1).u);

        Multiply aux = new Multiply(this.k, new Constant(dn1.uprime));
        double uprime = new Multiply(aux, new Constant(uP)).evaluate(dn1).u;

        return dn1.u != 0 ? new DualNumber(u, uprime) : null;
    }
}
        //return new dn1.u != 0 ? DualNumber(Math.pow(dn1.u, k), k * Math.pow(k-1) * dn1.uprime) : 1; // Pongo 1 como un checker de errores.
