package live.algorithm.ls;

import live.algorithm.UpdateStrategy;
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

public class RandomUS implements UpdateStrategy {

    boolean selectBetter;
    private NeighborGenerator neighborGenerator;
    public RandomUS(NeighborGenerator neighborGenerator, boolean selectBetter){
        this.neighborGenerator = neighborGenerator;
        this.selectBetter = selectBetter;
    }

    @Override
    public EvaluatedSolution getNextSolution(OptimizationProblem problem, EvaluatedSolution currentSolution) {

        ArrayList<EvaluatedSolution> solutions =  generateNeighbors(problem,currentSolution,selectBetter);
        if(solutions.isEmpty())
            return null;
        Random rng = new SecureRandom();
        return solutions.get(rng.nextInt(solutions.size()));
    }

    private ArrayList<EvaluatedSolution> generateNeighbors(OptimizationProblem problem, EvaluatedSolution currentSolution, boolean selectBetter) {
        ArrayList<EvaluatedSolution> solutions = neighborGenerator.generate(problem,currentSolution);
        solutions.removeIf(new Predicate<EvaluatedSolution>() {
            @Override
            public boolean test(EvaluatedSolution solution) {
                return ( problem.isMinimisation() && currentSolution.getCost() <= solution.getCost()) || (!problem.isMinimisation() && currentSolution.getCost() >= solution.getCost());
            }
        });
        return solutions;
    }
}
