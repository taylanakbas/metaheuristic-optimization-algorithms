package live.problems.production;

import live.base.OptimizationProblem;
import live.base.EvaluatedSolution;

public interface SolutionGenerator {
    EvaluatedSolution generate(OptimizationProblem problem);
}
