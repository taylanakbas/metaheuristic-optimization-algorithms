package live.algorithm.sa;
/**
 * author:taylanakbas
 **/

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

import java.util.ArrayList;

public interface NeighborGenerator {
    ArrayList<EvaluatedSolution> generate(OptimizationProblem problem, EvaluatedSolution solution);
}
