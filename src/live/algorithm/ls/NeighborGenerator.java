package live.algorithm.ls;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

import java.util.ArrayList;

public interface NeighborGenerator {
    ArrayList<EvaluatedSolution> generate(OptimizationProblem problem, EvaluatedSolution solution);
}
