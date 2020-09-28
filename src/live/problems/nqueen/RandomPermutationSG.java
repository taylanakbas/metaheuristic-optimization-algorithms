package live.problems.nqueen;


import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.base.SimpleEvaluatedSolution;

import live.base.SolutionGenerator;

import java.util.ArrayList;
import java.util.Collections;


public class RandomPermutationSG implements SolutionGenerator {

    int size;
    public RandomPermutationSG(int size){ this.size = size;}

    @Override
    public EvaluatedSolution generate(OptimizationProblem problem) {
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
}


