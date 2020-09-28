package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

import java.util.ArrayList;

/**
 * @author taylanakbas
 **/
public interface ParentSelector {
    ArrayList<EvaluatedSolution> selectParents(OptimizationProblem problem, Population population);
}
