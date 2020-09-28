package live.problems.tsp;
/**
 * author:taylanakbas
 **/
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

public interface SolutionGenerator {
    EvaluatedSolution generate(OptimizationProblem problem);
}
