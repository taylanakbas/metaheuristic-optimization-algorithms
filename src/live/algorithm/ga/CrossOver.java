package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

/**
 * @author taylanakbas
 **/
public interface CrossOver {
    EvaluatedSolution apply(OptimizationProblem problem, EvaluatedSolution parent1, EvaluatedSolution parent2);
}
