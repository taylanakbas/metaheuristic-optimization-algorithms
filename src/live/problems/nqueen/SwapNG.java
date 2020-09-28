package live.problems.nqueen;

import live.algorithm.ls.NeighborGenerator;
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.base.SimpleEvaluatedSolution;

import java.util.ArrayList;

public class SwapNG implements NeighborGenerator {
    @Override
    public ArrayList<EvaluatedSolution> generate(OptimizationProblem problem, EvaluatedSolution solution) {
        ArrayList<EvaluatedSolution> evaluatedSolutions = new ArrayList<>();
        Permutation p = (Permutation) solution.getSolution().clone();
        for (int i = 0; i < p.length(); i++) {
            for (int j = i+1; j < p.length() ; j++) {
                Permutation newP = (Permutation) p.clone();
                newP.swap(i,j);
                evaluatedSolutions.add(new SimpleEvaluatedSolution(newP, problem.objective(newP)));
            }
        }
        return evaluatedSolutions;
    }
}
