package live.base;

public class SimpleEvaluatedSolution implements EvaluatedSolution {

    Solution solution;
    double cost;

    public  SimpleEvaluatedSolution(Solution solution, double cost){
        this.solution = solution;
        this.cost = cost;
    }

    @Override
    public Solution getSolution() {
        return solution;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public EvaluatedSolution clone() {
        return new SimpleEvaluatedSolution(solution.clone(),cost);
    }
    @Override
    public String toString() {
        return solution + " : " + cost;
    }
}
