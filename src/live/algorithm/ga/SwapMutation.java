package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.base.SimpleEvaluatedSolution;
import live.problems.tsp.Permutation;
import live.util.RandomUtil;

/**
 * @author taylanakbas
 **/
public class SwapMutation implements Mutation{
    @Override
    public EvaluatedSolution apply(OptimizationProblem problem, EvaluatedSolution solution) {
        Permutation p = (Permutation) solution.getSolution().clone();
        p.swap(RandomUtil.nextInt(p.length(),0), RandomUtil.nextInt(p.length(),0));
        return new SimpleEvaluatedSolution(p,problem.objective(p));
    }
}
