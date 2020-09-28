package live.algorithm;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

public interface TerminalCondition {
    boolean isSatisfied(Metaheuristic metaheuristic, OptimizationProblem problem, EvaluatedSolution solution);
    void init(OptimizationProblem problem);
}
