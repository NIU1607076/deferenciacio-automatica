import java.util.*;

public class Main {
    private static double f(double x) {
        return Math.sin(Math.PI / 2.0 + x * x);
    }

    private static double df(double x) {
        return Math.cos(Math.PI / 2.0 + x * x) * 2 * x;
    }

    public static void main(String[] args) {
        Expression x = new X();
        Expression expr = new Sin(new Add(new Constant(Math.PI / 2.0),
                new Multiply(x, x)));
        double x0 = 4.0;
        DualNumber res = expr.evaluate(new DualNumber(x0, 1.0));
        double valorReal = f(x0);
        double derivadaReal = df(x0);
        System.out.println("real");
        System.out.println("f(" + x0 + ") = " + valorReal);
        System.out.println("f'(" + x0 + ") = " + derivadaReal);
        System.out.println("calculat");
        System.out.println("f(" + x0 + ") = " + res.u);
        System.out.println("f'(" + x0 + ") = " + res.uprime);
        System.out.println("diferencia valor "
                + (valorReal - res.u));
        System.out.println("diferencia derivada "
                + (derivadaReal - res.uprime));
        System.out.println("derivada per diferencies finites");
        final double[] epsilons = { 1e-6, 1e-8, 1e-10, 1e-12 };
        for (int i = 0; i < epsilons.length; i++) {
            double derivadaDifFinites = (f(x0 + epsilons[i]) - f(x0)) / epsilons[i];
            System.out.println("per epsilon " + epsilons[i] + "," + derivadaDifFinites + "," + "diferencia "
                    + (derivadaReal - derivadaDifFinites));
        }
    }
}