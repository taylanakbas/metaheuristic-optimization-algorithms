package live.problems.tsp;
/**
 * author:taylanakbas
 **/
import live.algorithm.sa.NeighborGenerator;
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.base.SimpleEvaluatedSolution;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class RandomNG implements NeighborGenerator {
    @Override
    public ArrayList<EvaluatedSolution> generate(OptimizationProblem problem, EvaluatedSolution solution) {
        ArrayList<EvaluatedSolution> evaluatedSolutions = new ArrayList<>();
        Permutation p = (Permutation) solution.getSolution().clone();
        Random rnd = new SecureRandom();
        for (int i = 0; i < p.length(); i++) {
            Permutation newP = (Permutation) p.clone();
            int j = rnd.nextInt(p.length());
            if (j != i) newP.swap(i,j);
            else i -= 1;
            evaluatedSolutions.add(new SimpleEvaluatedSolution(newP, problem.objective(newP)));
        }
        return evaluatedSolutions;
    }
}
