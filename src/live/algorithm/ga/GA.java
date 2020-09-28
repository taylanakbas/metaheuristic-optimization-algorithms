package live.algorithm.ga;

import live.algorithm.AbstractMetaheuristic;
import live.algorithm.TerminalCondition;
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.util.RandomUtil;
import java.util.ArrayList;

/**
 * @author taylanakbas
 **/
public class GA extends AbstractMetaheuristic {

    Population population;
    InitialPopulationGenerator initialPopulationGenerator;
    int populationSize;
    int maxIteration;
    ParentSelector parentSelector;
    CrossOver crossOver;
    Mutation mutation;
    Replacement replacement;
    double mutationRate;
    double crossOverRate;
    int iterationCount;

    public GA(InitialPopulationGenerator initialPopulationGenerator, ParentSelector parentSelector, CrossOver crossOver, Mutation mutation, Replacement replacement, int populationSize, double mutationRate, double crossOverRate, int maxIteration) {
        this.initialPopulationGenerator = initialPopulationGenerator;
        this.maxIteration = maxIteration;
        this.parentSelector = parentSelector;
        this.populationSize = populationSize;
        this.crossOver = crossOver;
        this.mutation = mutation;
        this.replacement = replacement;
        this.mutationRate = mutationRate;
        this.crossOverRate = crossOverRate;
        this.iterationCount = 0;
    }

    @Override
    protected void init (OptimizationProblem problem){
        population = initialPopulationGenerator.generate(problem, populationSize);
    }

    @Override
    protected void perform(OptimizationProblem problem) {
        while (iterationCount<=maxIteration) {
            ArrayList<EvaluatedSolution> parents = parentSelector.selectParents(problem, population);
            ArrayList<EvaluatedSolution> newParents = applyMutation(problem, parents);
            ArrayList<EvaluatedSolution> offsprings = applyCrossOver(problem, newParents);
            replacePopulation(problem, population, offsprings);
            iterationCount++;
        }
    }

    private void replacePopulation(OptimizationProblem problem, Population population, ArrayList<EvaluatedSolution> offsprings) {
        replacement.replace(problem, population, offsprings);
    }

    private ArrayList<EvaluatedSolution> applyCrossOver(OptimizationProblem problem, ArrayList<EvaluatedSolution> parents) {
        ArrayList<EvaluatedSolution> offsprings = new ArrayList<>();
        for (int i = 0; i < parents.size() - 1; i++) {
            for (int j = i + 1; j < parents.size(); j++) {
                EvaluatedSolution parent1 = parents.get(i);
                EvaluatedSolution parent2 = parents.get(j);
                if (RandomUtil.nextBoolean(crossOverRate)) {
                    EvaluatedSolution offspring = crossOver.apply(problem, parent1, parent2);
                    offsprings.add(offspring);
                }
            }
        }
        return offsprings;
    }

    private ArrayList<EvaluatedSolution> applyMutation(OptimizationProblem problem, ArrayList<EvaluatedSolution> parents) {
        ArrayList<EvaluatedSolution> mutatedList = new ArrayList<>();
        for (int i = 0; i < parents.size(); i++) {
            EvaluatedSolution mutated = parents.get(i);
            if (RandomUtil.nextBoolean(mutationRate)) {
                mutated = mutation.apply(problem, parents.get(i));
            }
            mutatedList.add(mutated);
        }
        return mutatedList;
    }
}
