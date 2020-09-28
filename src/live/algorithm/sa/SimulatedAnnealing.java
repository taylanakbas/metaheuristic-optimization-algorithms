package live.algorithm.sa;
/**
 * author:taylanakbas
 **/
import live.algorithm.AbstractSMetaheuristic;
import live.algorithm.TerminalCondition;
import live.algorithm.UpdateStrategy;
import live.base.OptimizationProblem;
import live.base.SolutionGenerator;

public class SimulatedAnnealing extends AbstractSMetaheuristic {

    private UpdateStrategy updateStrategy;
    public SimulatedAnnealing(UpdateStrategy strategy,TerminalCondition terminalCondition, SolutionGenerator solutionGenerator, boolean printSteps){
        super(terminalCondition, solutionGenerator, printSteps);
        this.updateStrategy = strategy;
    }

    @Override
    protected void updateCurrentSolution(OptimizationProblem problem) {
        currentSolution = updateStrategy.getNextSolution(problem, currentSolution);
    }
}
