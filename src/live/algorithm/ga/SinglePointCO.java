package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.base.SimpleEvaluatedSolution;
import live.problems.tsp.Permutation;
import live.util.RandomUtil;

/**
 * @author taylanakbas
 **/
public class SinglePointCO implements CrossOver {
    @Override
    public EvaluatedSolution apply(OptimizationProblem problem, EvaluatedSolution parent1, EvaluatedSolution parent2) {

        Permutation p1 = (Permutation) parent1.getSolution().clone();
        Permutation p2 = (Permutation) parent2.getSolution().clone();
        int length = p1.length();
        int[] offspring = new int[length];
        int p = RandomUtil.nextInt(length-1,0);
        for (int i = 0; i < length - 1; i++) {
            if(i < p) offspring[i] = p1.get(i);
            else offspring[i] = p2.get(i);
        }
        Permutation solution = new Permutation(offspring);
        return new SimpleEvaluatedSolution(solution,problem.objective(solution));
    }
}
