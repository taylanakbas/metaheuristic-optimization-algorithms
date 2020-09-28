package live.algorithm.ga;

import live.base.OptimizationProblem;

/**
 * @author taylanakbas
 **/
public interface InitialPopulationGenerator {
    Population generate(OptimizationProblem problem, int populationSize);
}
