public class Power implements Expression {
    private Expression expr;
    private int k;
    
    public Power(Expression expr, int k) {
        this.expr = expr;
        this.k = k;
    }

    public DualNumber evaluate(DualNumber dn) {
        // double u = Math.pow(dn.u, this.k.evaluate(dn).u);
        // double uP = Math.pow(dn.u, new Substract(new Constant(this.k.evaluate(dn).u), new Constant(1)).evaluate(dn).u);

        // Multiply aux = new Multiply(this.k, new Constant(dn.uprime));
        // double uprime = new Multiply(aux, new Constant(uP)).evaluate(dn).u;
        dn1 = expr.evaluate(dn);
        return new dn1.u != 0 ? DualNumber(Math.pow(dn1.u, k), k * Math.pow(k-1) * dn1.uprime) : 1; // Pongo 1 como un checker de errores.
    }
}