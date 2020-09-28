package live.algorithm.ls;

import live.algorithm.AbstractSMetaheuristic;
import live.algorithm.TerminalCondition;
import live.algorithm.UpdateStrategy;
import live.base.OptimizationProblem;
import live.base.SolutionGenerator;

public class LocalSearch extends AbstractSMetaheuristic {

    private UpdateStrategy updateStrategy;
    public LocalSearch(UpdateStrategy strategy, TerminalCondition condition, SolutionGenerator solutionGenerator, boolean printSteps){
        super(condition,solutionGenerator,printSteps);
        this.updateStrategy = strategy;
    }

    @Override
    protected void updateCurrentSolution(OptimizationProblem problem) {
        currentSolution = updateStrategy.getNextSolution(problem,currentSolution);
    }
}
