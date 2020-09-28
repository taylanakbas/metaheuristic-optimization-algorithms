package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

/**
 * @author taylanakbas
 **/
public interface Mutation {
    EvaluatedSolution apply(OptimizationProblem problem, EvaluatedSolution solution);
}
