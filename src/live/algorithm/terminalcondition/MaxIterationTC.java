package live.algorithm.terminalcondition;

import live.algorithm.Metaheuristic;
import live.algorithm.TerminalCondition;
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

public class MaxIterationTC implements TerminalCondition {

    private long maxIterationCount;
    public MaxIterationTC(long maxIterationCount){ this.maxIterationCount = maxIterationCount; }

    @Override
    public boolean isSatisfied(Metaheuristic metaheuristic, OptimizationProblem problem, EvaluatedSolution solution) {
        Iterative iterativeAlgorithm = (Iterative) metaheuristic;
        long iterationCount = iterativeAlgorithm.getIterationCount();
        return (iterationCount >= maxIterationCount);
    }
    @Override
    public void init(OptimizationProblem problem) {

    }
}
