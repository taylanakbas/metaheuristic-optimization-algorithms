package live.algorithm.ga;

import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.base.SimpleEvaluatedSolution;
import live.problems.tsp.Permutation;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author taylanakbas
 **/
public class RandomPermutationPG implements InitialPopulationGenerator{
    int size;
    public RandomPermutationPG(int size){
        this.size = size;
    }

    EvaluatedSolution generate(OptimizationProblem problem){
        ArrayList<Integer> nodeList= new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            nodeList.add(i);
        }
        Collections.shuffle(nodeList);
        int nodes[] = new int[size];
        for (int i = 0; i < nodeList.size(); i++) {
            nodes[i] = nodeList.get(i);
        }
        Permutation p = new Permutation(nodes);
        return new SimpleEvaluatedSolution(p, problem.objective(p));

    }

    @Override
    public Population generate(OptimizationProblem problem, int populationSize) {

        Population population = new SimplePopulation();
        for (int i = 0; i < populationSize; i++) {
            EvaluatedSolution solution = generate(problem);
            population.add(solution);
        }
        return population;
    }
}
