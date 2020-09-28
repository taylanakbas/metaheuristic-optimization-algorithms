package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

import java.util.ArrayList;

/**
 * @author taylanakbas
 **/
public interface Replacement {
    void replace(OptimizationProblem problem, Population population, ArrayList<EvaluatedSolution> offsprings);

}
