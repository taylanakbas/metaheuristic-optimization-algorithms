package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.util.RandomUtil;

import java.util.ArrayList;

/**
 * @author taylanakbas
 **/
public class RoulletteWheelSelection  implements ParentSelector{

    @Override
    public ArrayList<EvaluatedSolution> selectParents(OptimizationProblem problem, Population population) {

        ArrayList<EvaluatedSolution> solutions = population.getPopulation();
        ArrayList<Double> fitnessList = new ArrayList<>();
        double totalFitness = 0;
        for (int i = 0; i < solutions.size() ; i++) {
            fitnessList.add(i,solutions.get(i).getCost());
            totalFitness += fitnessList.get(i);
        }

        ArrayList<Double> probabilities = new ArrayList<>();
        for (int i = 0; i < solutions.size(); i++) {
            probabilities.add(i,fitnessList.get(i)/ totalFitness);
        }
        double sum = 0;
        double rnd = RandomUtil.nextDouble();
        ArrayList<EvaluatedSolution> parents = new ArrayList<>();
        for (int i = 0; i < probabilities.size(); i++) {
            sum += probabilities.get(i);
            if (sum >= rnd) parents.add(solutions.get(i));
            if(parents.size() == 2) break;
        }
        return parents;
    }
}
