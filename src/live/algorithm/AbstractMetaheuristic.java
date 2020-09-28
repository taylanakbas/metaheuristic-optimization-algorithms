package live.algorithm;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

public abstract class AbstractMetaheuristic implements Metaheuristic {
    protected EvaluatedSolution bestSolution;

    protected void updateBest(OptimizationProblem problem, EvaluatedSolution currentSolution){
        if(bestSolution == null ||
                (problem.isMinimisation() && currentSolution.getCost() < bestSolution.getCost()) ||
                (!problem.isMinimisation() && currentSolution.getCost() > bestSolution.getCost()))
        {
            bestSolution = currentSolution.clone();
        }
    }
    @Override
    public EvaluatedSolution solve(OptimizationProblem problem) {
        init(problem);
        perform(problem);
        return bestSolution;
    }
    protected abstract void perform(OptimizationProblem problem);
    protected abstract void init(OptimizationProblem problem);

}
