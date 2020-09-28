package live.base;

public interface EvaluatedSolution {

    Solution getSolution();
    double getCost();
    EvaluatedSolution clone();
}
