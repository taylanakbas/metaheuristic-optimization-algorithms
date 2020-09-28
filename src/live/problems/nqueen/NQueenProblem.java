package live.problems.nqueen;

import live.algorithm.AbstractSMetaheuristic;
import live.algorithm.Metaheuristic;
import live.algorithm.ls.LocalSearch;
import live.algorithm.ls.RandomUS;
import live.algorithm.terminalcondition.MaxIterationTC;
import live.base.OptimizationProblem;
import live.base.Solution;

public class NQueenProblem implements OptimizationProblem {
    int n;
    public NQueenProblem(int n){ this.n = n; }
    public int getN(){ return n; }
    @Override
    public double objective(Solution s) {
        Permutation p = (Permutation) s;
        double cost = 0;
        for (int i = 0; i < p.length(); i++) {
            for (int j = i+1; j < p.length() ; j++) {
                if (Math.abs(p.getNode(i) - p.getNode(j)) == Math.abs(j-i)){
                    cost += 1;
                }
            }
        }
        return cost;
    }

    @Override
    public boolean isFeasible(Solution s) {
        Permutation p = (Permutation) s;
        return p.length() == n;
    }

    @Override
    public boolean isMinimisation() {
        return true;
    }

    public static void main(String[] args) {

        int n = 10;
        NQueenProblem problem = new NQueenProblem(n);

        Metaheuristic alg = new LocalSearch(new RandomUS( new SwapNG(),true),
                new MaxIterationTC(1000),
                new RandomPermutationSG(n),
                true);
        alg.solve(problem);

    }
}
