package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.util.RandomUtil;

import java.util.ArrayList;

/**
 * @author taylanakbas
 **/
public class RandomReplacement implements Replacement {
    @Override
    public void replace(OptimizationProblem problem, Population population, ArrayList<EvaluatedSolution> offsprings) {
        for (int i = 0; i < offsprings.size(); i++) {
            population.getPopulation().set(RandomUtil.nextInt(population.size(),0),offsprings.get(i));
        }
    }
}
