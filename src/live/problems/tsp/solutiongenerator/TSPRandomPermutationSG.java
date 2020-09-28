package live.problems.tsp.solutiongenerator;
/**
 * author:taylanakbas
 */

import live.base.OptimizationProblem;
import live.base.EvaluatedSolution;
import live.base.SimpleEvaluatedSolution;
import live.base.SolutionGenerator;

import live.problems.tsp.Permutation;

import java.util.ArrayList;
import java.util.Collections;


public class TSPRandomPermutationSG implements SolutionGenerator {
    int n;
    public TSPRandomPermutationSG(int n){ this.n = n; }
    @Override
    public EvaluatedSolution generate(OptimizationProblem problem) {
        ArrayList<Integer> nodeList= new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodeList.add(i);
        }
        Collections.shuffle(nodeList);
        int nodes[] = new int[n];
        for (int i = 0; i < nodeList.size(); i++) {
            nodes[i] = nodeList.get(i);
        }
        Permutation p = new Permutation(nodes);
        return new SimpleEvaluatedSolution(p, problem.objective(p));
    }
}
