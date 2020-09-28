package live.base;

public interface OptimizationProblem {
    double objective (Solution s );
    boolean isFeasible( Solution s);
    boolean isMinimisation();
}
