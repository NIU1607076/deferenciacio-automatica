public class X implements Expression {
    public X() {
    }

    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(dn.u, 1.0);
    }
}