package live.algorithm;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

public interface UpdateStrategy {
    EvaluatedSolution getNextSolution(OptimizationProblem problem, EvaluatedSolution solution);
}
