public class DualNumber{
    double u;
    double uprime;

    public DualNumber(double u, double uprime){
        this.u = u;
        this.uprime = uprime;
    }

    @Override
    public String toString() {
        return "u: " + this.u + ", u': " + this.uprime + "\n";
    }
}