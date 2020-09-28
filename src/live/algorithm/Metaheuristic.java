package live.algorithm;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

public interface Metaheuristic {
    EvaluatedSolution solve(OptimizationProblem problem);
}
